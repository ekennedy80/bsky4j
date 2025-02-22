package api.rest.app.bsky.actor.preferences.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
public class HiddenPostsPref extends AbstractPreference {

    @Nonnull
    @JsonProperty("items")
    private List<URI> items;

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        return null;
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        return "";
    }
}
