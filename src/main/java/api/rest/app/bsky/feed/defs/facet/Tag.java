package api.rest.app.bsky.feed.defs.facet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=true)
public class Tag extends AbstractFacetFeature {

    @JsonProperty("tag")
    @Getter
    private String string;
        
}