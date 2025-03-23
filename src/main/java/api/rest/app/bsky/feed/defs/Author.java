package api.rest.app.bsky.feed.defs;

import java.net.URI;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import api.rest.JsonFluentObject;
import api.rest.app.bsky.actor.defs.AssociatedProfile;
import api.rest.app.bsky.actor.defs.Labels;
import api.rest.app.bsky.actor.defs.Viewer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Author extends JsonFluentObject {

    @JsonProperty("did")
    private String did;

    @JsonProperty("handle")
    private String handle;

    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("avatar")
    private URI avatar;

    @JsonProperty("associated")
    private AssociatedProfile associated;

    @JsonProperty("viewer")
    private Viewer viewer;

    @JsonProperty("labels")
    private List<Labels> labels;

    @JsonProperty("createdAt")
    private Date createdAt;    
}
