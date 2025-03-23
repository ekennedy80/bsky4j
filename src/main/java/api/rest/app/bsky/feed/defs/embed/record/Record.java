package api.rest.app.bsky.feed.defs.embed.record;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import api.rest.app.bsky.feed.defs.embed.AbstractEmbed;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Record extends AbstractEmbed {

    @JsonProperty("cid")
    private String cid;

    @JsonProperty("uri")
    private URI uri;
    
}
