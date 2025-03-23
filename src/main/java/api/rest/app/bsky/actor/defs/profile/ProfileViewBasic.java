package api.rest.app.bsky.actor.defs.profile;


import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import api.rest.JsonFluentObject;
import api.rest.app.bsky.actor.defs.AssociatedProfile;
import api.rest.app.bsky.actor.defs.Labels;
import api.rest.app.bsky.actor.defs.Viewer;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Profile view of an actor.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileViewBasic extends JsonFluentObject {
    
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
    @JsonProperty("createdAt")
    private Date createdAt;

    @Nullable
    @JsonProperty("associated")
    private AssociatedProfile associated;

    @Nullable
    @JsonProperty("viewer")
    private Viewer viewer;

    @Nullable
    @JsonProperty("labels")
    private List<Labels> labels;

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