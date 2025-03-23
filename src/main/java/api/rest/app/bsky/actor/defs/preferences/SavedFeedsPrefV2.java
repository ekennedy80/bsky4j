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
@EqualsAndHashCode(callSuper = true)
public class SavedFeedsPrefV2 extends AbstractPreference {

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

}
