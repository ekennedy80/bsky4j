package api.rest.app.bsky.actor.preferences.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.Nonnull;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
public class LabelersPref extends AbstractPreference {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class Labelers {
        @Nonnull
        @JsonProperty("did")
        private List<String> did;
    }

    @Nonnull
    @JsonProperty("labelers")
    private List<Labelers> labelers;

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
