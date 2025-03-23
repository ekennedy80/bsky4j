package api.rest.app.bsky.feed.defs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedViewPost extends JsonFluentObject {
    
    //type: app.bsky.feed.defs#feedViewPost

    @JsonProperty("post")
    private PostView post;

    @JsonProperty("reply")
    private ReplyRef reply;

    @JsonProperty("reason") // reasonPin??
    private ReasonRepost reasonRepost;

    @JsonProperty("feedContext")
    private String feedContext;

}
