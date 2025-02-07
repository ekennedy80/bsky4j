package api.rest.app.bsky.actor.profile.defs;

import api.rest.app.bsky.actor.object.Associated;
import api.rest.app.bsky.actor.preferences.defs.LabelersPref;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KnownFollowersDef {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class Followers {

        @Nonnull
        @JsonProperty("did")
        private String did;

        @Nonnull
        @JsonProperty("handle")
        private String handle;

        @Nullable
        @JsonProperty("displayName")
        private String displayName;

        @Nullable
        @JsonProperty("avatar")
        private URI avatar;

        @Nullable
        @JsonProperty("associated")
        private Associated associated;

        @Nullable
        @JsonProperty("labels")
        private LabelersPref labels;

        @Nullable
        @JsonProperty("createdAt")
        private Date createdAt;

        @JsonSetter("createdAt")
        public void setCreatedAt(String date) throws ParseException {
            if (date != null) {
                if (date.contains(":") || date.contains("T") || date.contains("Z")) {
                    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                    this.createdAt = inputFormat.parse(date);
                } else {
                    this.createdAt = new Date(Long.parseLong(date));
                }
            }
        }
    }

    @Nonnull
    @JsonProperty("count")
    private Integer count;

    @Nonnull
    @JsonProperty("followers")
    private List<Followers> followers;

}
