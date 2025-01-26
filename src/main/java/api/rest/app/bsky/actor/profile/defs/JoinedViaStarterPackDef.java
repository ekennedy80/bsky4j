package api.rest.app.bsky.actor.profile.defs;

import api.rest.app.bsky.actor.defs.LabelsDef;
import api.rest.com.atproto.sync.RecordDef;
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
public class JoinedViaStarterPackDef {

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
    private CreatorDef creator;

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
    private List<LabelsDef> labels;

    @Nullable
    @JsonProperty("indexedAt")
    private Date indexedAt;

    @JsonSetter("indexedAt")
    public void setIndexedAt(String date) throws ParseException {
        if (date != null && Long.parseLong(date) > 0) {
            if (date.contains("-") || date.contains(":") || date.contains("T") || date.contains(".") || date.contains("Z")) {
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                this.indexedAt = inputFormat.parse(date);
            } else {
                this.indexedAt = new Date(Long.parseLong(date));
            }
        }
    }
}
