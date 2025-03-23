package api.rest.app.bsky.feed.defs.facet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=true)
public class Mention extends AbstractFacetFeature {

    @JsonProperty("did")
    private String did;
   
}
