package api.rest.app.bsky.actor.defs.preferences;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=true)
public class AdultContentPref extends AbstractPreference {

    @Nonnull
    @JsonProperty("enabled")
    @Getter
    @Setter
    private Boolean enabled;

}
