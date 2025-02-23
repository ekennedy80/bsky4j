package api.rest.app.bsky.feed.defs.facet;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;

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

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        return json.put("uri", this.uri.toString());
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        return json.put("uri", this.uri.toString()).toPrettyString();
    }
    
}
