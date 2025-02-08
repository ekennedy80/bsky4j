package api.rest.app.bsky.actor.preferences.object;

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
@EqualsAndHashCode(callSuper = false)
public class ContentLabelPref extends AbstractPreference {

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
                .put("visibility", visibility);
    }

    @Override
    public String asJsonString() {
        return json.put("labelerDid", this.labelerDid)
                .put("label", this.label)
                .put("visibility", visibility).toString();
    }
}
