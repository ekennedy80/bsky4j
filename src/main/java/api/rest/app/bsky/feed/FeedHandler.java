package api.rest.app.bsky.feed;

import api.rest.app.bsky.AbstractClient;
import api.rest.app.bsky.feed.defs.ActorLikes;
import api.rest.app.bsky.feed.defs.AuthorFeed;
import api.rest.app.bsky.feed.defs.DescribeFeedGenerator;
import api.rest.app.bsky.feed.defs.Feed;
import api.rest.app.bsky.feed.defs.FeedGenerator;
import api.rest.app.bsky.feed.defs.FeedGenerators;
import api.rest.app.bsky.feed.defs.FeedSkeleton;
import api.rest.app.bsky.feed.defs.Feeds;
import api.rest.app.bsky.feed.defs.Likes;
import api.rest.app.bsky.feed.defs.PostThread;
import api.rest.app.bsky.feed.defs.Posts;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.ws.rs.core.MediaType;

import static api.rest.GlobalVars.*;

import java.net.URI;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class FeedHandler extends AbstractClient {

    private static final Logger LOGGER = LogManager.getLogger(FeedHandler.class);

    public FeedHandler() {
        super();
        LOGGER.debug("Instantiating ActorHandler.");
    }

    private static class SingletonHelper {
        private static final FeedHandler INSTANCE = new FeedHandler();
    }

    public static FeedHandler getInstance() {
        return SingletonHelper.INSTANCE;
    }

    // TODO: Fix jakarta.ws.rs.NotFoundException: HTTP 404 Not Found error
    public DescribeFeedGenerator describeFeedGenerator(String jwtToken) {
        return client.target(BSKY_URL + DESCRIBE_FEED_GENERATOR)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + jwtToken)
                .get(DescribeFeedGenerator.class);
    }

    // TODO: Create actor feeds json objects
    public ObjectNode getActorFeeds(String jwtToken, String actor, Integer limit, String cursor) {
        return client.target(BSKY_URL + GET_ACTOR_FEEDS)
                .queryParam("actor", actor)
                .queryParam("limit", limit)
                .queryParam("cursor", cursor)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + jwtToken)
                .get(ObjectNode.class);
    }

    /**
     * Get a list of posts liked by an actor. Requires auth, actor must be the
     * requesting account.
     * 
     * @param jwtToken
     * @param actor
     * @param limit
     * @param cursor
     * @return
     */
    public ActorLikes getActorLikes(String jwtToken, String actor, Integer limit, String cursor) {
        return client.target(BSKY_URL + GET_ACTOR_LIKES)
                .queryParam("actor", actor)
                .queryParam("limit", limit)
                .queryParam("cursor", cursor)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + jwtToken)
                .get(ActorLikes.class);
    }

    /**
     * Get a view of an actor's 'author feed' (post and reposts by the author).
     * 
     * @param jwtToken
     * @param actor
     * @param limit
     * @param cursor
     * @param filter
     * @param includePins
     * @return
     */
    public AuthorFeed getAuthorFeed(@Nonnull String jwtToken, @Nonnull String actor, @Nullable Integer limit,
            @Nullable String cursor, @Nullable String filter,
            @Nullable Boolean includePins) {
        return client.target(BSKY_URL + GET_AUTHOR_FEED)
                .queryParam("actor", actor)
                .queryParam("limit", limit)
                .queryParam("cursor", cursor)
                .queryParam("filter", filter)
                .queryParam("includePins", includePins)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + jwtToken)
                .get(AuthorFeed.class);
    }

    /**
     * Get information about a feed generator. Implemented by AppView.
     * 
     * @param jwtToken
     * @param feed
     * @return
     */
    public FeedGenerator getFeedGenerator(@Nonnull String jwtToken, @Nonnull URI feed) {
        return client.target(BSKY_URL + GET_FEED_GENERATOR)
                .queryParam("feed", feed.toString())
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + jwtToken)
                .get(FeedGenerator.class);
    }

    /**
     * Get information about a list of feed generators.
     * 
     * @param jwtToken
     * @param feeds
     * @return
     */
    public FeedGenerators getFeedGenerators(@Nonnull String jwtToken, @Nonnull Collection<URI> feeds) {
        ArrayNode jsonArray = new ObjectMapper().createArrayNode();
        for (URI uri : feeds) {
            jsonArray.add(uri.toString());
        }
        return client.target(BSKY_URL + GET_FEED_GENERATORS)
                .queryParam("feeds", jsonArray.toString())
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + jwtToken)
                .get(FeedGenerators.class);
    }

    /**
     * Get a skeleton of a feed provided by a feed generator. Auth is optional,
     * depending on provider requirements, and provides the DID of the requester.
     * Implemented by Feed Generator Service.
     * 
     * @param jwtToken
     * @param feed
     * @param limit
     * @param cursor
     * @return
     */
    public FeedSkeleton getFeedSkeleton(@Nonnull String jwtToken, @Nonnull URI feed, @Nullable Integer limit,
            @Nullable String cursor) {
        return client.target(BSKY_URL + GET_FEED_SKELETON)
                .queryParam("feed", feed.toString())
                .queryParam("limit", limit)
                .queryParam("cursor", cursor)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + jwtToken)
                .get(FeedSkeleton.class);
    }

    /**
     * Get a hydrated feed from an actor's selected feed generator. Implemented by
     * App View.
     * 
     * @param jwtToken
     * @param feed
     * @param limit
     * @param cursor
     * @return
     */
    public Feed getFeed(@Nonnull String jwtToken, @Nonnull URI feed, @Nullable Integer limit, @Nullable String cursor) {
        return client.target(BSKY_URL + GET_FEED)
                .queryParam("feed", feed.toString())
                .queryParam("limit", limit)
                .queryParam("cursor", cursor)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + jwtToken)
                .get(Feed.class);
    }

    /**
     * Get like records which reference a subject (by AT-URI and CID).
     * 
     * @param jwtToken
     * @param uri
     * @param cid
     * @param limit
     * @param cursor
     * @return
     */
    public Likes getLikes(@Nonnull String jwtToken, @Nonnull URI uri, @Nullable String cid, @Nullable Integer limit,
            @Nullable String cursor) {
        return client.target(BSKY_URL + GET_LIKES)
                .queryParam("uri", uri.toString())
                .queryParam("cid", cid)
                .queryParam("limit", limit)
                .queryParam("cursor", cursor)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + jwtToken)
                .get(Likes.class);
    }

    /**
     * Get a feed of recent posts from a list (posts and reposts from any actors on
     * the list).
     * 
     * @param jwtToken
     * @param list
     * @param limit
     * @param cursor
     * @return
     */
    public Feeds getListFeed(@Nonnull String jwtToken, @Nonnull URI list, @Nullable Integer limit,
            @Nullable String cursor) {
        return client.target(BSKY_URL + GET_LIST_FEED)
                .queryParam("list", list.toString())
                .queryParam("limit", limit)
                .queryParam("cursor", cursor)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + jwtToken)
                .get(Feeds.class);
    }

    public PostThread getPostThread(@Nonnull String jwtToken, @Nonnull URI uri, @Nullable Integer depth, @Nullable Integer parentHeight) {
        return client.target(BSKY_URL + GET_POST_THREAD)
                .queryParam("uri", uri.toString())
                .queryParam("depth", depth)
                .queryParam("parentHeight", parentHeight)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + jwtToken)
                .get(PostThread.class);
    }

    /**
     * Gets post views for a specified list of posts (by AT-URI). This is sometimes
     * referred to as 'hydrating' a 'feed skeleton'.
     * 
     * @param jwtToken
     * @param uris
     * @return
     */
    public Posts getPosts(@Nonnull String jwtToken, @Nonnull Collection<URI> uris) {
        ArrayNode jsonArray = new ObjectMapper().createArrayNode();
        for (URI uri : uris) {
            jsonArray.add(uri.toString());
        }
        return client.target(BSKY_URL + GET_POSTS)
                .queryParam("uris", jsonArray.toString())
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + jwtToken)
                .get(Posts.class);
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
