package api.rest.app.bsky.feed.defs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
    
    @JsonSerialize(using = RootSerializer.class)
    @JsonDeserialize(using = RootDeserializer.class)
    @JsonProperty("root")
    private JsonFluentObject root;

    @JsonSerialize(using = RootSerializer.class)
    @JsonDeserialize(using = RootDeserializer.class)
    @JsonProperty("parent")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private JsonFluentObject parent;

    @JsonProperty("grandparentAuthor")
    private ProfileViewBasic grandparentAuthor;
    
    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectNode json = new ObjectMapper().createObjectNode();
        return json.put("root", root.asJsonString())
            .put("parent", parent.asJsonString())
            .put("grandparentAuthor", grandparentAuthor.asJsonString());
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        return asJsonObject().toPrettyString();
    }

    
    
}
