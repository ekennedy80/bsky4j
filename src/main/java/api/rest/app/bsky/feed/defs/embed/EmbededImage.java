package api.rest.app.bsky.feed.defs.embed;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=true)
public class EmbededImage extends AbstractEmbed {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class AspectRatio {
        @JsonProperty("width")
        private Integer width;

        @JsonProperty("height")
        private Integer height;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class ImageObject {
        @JsonProperty("$type")
        private String type;

        @JsonProperty("ref")
        private Ref ref;

        @JsonProperty("mimeType")
        private String mimeType;

        @JsonProperty("size")
        private int size;
    }
    
    @JsonProperty("alt")
    private String alt;

    @JsonProperty("image")
    private ImageObject image;

    @JsonProperty("aspectRatio")
    private AspectRatio aspectRatio;
    
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
