package api.rest.app.bsky.feed.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.rest.JsonFluentObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * List of posts liked by an actor. Requires auth, actor must be the requesting account.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActorLikes implements JsonFluentObject {

    @JsonProperty("cursor")
    private String cursor;

    @JsonProperty("feed")
    private List<Feed> feed;

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectNode json = new ObjectMapper().createObjectNode();
        return json.set("ActorLikes", new ObjectMapper().valueToTree(this));
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        return asJsonObject().toPrettyString();
    }
    
}
