package api.rest.app.bsky.feed.model.facet;

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
public class Mention extends AbstractFacetFeature {

    @JsonProperty("did")
    private String did;

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        return json.put("did", this.did);
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        return json.put("did", this.did).toPrettyString();
    }
    
}
