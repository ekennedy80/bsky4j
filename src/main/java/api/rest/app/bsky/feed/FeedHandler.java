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
import api.rest.app.bsky.feed.defs.Quotes;
import api.rest.app.bsky.feed.defs.RepostedBy;
import api.rest.app.bsky.feed.defs.SearchPosts;
import api.rest.app.bsky.feed.defs.SuggestedFeeds;
import api.rest.app.bsky.feed.defs.Timeline;
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

    /**
     * Get posts in a thread. Does not require auth, but additional metadata and
     * filtering will be applied for authed requests.
     * 
     * @param jwtToken
     * @param uri
     * @param depth
     * @param parentHeight
     * @return
     */
    public PostThread getPostThread(@Nonnull String jwtToken, @Nonnull URI uri, @Nullable Integer depth,
            @Nullable Integer parentHeight) {
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

    /**
     * Get a list of quotes for a given post.
     * 
     * @param jwtToken
     * @param uri
     * @param cid
     * @param limit
     * @param cursor
     * @return
     */
    public Quotes getQuotes(@Nonnull String jwtToken, @Nonnull URI uri, @Nullable String cid, @Nullable Integer limit,
            @Nullable String cursor) {
        return client.target(BSKY_URL + GET_QUOTES)
                .queryParam("uri", uri.toString())
                .queryParam("cid", cid)
                .queryParam("limit", limit)
                .queryParam("cursor", cursor)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + jwtToken)
                .get(Quotes.class);
    }

    /**
     * Get a list of reposts for a given post.
     * 
     * @param jwtToken
     * @param uri
     * @param cid
     * @param limit
     * @param cursor
     * @return
     */
    public RepostedBy getRepostedBy(@Nonnull String jwtToken, @Nonnull URI uri, @Nullable String cid,
            @Nullable Integer limit,
            @Nullable String cursor) {
        return client.target(BSKY_URL + GET_REPOSTED_BY)
                .queryParam("uri", uri.toString())
                .queryParam("cid", cid)
                .queryParam("limit", limit)
                .queryParam("cursor", cursor)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + jwtToken)
                .get(RepostedBy.class);
    }

    /**
     * Get a list of suggested feeds (feed generators) for the requesting account.
     * 
     * @param jwtToken
     * @param limit
     * @param cursor
     * @return
     */
    public SuggestedFeeds getSuggestedFeeds(@Nonnull String jwtToken, @Nullable Integer limit,
            @Nullable String cursor) {
        return client.target(BSKY_URL + GET_SUGGESTED_FEEDS)
                .queryParam("limit", limit)
                .queryParam("cursor", cursor)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + jwtToken)
                .get(SuggestedFeeds.class);
    }

    /**
     * Get a view of the requesting account's home timeline. This is expected to be
     * some form of reverse-chronological feed.
     * 
     * @param jwtToken
     * @param algorithm
     * @param limit
     * @param cursor
     * @return
     */
    public Timeline getTimeline(@Nonnull String jwtToken, @Nullable String algorithm, @Nullable Integer limit,
            @Nullable String cursor) {
        return client.target(BSKY_URL + GET_TIMELINE)
                .queryParam("algorithm", algorithm)
                .queryParam("limit", limit)
                .queryParam("cursor", cursor)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + jwtToken)
                .get(Timeline.class);
    }

    /**
     * Find posts matching search criteria, returning views of those posts.
     * 
     * @param jwtToken
     * @param q        Search query string; syntax, phrase, boolean, and faceting is
     *                 unspecified, but Lucene query syntax is recommended.
     * @param sort     Possible values: [top, latest] Specifies the ranking order of
     *                 results. Default value: latest
     * @param since    Filter results for posts after the indicated datetime
     *                 (inclusive). Expected to use 'sortAt' timestamp, which may
     *                 not match 'createdAt'. Can be a datetime, or just an ISO date
     *                 (YYYY-MM-DD).
     * @param until    Filter results for posts before the indicated datetime (not
     *                 inclusive). Expected to use 'sortAt' timestamp, which may not
     *                 match 'createdAt'. Can be a datetime, or just an ISO date
     *                 (YYY-MM-DD).
     * @param mentions Filter to posts which mention the given account. Handles are
     *                 resolved to DID before query-time. Only matches rich-text
     *                 facet mentions.
     * @param author   Filter to posts by the given account. Handles are resolved to
     *                 DID before query-time.
     * @param lang     Filter to posts in the given language. Expected to be based
     *                 on post language field, though server may override language
     *                 detection.
     * @param domain   Filter to posts with URLs (facet links or embeds) linking to
     *                 the given domain (hostname). Server may apply hostname
     *                 normalization.
     * @param url      Filter to posts with links (facet links or embeds) pointing
     *                 to this URL. Server may apply URL normalization or fuzzy
     *                 matching.
     * @param tag      Possible values: <= 640 characters, Filter to posts with the
     *                 given tag (hashtag), based on rich-text facet or tag field.
     *                 Do not include the hash (#) prefix. Multiple tags can be
     *                 specified, with 'AND' matching.
     * @param limit    Possible values: >= 1 and <= 100. Default value: 25
     * @param cursor   Optional pagination mechanism; may not necessarily allow
     *                 scrolling through entire result set.
     * @return
     */
    public SearchPosts searchPosts(@Nonnull String jwtToken, @Nonnull String q, @Nullable String sort,
            @Nullable String since, @Nullable String until, @Nullable URI mentions, @Nullable URI author,
            @Nullable String lang, @Nullable String domain, @Nullable URI url, @Nullable String[] tag,
            @Nullable Integer limit, @Nullable String cursor) {
        ArrayNode jsonArray = new ObjectMapper().createArrayNode();
        for (String str : tag) {
            jsonArray.add(str);
        }
        return client.target(BSKY_URL + SEARCH_POSTS)
                .queryParam("q", q)
                .queryParam("sort", sort)
                .queryParam("since", since)
                .queryParam("until", until)
                .queryParam("mentions", mentions)
                .queryParam("author", author)
                .queryParam("lang", lang)
                .queryParam("domain", domain)
                .queryParam("url", url)
                .queryParam("tag", jsonArray)
                .queryParam("limit", limit)
                .queryParam("cursor", cursor)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + jwtToken)
                .get(SearchPosts.class);
    }

    public void sendInteractions() {

    }
}
