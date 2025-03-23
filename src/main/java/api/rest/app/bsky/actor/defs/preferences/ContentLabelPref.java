package api.rest.app.bsky.actor.defs.preferences;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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

}
