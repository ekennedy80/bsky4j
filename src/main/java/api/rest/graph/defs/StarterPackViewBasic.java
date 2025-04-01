package api.rest.graph.defs;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import api.rest.JsonFluentObject;
import api.rest.app.bsky.actor.defs.Labels;
import api.rest.app.bsky.actor.defs.profile.ProfileViewBasic;
import api.rest.com.atproto.sync.RecordDef;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StarterPackViewBasic extends JsonFluentObject{

    @Nonnull
    @JsonProperty("uri")
    private URI uri;

    @Nonnull
    @JsonProperty("cid")
    private String cid;

    @Nonnull
    @JsonProperty("record")
    private RecordDef recordDef;

    @Nonnull
    @JsonProperty("creator")
    private ProfileViewBasic creator;

    @Nullable
    @JsonProperty("listItemCount")
    private Integer listItemCount;

    @Nullable
    @JsonProperty("joinedWeekCount")
    private Integer joinedWeekCount;

    @Nullable
    @JsonProperty("joinedAllTimeCount")
    private Integer joinedAllTimeCount;

    @Nullable
    @JsonProperty("labels")
    private List<Labels> labels;

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
