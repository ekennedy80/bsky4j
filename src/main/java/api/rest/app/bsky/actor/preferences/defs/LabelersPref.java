package api.rest.app.bsky.actor.preferences.defs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LabelersPref extends AbstractPreferenceDef {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Labelers {
        @Nonnull
        @JsonProperty("did")
        private List<String> did;
    }

    @Nonnull
    @JsonProperty("labelers")
    private List<Object> labelers;

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return json.put("labelers", objectMapper.writeValueAsString(this.labelers));
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return json.put("labelers", objectMapper.writeValueAsString(this.labelers)).toString();
    }
}
