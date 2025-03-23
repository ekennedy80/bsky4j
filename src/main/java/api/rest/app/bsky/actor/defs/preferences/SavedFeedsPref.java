package api.rest.app.bsky.actor.defs.preferences;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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

}
