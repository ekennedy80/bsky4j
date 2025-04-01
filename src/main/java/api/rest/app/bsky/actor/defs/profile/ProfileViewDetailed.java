package api.rest.app.bsky.actor.defs.profile;


import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import api.rest.com.atproto.repo.StrongRef;
import api.rest.graph.defs.StarterPackViewBasic;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Profile view of an actor.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
public class ProfileViewDetailed extends ProfileViewBasic  {

    @Nullable
    @JsonProperty("description")
    private String description;

    @Nullable
    @JsonProperty("banner")
    private URI banner;

    @Nullable
    @JsonProperty("followersCount")
    private Integer followersCount;

    @Nullable
    @JsonProperty("followsCount")
    private Integer followsCount;

    @Nullable
    @JsonProperty("postsCount")
    private Integer postsCount;

    @Nullable
    @JsonProperty("joinedViaStarterPack")
    private StarterPackViewBasic joinedViaStarterPack;

    @Nullable
    @JsonProperty("indexedAt")
    private Date indexedAt;

    @Nullable
    @JsonProperty("pinnedPost")
    private StrongRef pinnedPost;

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
