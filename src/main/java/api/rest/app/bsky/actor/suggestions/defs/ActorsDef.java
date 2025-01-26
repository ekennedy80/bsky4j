package api.rest.app.bsky.actor.suggestions.defs;

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
public class ActorsDef {

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
    @JsonProperty("description")
    private String description;

    @Nullable
    @JsonProperty("avatar")
    private URI avatar;

    @Nullable
    @JsonProperty("associated")
    private AssociatedDef associated;

    @Nullable
    @JsonProperty("indexedAt")
    private Date indexedAt;

    @Nullable
    @JsonProperty("createdAt")
    private Date createdAt;

    @Nullable
    @JsonProperty("viewer")
    private ViewerDef viewer;

    @Nullable
    @JsonProperty("labels")
    private List<LabelsDef> labels;

    @JsonSetter("indexedAt")
    public void setIndexedAt(String date) throws ParseException {
        if(date != null) {
            if (date.contains("-") || date.contains(":") || date.contains("T") || date.contains(".") || date.contains("Z")) {
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                this.indexedAt = inputFormat.parse(date);
            } else {
                this.indexedAt = new Date(Long.parseLong(date));
            }
        }
    }

    @JsonSetter("createdAt")
    public void setCreatedAt(String date) throws ParseException {
        if(date != null) {
            if (date.contains("-") || date.contains(":") || date.contains("T") || date.contains(".") || date.contains("Z")) {
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                this.createdAt = inputFormat.parse(date);
            } else {
                this.createdAt = new Date(Long.parseLong(date));
            }
        }
    }
}
