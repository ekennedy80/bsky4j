package api.rest.app.bsky.feed.defs;

import java.net.URI;

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
public class FeedSkeleonPost extends JsonFluentObject {
    
    @JsonProperty("post")
    private URI post;

    @JsonProperty("reason")
    private SkeletonReasonRepost reason;

    @JsonProperty("feedContext")
    private String feedContext;

}
