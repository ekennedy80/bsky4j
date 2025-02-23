package api.rest.app.bsky.feed.defs.embed;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
    "record" : {
    "cid" : "bafyreicnitc46myf5g4pjdr47tpf6jcl2piqdcg6ts7imrwrgocerob3uq",
    "uri" : "at://did:plc:ddvus7otnqtlh7fdooxm6qat/app.bsky.feed.post/3liq7jc73ac2y"
    }
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Record extends AbstractEmbed {

    @JsonProperty("cid")
    private String cid;

    @JsonProperty("uri")
    private URI uri;

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
