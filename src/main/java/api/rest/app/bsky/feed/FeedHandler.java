package api.rest.app.bsky.feed;

import api.rest.app.bsky.AbstractClient;
import api.rest.app.bsky.actor.preferences.Preferences;
import api.rest.app.bsky.feed.model.DescribeFeedGenerator;
import jakarta.ws.rs.core.MediaType;

import static api.rest.GlobalVars.*;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class FeedHandler extends AbstractClient {

    public FeedHandler() {
        super();
    }

    //TODO: Fix jakarta.ws.rs.NotFoundException: HTTP 404 Not Found error
    public DescribeFeedGenerator describeFeedGenerator(String jwtToken) {
        return client.target(BSKY_URL + DESCRIBE_FEED_GENERATOR)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + jwtToken)
                .get(DescribeFeedGenerator.class);
    }

    public DescribeFeedGenerator getActorFeeds(String jwtToken, String actor, Integer limit, String cursor) {
        return client.target(BSKY_URL + DESCRIBE_FEED_GENERATOR)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + jwtToken)
                .get(DescribeFeedGenerator.class);
    }


    public ObjectNode getActorLikes(String jwtToken, String actor, Integer limit, String cursor) {
        return client.target(BSKY_URL + GET_ACTOR_LIKES)
        .queryParam("actor", actor)
        .queryParam("limit", limit)
        .queryParam("cursor", cursor)
        .request(MediaType.APPLICATION_JSON)
        .header(AUTHORIZATION, BEARER+jwtToken)
        .get(ObjectNode.class);
    }

    public void getAuthorFeed() {

    }

    public void getFeedGenerator() {

    }

    public void getFeedGenerators() {

    }

    public void getFeedSkeleton() {

    }

    public void getFeed() {

    }

    public void getLikes() {

    }

    public void getListFeed() {

    }

    public void getPostThread() {

    }

    public void getPosts() {
//        return client.target(BSKY_URL + SEARCH_POSTS)
//                .queryParam("q", query)
//                .queryParam("sort", "top")
//                .queryParam("author", DID)
//                .request(MediaType.APPLICATION_JSON)
//                .header(AUTHORIZATION, BEARER + sessionToken)
//                .get(String.class);
    }

    public void getQuotes() {

    }

    public void getRepostedBy() {

    }

    public void getSuggestedFeeds() {

    }

    public void getTimeline() {

    }

    public void searchPosts() {

    }

    public void sendInteractions() {

    }
}
