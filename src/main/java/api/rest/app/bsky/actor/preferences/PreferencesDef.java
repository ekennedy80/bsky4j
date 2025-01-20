package api.rest.app.bsky.actor.preferences;

import api.rest.app.bsky.actor.preferences.defs.AbstractPreferenceDef;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Get private preferences attached to the current account. Expected use is synchronization between multiple devices,
 * and import/export during account migration. Requires auth.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PreferencesDef {

    @Nonnull
    @JsonProperty("preferences")
    private List<AbstractPreferenceDef> preferences;

    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode json = new ObjectMapper().createObjectNode();;
        return json.put("profile", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this));
    }

    public String asJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }
}
