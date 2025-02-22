package api.rest.app.bsky.feed.model.facet;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.rest.JsonFluentObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
public class Facet implements JsonFluentObject {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class Index {

        @JsonProperty("byteStart")
        private int byteStart;

        @JsonProperty("byteEnd")
        private int byteEnd;
    }

    @JsonProperty("index")
    private Index index;

    @JsonProperty("features")
    private List<AbstractFacetFeature> features;

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asJsonObject'");
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asJsonString'");
    }
    
}
