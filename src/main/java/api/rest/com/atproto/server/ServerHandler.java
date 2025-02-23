package api.rest.com.atproto.server;

import api.rest.app.bsky.AbstractClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.Nonnull;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


import static api.rest.GlobalVars.*;

public class ServerHandler extends AbstractClient {

    private static final Logger LOGGER = LogManager.getLogger(ServerHandler.class);

    @Getter
    private BskySession session;

    private ScheduledExecutorService scheduler;

    @Getter
    private Date sessionModifiedAt = null;

    @Getter
    private Date sessionCreatedAt = null;

    @Getter
    private Date sessionDeletedAt = null;

    private ServerHandler() {
        super();
    }

    private static class SingletonHelper {
        private static final ServerHandler INSTANCE = new ServerHandler();
    }

    public static ServerHandler getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void sessionRefresher(int intervalMinutes) {
        LOGGER.debug("Starting session refresher thread.");
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::refreshSession, 2, intervalMinutes, TimeUnit.MINUTES);
    }

    @Override
    public void close() {
        LOGGER.debug("Stopping session refresher thread and ");
        scheduler.close();
        super.close();
    }

    /**
     * Create a Bluesky authentication session.
     * @param identifier Handle or DID supported by the server for the authenticating user.
     * @param password
     * @param authFactorToken Used for 2FA
     * @return Bluesky auth session
     */
    public BskySession createSession(boolean autoRefresh, @Nonnull String identifier, @Nonnull String password, String authFactorToken) {
        LOGGER.info("Creating a Bluesky session for authentication for {}.", identifier);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode user = mapper.createObjectNode();
        user.put("identifier", identifier);
        user.put("password", password);
        if(authFactorToken != null) {
            user.put("authFactorToken", authFactorToken);
        }
        try (Response response = client.target(BSKY_URL + CREATE_SESSION)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(user.toString()))) {
            this.session = response.readEntity(BskySession.class);
            sessionCreatedAt = sessionModifiedAt = new Date();
            if(autoRefresh) {
                sessionRefresher(2);
            }
            return this.session;
        }
    }

    /**
     * Create a Bluesky authentication session. Kicks off a thread that refreshes the session every two minutes.
     */
    public void createSession(boolean autoRefresh) {
        LOGGER.info("Creating a Bluesky session for authentication.");
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode user = mapper.createObjectNode();
        user.put("identifier", HANDLE);
        user.put("password", APP_TOKEN);
        try (Response response = client.target(BSKY_URL + CREATE_SESSION)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(user.toString()))) {
            this.session = response.readEntity(BskySession.class);
            sessionCreatedAt = sessionModifiedAt = new Date();
            if(autoRefresh) {
                sessionRefresher(2);
            }
        }
    }

    /**
     * Delete the current Bluesky auth session. Requires auth.
     * @return HTTP status code
     */
    public int deleteSession() {
        LOGGER.info("Deleting session.");
        try (Response response = client.target(BSKY_URL + DELETE_SESSION)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + this.session.getRefreshJwt())
                .post(Entity.json(""))) {
            return response.getStatus();
        }
    }

    /**
     * Get information about the current auth session. Requires auth.
     * @return A Bluesky auth session
     */
    public BskySession getCurrentSession() {
        LOGGER.info("Getting current session.");
        try (Response response = client.target(BSKY_URL + GET_SESSION)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + this.session.getAccessJwt())
                .get()) {
            return response.readEntity(BskySession.class);
        }
    }

    /**
     * Refresh an authentication session. Requires auth using the 'refreshJwt' (not the 'accessJwt').
     */
    public void refreshSession() {
        LOGGER.info("Refreshing Bluesky session.");
        try (Response response = client.target(BSKY_URL + REFRESH_SESSION)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + this.session.getRefreshJwt())
                .post(Entity.json(""))) {
            this.session = response.readEntity(BskySession.class);
            sessionModifiedAt = new Date();
        }
    }

    /**
     * Refresh an authentication session. Requires auth using the 'refreshJwt' (not the 'accessJwt').
     * @param refreshJWT
     * @return Bluesky auth session.
     */
    public BskySession refreshSession(String refreshJWT) {
        LOGGER.info("Refreshing Bluesky session using {}.",refreshJWT);
        try (Response response = client.target(BSKY_URL + REFRESH_SESSION)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + refreshJWT)
                .post(Entity.json(""))) {
            this.session = response.readEntity(BskySession.class);
            sessionModifiedAt = new Date();
            return this.session;
        }
    }
}
