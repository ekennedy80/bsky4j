package api.rest.app.bsky.feed.defs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.rest.JsonFluentObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedViewPost implements JsonFluentObject {
    
    //type: app.bsky.feed.defs#feedViewPost

    @JsonProperty("post")
    private PostView post;

    @JsonProperty("reply")
    private ReplyRef reply;

    @JsonProperty("reason") // reasonPin??
    private ReasonRepost reasonRepost;

    @JsonProperty("feedContext")
    private String feedContext;

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectNode json = new ObjectMapper().createObjectNode();
        return json.put("post", this.post.asJsonString())
            .put("reply", reply.asJsonString())
            .put("reason", reasonRepost.asJsonString())
            .put("feedContext", feedContext);
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        return asJsonObject().toPrettyString();
    }

}
