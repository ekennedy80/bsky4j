package api.rest.app.bsky.feed.defs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import api.rest.JsonFluentObject;
import api.rest.app.bsky.actor.defs.Viewer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlockedAuthor extends JsonFluentObject {
    
    @JsonProperty("did")
    private String did;

    @JsonProperty("viewer")
    private Viewer viewer;
    
}
