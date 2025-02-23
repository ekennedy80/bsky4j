package api.rest.app.bsky.actor.defs.preferences;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.*;

import java.net.URI;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper=true)
public class SavedFeedsPref extends AbstractPreference {

    @Nonnull
    @JsonProperty("pinned")
    private List<URI> pinned;

    @Nonnull
    @JsonProperty("label")
    private List<URI> saved;

    @Nullable
    @JsonProperty("timelineIndex")
    private Integer timelineIndex;

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return json.put("pinned", objectMapper.writeValueAsString(this.pinned))
                .put("saved", objectMapper.writeValueAsString(this.saved))
                .put("timelineIndex", this.timelineIndex);
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return json.put("pinned", objectMapper.writeValueAsString(this.pinned))
                .put("saved", objectMapper.writeValueAsString(this.saved))
                .put("timelineIndex", this.timelineIndex).toString();
    }
}
