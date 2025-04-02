package org.example;

import api.rest.app.bsky.actor.ActorHandler;
import api.rest.app.bsky.actor.defs.profile.ProfileViewDetailed;
import api.rest.com.atproto.server.BskySession;
import api.rest.com.atproto.server.ServerHandler;
import api.rest.graph.GraphHandler;
import api.rest.graph.defs.KnownFollowers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static api.rest.GlobalVars.*;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws JsonProcessingException {

        ServerHandler serverHandler = ServerHandler.getInstance();
        ActorHandler actorHandler = ActorHandler.getInstance();
        // FeedHandler feedHandler = FeedHandler.getInstance();
        GraphHandler graphHandler = GraphHandler.getInstance();

        BskySession session = serverHandler.createSession(true, HANDLE, APP_TOKEN, null);
        if (LOGGER.isInfoEnabled())
            LOGGER.info("********** SESSION **********\n{}", session.asJsonString());

        ProfileViewDetailed profile = actorHandler.getProfile(serverHandler.getSession().getAccessJwt(), HANDLE);
        if (LOGGER.isInfoEnabled())
            LOGGER.info(profile.asJsonString());

        // ActorLikes actorLikes =
        // feedHandler.getActorLikes(serverHandler.getSession().getAccessJwt(), HANDLE,
        // 100, null);
        // if(LOGGER.isInfoEnabled())
        // LOGGER.info(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(actorLikes));

        // SuggestedFeeds suggestedFeeds =
        // feedHandler.getSuggestedFeeds(serverHandler.getSession().getAccessJwt(), 50,
        // null);
        // if(LOGGER.isInfoEnabled())
        // LOGGER.info(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(suggestedFeeds));

        // Timeline timeline =
        // feedHandler.getTimeline(serverHandler.getSession().getAccessJwt(), null, 100,
        // null);
        // if(LOGGER.isInfoEnabled())
        // LOGGER.info(timeline.asJsonString());

        // SearchPosts searchPosts =
        // feedHandler.searchPosts(serverHandler.getSession().getAccessJwt(), "good
        // morning from VB",
        // "latest", "2024-11-10", "2025-03-23", null, null, null,
        // // null, null, null, null, null);
        // if(LOGGER.isInfoEnabled())
        // LOGGER.info(searchPosts.asJsonString());

        KnownFollowers knownFollowers = graphHandler.getKnownFollowers(serverHandler.getSession().getAccessJwt(), HANDLE, 50, null);
        if (LOGGER.isInfoEnabled())
            LOGGER.info(knownFollowers.asJsonString());

        serverHandler.close();
    }

}
