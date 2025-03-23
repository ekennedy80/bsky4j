package api.rest.app.bsky.feed.defs.facet;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=true)
public class Link extends AbstractFacetFeature {

    @JsonProperty("uri")
    private URI uri;
    
}
