package api.rest.app.bsky.actor.defs.preferences;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
public class MutedWordsPref extends AbstractPreference {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Items {

        public enum ActorTarget {
            ALL("all"),
            EXCLUDE_FOLLOWING("exclude-following");

            private final String value;

            ActorTarget(String value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return this.value;
            }
        }

        @Nonnull
        @JsonProperty("id")
        private String id;

        @Nonnull
        @JsonProperty("value")
        private String value;

        @Nullable
        @JsonProperty("targets")
        private List<String> targets;

        @Nullable
        @JsonProperty("actorTarget")
        private ActorTarget actorTarget;

        @Nullable
        @JsonProperty("expiresAt")
        private Date expiresAt;

        @JsonSetter("expiresAt")
        public void setExpiresAt(String date) throws ParseException {
            if (date != null && Long.parseLong(date) > 0) {
                if (date.contains("-") || date.contains(":") || date.contains("T") || date.contains(".") || date.contains("Z")) {
                    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                    this.expiresAt = inputFormat.parse(date);
                } else {
                    this.expiresAt = new Date(Long.parseLong(date));
                }
            }
        }
    }

    @Nonnull
    @JsonProperty("items")
    private List<Items> items;

}
