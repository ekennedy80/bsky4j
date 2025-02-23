package api.rest.app.bsky.feed.defs.facet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;

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

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        return json.put("tag", this.string);
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        return json.put("tag", this.string).toPrettyString();
    }
        
}