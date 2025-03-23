package api.rest.app.bsky.actor.defs.preferences;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
public class LabelersPref extends AbstractPreference {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class Labelers {
        @Nonnull
        @JsonProperty("did")
        private List<String> did;
    }

    @Nonnull
    @JsonProperty("labelers")
    private List<Labelers> labelers;

}
