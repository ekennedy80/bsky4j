package org.example;


import api.rest.app.bsky.feed.FeedHandler;
import api.rest.app.bsky.feed.defs.Timeline;
import api.rest.com.atproto.server.BskySession;
import api.rest.com.atproto.server.ServerHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static api.rest.GlobalVars.*;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws JsonProcessingException {
        //ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.enable(StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION);

        ObjectMapper objectMapper = JsonMapper.builder().enable(StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION).build();
        ServerHandler serverHandler = ServerHandler.getInstance();
        // ActorHandler actorHandler = ActorHandler.getInstance();
        FeedHandler feedHandler = FeedHandler.getInstance();

        BskySession session = serverHandler.createSession(true, HANDLE, APP_TOKEN, null);
        if(LOGGER.isInfoEnabled())
            LOGGER.info("********** SESSION **********\n{}",session.asJsonString());

        // ProfileViewDetailed profile = actorHandler.getProfile(serverHandler.getSession().getAccessJwt(), HANDLE);
        // if(LOGGER.isInfoEnabled())
        //     LOGGER.info(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(profile));

        // ActorLikes actorLikes = feedHandler.getActorLikes(serverHandler.getSession().getAccessJwt(), HANDLE, 100, null);
        // if(LOGGER.isInfoEnabled())
        //     LOGGER.info(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(actorLikes));

        // SuggestedFeeds suggestedFeeds = feedHandler.getSuggestedFeeds(serverHandler.getSession().getAccessJwt(), 50, null);
        // if(LOGGER.isInfoEnabled())
        //     LOGGER.info(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(suggestedFeeds));

        Timeline timeline = feedHandler.getTimeline(serverHandler.getSession().getAccessJwt(), null, 100, null);
        if(LOGGER.isInfoEnabled())
            LOGGER.info(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(timeline.asJsonString()));

        serverHandler.close();
    }

}
