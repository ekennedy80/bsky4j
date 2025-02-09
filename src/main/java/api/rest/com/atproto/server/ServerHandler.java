package api.rest.com.atproto.server;

import api.rest.app.bsky.AbstractClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.Nonnull;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.Getter;

import java.util.Date;

import static api.rest.GlobalVars.*;

public class ServerHandler extends AbstractClient {



    @Getter
    private BskySession session;

    @Getter
    private Date sessionModifiedAt;

    public ServerHandler() {
        super();
    }

    /**
     * Create a Bluesky authentication session.
     * @param identifier Handle or other identifier supported by the server for the authenticating user.
     * @param password
     * @param authFactorToken Used for 2FA
     * @return Bluesky auth session
     */
    public BskySession createSession(@Nonnull String identifier, @Nonnull String password, String authFactorToken) {
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
            session = response.readEntity(BskySession.class);
            sessionModifiedAt = new Date();
            return session;
        }
    }

    /**
     * Create a Bluesky authentication session. Kicks off a thread that refreshes the session every two minutes.
     */
    public void createSession() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode user = mapper.createObjectNode();
        user.put("identifier", HANDLE);
        user.put("password", APP_TOKEN);
        try (Response response = client.target(BSKY_URL + CREATE_SESSION)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(user.toString()))) {
            session = response.readEntity(BskySession.class);
            sessionModifiedAt = new Date();
        }
    }

    /**
     * Delete the current Bluesky auth session. Requires auth.
     * @return HTTP status code
     */
    public int deleteSession() {
        try (Response response = client.target(BSKY_URL + DELETE_SESSION)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + session.getRefreshJwt())
                .post(Entity.json(""))) {
            return response.getStatus();
        }
    }

    /**
     * Get information about the current auth session. Requires auth.
     * @return A Bluesky auth session
     */
    public BskySession getCurrentSession() {
        try (Response response = client.target(BSKY_URL + GET_SESSION)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + session.getAccessJwt())
                .get()) {
            return response.readEntity(BskySession.class);
        }
    }

    /**
     * Refresh an authentication session. Requires auth using the 'refreshJwt' (not the 'accessJwt').
     */
    public void refreshSession() {
        try (Response response = client.target(BSKY_URL + REFRESH_SESSION)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + session.getRefreshJwt())
                .post(Entity.json(""))) {
            session = response.readEntity(BskySession.class);
            sessionModifiedAt = new Date();
        }
    }

    /**
     * Refresh an authentication session. Requires auth using the 'refreshJwt' (not the 'accessJwt').
     * @param refreshJWT
     * @return Bluesky auth session.
     */
    public BskySession refreshSession(String refreshJWT) {
        try (Response response = client.target(BSKY_URL + REFRESH_SESSION)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + refreshJWT)
                .post(Entity.json(""))) {
            session = response.readEntity(BskySession.class);
            sessionModifiedAt = new Date();
            return session;
        }
    }
}
