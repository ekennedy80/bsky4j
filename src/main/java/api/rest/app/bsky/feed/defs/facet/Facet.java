package api.rest.app.bsky.feed.defs.facet;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Facet extends JsonFluentObject {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(callSuper=false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class Index extends JsonFluentObject {

        @JsonProperty("byteStart")
        private int byteStart;

        @JsonProperty("byteEnd")
        private int byteEnd;
    }

    @JsonProperty("index")
    private Index index;

    @JsonProperty("features")
    private List<AbstractFacetFeature> features;
    
}
