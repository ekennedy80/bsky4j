package api.rest.app.bsky.actor.preferences.defs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContentLabelPref extends AbstractPreferenceDef {

    @Nullable
    @JsonProperty("labelerDid")
    private String labelerDid;

    @Nonnull
    @JsonProperty("label")
    private String label;

    @Nonnull
    @JsonProperty("visibility")
    private String visibility;

    @Override
    public ObjectNode asJsonObject() {
        return json.put("labelerDid", this.labelerDid)
                .put("label", this.label)
                .put("visibility", visibility.toString());
    }

    @Override
    public String asJsonString() {
        return json.put("labelerDid", this.labelerDid)
                .put("label", this.label)
                .put("visibility", visibility.toString()).toString();
    }
}
