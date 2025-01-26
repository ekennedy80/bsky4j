package api.rest.app.bsky.actor.preferences.defs;

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
@EqualsAndHashCode(callSuper = true)
public class SavedFeedsPrefV2 extends AbstractPreferenceDef {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    static class Items {

        @Nonnull
        @JsonProperty("id")
        private String id;

        @Nonnull
        @JsonProperty("type")
        private String type;

        @Nonnull
        @JsonProperty("value")
        private String value;

        @Nonnull
        @JsonProperty("pinned")
        private Boolean pinned;
    }

    @Nonnull
    @JsonProperty("items")
    private List<Items> items;

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return json.put("items", objectMapper.writeValueAsString(this.items));
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return json.put("items", objectMapper.writeValueAsString(this.items)).toString();
    }
}
