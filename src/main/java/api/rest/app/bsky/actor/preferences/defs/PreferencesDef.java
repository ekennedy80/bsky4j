package api.rest.app.bsky.actor.preferences.defs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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

    public String asJsonString() {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return ow.writeValueAsString(preferences);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

//    public ObjectNode getJson() throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return json.put("preferences", objectMapper.writeValueAsString(this.preferences));
//    }
//
//    public String getJsonString() throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return json.put("preferences", objectMapper.writeValueAsString(this.preferences)).toString();
//    }
}
