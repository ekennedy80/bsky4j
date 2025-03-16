package api.rest.app.bsky.actor.defs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.rest.JsonFluentObject;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssociatedProfile implements JsonFluentObject {

    @Nullable
    @JsonProperty("lists")
    private Integer lists;

    @Nullable
    @JsonProperty("feedgens")
    private Integer feedgens;

    @Nullable
    @JsonProperty("starterPacks")
    private Integer starterPacks;

    @Nullable
    @JsonProperty("labeler")
    private Boolean labeler;

    @Nullable
    @JsonProperty("chat")
    private AssociatedProfileChat chat;

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectNode json = new ObjectMapper().createObjectNode();
        return json.put("lists", this.lists)
            .put("feedgens", this.feedgens)
            .put("starterPacks", this.starterPacks)
            .put("labeler", this.labeler)
            .put("chat", this.chat.asJsonString());
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        return asJsonObject().toPrettyString();
    }

}
