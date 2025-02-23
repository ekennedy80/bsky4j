package api.rest.app.bsky.feed.defs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.rest.JsonFluentObject;
import api.rest.app.bsky.actor.defs.profile.ProfileViewBasic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReplyRef implements JsonFluentObject {
    
    @JsonProperty("root")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PostView rootPostView;

    // @JsonProperty("root")
    // @JsonInclude(JsonInclude.Include.NON_NULL)
    // private NotFoundPost rootNotFoundPost;

    // @JsonProperty("root")
    // @JsonInclude(JsonInclude.Include.NON_NULL)
    // private BlockedPost rootBlockedPost;

    @JsonProperty("parent")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PostView parentPostView;

    // @JsonProperty("parent")
    // @JsonInclude(JsonInclude.Include.NON_NULL)
    // private NotFoundPost parentNotFoundPost;

    // @JsonProperty("parent")
    // @JsonInclude(JsonInclude.Include.NON_NULL)
    // private BlockedPost parentBlockedPost;

    @JsonProperty("grandparentAuthor")
    private ProfileViewBasic grandparentAuthor;
    
    
    
    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asJsonObject'");
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asJsonString'");
    }

    
    
}
