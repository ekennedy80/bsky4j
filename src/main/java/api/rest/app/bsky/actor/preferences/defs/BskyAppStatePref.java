package api.rest.app.bsky.actor.preferences.defs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class BskyAppStatePref extends AbstractPreferenceDef {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class ActiveProgressGuide {
        @Nonnull
        @JsonProperty("guide")
        private String guide;
    }

    @Data
    @NoArgsConstructor
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
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            this.expiresAt = inputFormat.parse(date);
        }

        public Date getExpiresAt() {
            return expiresAt;
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
        return null;
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        return "";
    }
}
