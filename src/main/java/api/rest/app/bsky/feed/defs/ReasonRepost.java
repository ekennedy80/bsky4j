package api.rest.app.bsky.feed.defs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import api.rest.JsonFluentObject;
import api.rest.app.bsky.actor.defs.profile.ProfileViewBasic;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReasonRepost extends JsonFluentObject {

    @JsonProperty("by")
    private ProfileViewBasic by;

    @Nullable
    @JsonProperty("indexedAt")
    private Date indexedAt;

    @JsonSetter("indexedAt")
    public void setIndexedAt(String date) throws ParseException {
        if (date != null) {
            if (date.contains(":") || date.contains("T") || date.contains("Z")) {
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                this.indexedAt = inputFormat.parse(date);
            } else {
                this.indexedAt = new Date(Long.parseLong(date));
            }
        }
    }
}
