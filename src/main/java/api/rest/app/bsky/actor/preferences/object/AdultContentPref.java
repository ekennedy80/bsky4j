package api.rest.app.bsky.actor.preferences.object;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.Nonnull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=true)
public class AdultContentPref extends AbstractPreference {

    @Nonnull
    @JsonProperty("enabled")
    private Boolean enabled;

    public void setEnabled(@Nonnull Boolean enabled) {
        this.enabled = enabled;
    }

    @Nonnull
    public Boolean getEnabled() {
        return this.enabled;
    }

    @Override
    public ObjectNode asJsonObject() {
        return json.put("enabled", this.enabled);
    }

    @Override
    public String asJsonString() {
        return json.put("enabled", this.enabled).toString();
    }
}
