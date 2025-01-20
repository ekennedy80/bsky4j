package api.rest.app.bsky.actor.profile.defs;

import api.rest.app.bsky.actor.defs.AssociatedDef;
import api.rest.app.bsky.actor.defs.LabelsDef;
import api.rest.app.bsky.actor.defs.ViewerDef;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
public class CreatorDef {

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
    private AssociatedDef associated;

    @Nullable
    @JsonProperty("viewer")
    private ViewerDef viewer;

    @Nullable
    @JsonProperty("labels")
    private List<LabelsDef> labels;

    @Nonnull
    @JsonProperty("createdAt")
    private Date createdAt;

    @JsonSetter("createdAt")
    public void setCreatedAt(String date) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        this.createdAt = inputFormat.parse(date);
    }
}
