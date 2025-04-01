package api.rest.app.bsky.feed.defs;

import java.net.URI;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import api.rest.JsonFluentObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Interaction extends JsonFluentObject {

    /*
     * Possible values: [app.bsky.feed.defs#requestLess,
     * app.bsky.feed.defs#requestMore, app.bsky.feed.defs#clickthroughItem,
     * app.bsky.feed.defs#clickthroughAuthor,
     * app.bsky.feed.defs#clickthroughReposter,
     * app.bsky.feed.defs#clickthroughEmbed, app.bsky.feed.defs#interactionSeen,
     * app.bsky.feed.defs#interactionLike, app.bsky.feed.defs#interactionRepost,
     * app.bsky.feed.defs#interactionReply, app.bsky.feed.defs#interactionQuote,
     * app.bsky.feed.defs#interactionShare]
     */
    @JsonProperty("event")
    private String event;

    @JsonProperty("item")
    private URI item;

    /*
     * Context on a feed item that was originally supplied by the feed generator on
     * getFeedSkeleton.
     * 
     * Possible values: <= 2000 characters
     */
    @JsonProperty("feedContext")
    private String feedContext;
}
