package api.rest.app.bsky.actor.preferences.defs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.Nonnull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdultContentPref extends PreferenceDef {

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
