package api.rest.app.bsky.actor.suggestions;

import api.rest.app.bsky.actor.suggestions.defs.ActorsDef;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.Nullable;
import lombok.*;

import java.util.List;

/**
 * Get a list of suggested actors. Expected use is discovery of accounts to follow during new account onboarding.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuggestionsDef {

    @Nullable
    @JsonProperty("cursor")
    private String cursor;

    @Nullable
    @JsonProperty("actors")
    private List<ActorsDef> actors;

    @Nullable
    @JsonProperty("recId")
    private Long recId;

    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode json = new ObjectMapper().createObjectNode();
        return json.put("suggestions", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this));
    }

    public String asJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }
}
