package api.rest.app.bsky.feed.defs;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import api.rest.JsonFluentObject;
import api.rest.app.bsky.actor.defs.Labels;
import api.rest.app.bsky.actor.defs.profile.ProfileView;
import api.rest.app.bsky.feed.defs.facet.Facet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneratorView extends JsonFluentObject {

    @JsonProperty("uri")
    private URI uri;
    
    @JsonProperty("cid")
    private String cid;

    @JsonProperty("did")
    private String did;

    @JsonProperty("creator")
    private ProfileView creator;

    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("descriptionFacets")
    private List<Facet> descriptionFacets;

    @JsonProperty("avatar")
    private URI avatar;

    @JsonProperty("likeCount")
    private Integer likeCount;

    @JsonProperty("acceptsInteractions")
    private Boolean acceptsInteractions;

    @JsonProperty("labels")
    private List<Labels> labels;

    @JsonProperty("viewer")
    private GeneratorViewerState viewer;

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
