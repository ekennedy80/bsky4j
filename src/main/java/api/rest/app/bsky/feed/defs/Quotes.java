package api.rest.app.bsky.feed.defs;

import java.net.URI;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import api.rest.JsonFluentObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quotes extends JsonFluentObject{
    
    @JsonProperty("uri")
    private URI uri;

    @JsonProperty("cid")
    private String cid;

    @JsonProperty("cursor")
    private String cursor;

    @JsonProperty("posts")
    private List<PostView> posts;
}
