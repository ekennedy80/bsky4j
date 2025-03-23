package api.rest.app.bsky.actor.defs.preferences;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import lombok.EqualsAndHashCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
public class ThreadViewPref extends AbstractPreference {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public enum Sort {
        OLDEST("oldest"),
        NEWEST("newest"),
        MOST_LIKES("most-likes"),
        RANDOM("random"),
        HOTNESS("hotness");

        private final String value;

        Sort(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

    @Nullable
    @JsonProperty("sort")
    private Sort sort;

    @Nullable
    @JsonProperty("prioritizeFollowedUsers")
    private Boolean prioritizeFollowedUsers;

}
