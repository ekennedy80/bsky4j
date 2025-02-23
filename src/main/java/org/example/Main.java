package org.example;


import api.rest.app.bsky.actor.ActorHandler;
import api.rest.app.bsky.actor.defs.profile.ProfileViewDetailed;
import api.rest.com.atproto.server.BskySession;
import api.rest.com.atproto.server.ServerHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static api.rest.GlobalVars.*;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        ServerHandler serverHandler = ServerHandler.getInstance();
        ActorHandler actorHandler = ActorHandler.getInstance();

        BskySession session = serverHandler.createSession(true, HANDLE, APP_TOKEN, null);
        if(LOGGER.isInfoEnabled())
            LOGGER.info("********** SESSION **********\n{}",session.asJsonString());

        ProfileViewDetailed profile = actorHandler.getProfile(serverHandler.getSession().getAccessJwt(), HANDLE);
        if(LOGGER.isInfoEnabled())
            LOGGER.info(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(profile));

        serverHandler.close();
    }

}
