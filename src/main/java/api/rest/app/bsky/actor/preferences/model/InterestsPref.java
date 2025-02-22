package api.rest.app.bsky.actor.preferences.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
public class InterestsPref extends AbstractPreference {

    @Nonnull
    @JsonProperty("tags")
    private List<String> tags;

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return json.put("tags", objectMapper.writeValueAsString(this.tags));
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return json.put("tags", objectMapper.writeValueAsString(this.tags)).toString();
    }
}
