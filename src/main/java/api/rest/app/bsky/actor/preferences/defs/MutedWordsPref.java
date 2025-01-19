package api.rest.app.bsky.actor.preferences.defs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MutedWordsPref extends AbstractPreferenceDef {

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
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            this.expiresAt = inputFormat.parse(date);
        }

        public Date getExpiresAt() {
            return expiresAt;
        }
    }

    @Nonnull
    @JsonProperty("items")
    private List<Items> items;

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return json.put("items", objectMapper.writeValueAsString(this.items));
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return json.put("items", objectMapper.writeValueAsString(this.items)).toString();
    }
}
