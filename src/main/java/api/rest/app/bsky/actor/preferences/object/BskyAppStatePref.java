package api.rest.app.bsky.actor.preferences.object;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
public class BskyAppStatePref extends AbstractPreference {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class ActiveProgressGuide {
        @Nonnull
        @JsonProperty("guide")
        private String guide;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    static class Nuxs {
        @Nonnull
        @JsonProperty("id")
        private String id;

        @Nonnull
        @JsonProperty("completed")
        private String completed;

        @Nullable
        @JsonProperty("data")
        private String data;

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

    @Nullable
    @JsonProperty("activeProgressGuide")
    private ActiveProgressGuide activeProgressGuide;

    @Nullable
    @JsonProperty("queuedNudges")
    private List<String> queuedNudges;

    @Nullable
    @JsonProperty("nuxs")
    private List<Nuxs> nuxs;

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode json = new ObjectMapper().createObjectNode();
        return json.put("profile", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this));
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }
}
