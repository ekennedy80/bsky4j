package api.rest.app.bsky.graph;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import api.rest.app.bsky.actor.defs.Labels;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListViewBasic {

    @Nonnull
    @JsonProperty("uri")
    private URI uri;

    @Nonnull
    @JsonProperty("cid")
    private String cid;

    @Nonnull
    @JsonProperty("name")
    private String name;

    @Nonnull
    @JsonProperty("purpose")
    private String purpose;

    @Nullable
    @JsonProperty("avatar")
    private URI avatar;

    @Nullable
    @JsonProperty("listItemCount")
    private Integer listItemCount;

    @Nullable
    @JsonProperty("labels")
    private List<Labels> labels;

    @Nullable
    @JsonProperty("viewer")
    private ListViewerState viewer;

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
