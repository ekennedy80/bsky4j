package api.rest.app.bsky.feed.defs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Feed {

    @JsonProperty("post")
    private PostView post;

    @JsonProperty("reply")
    private Reply reply;

    @JsonProperty("reason")
    private Reason reason;

    @JsonProperty("feedContext")
    private String feedContext;
    
}
