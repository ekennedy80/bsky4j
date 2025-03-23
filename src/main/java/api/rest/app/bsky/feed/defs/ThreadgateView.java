package api.rest.app.bsky.feed.defs;

import java.net.URI;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import api.rest.JsonFluentObject;
import api.rest.app.bsky.graph.ListViewBasic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ThreadgateView extends JsonFluentObject{

    @JsonProperty("cid")
    private String cid;

    @JsonProperty("lists")
    private List<ListViewBasic> lists;

    @JsonProperty("record")
    private Record record;

    @JsonProperty("uri")
    private URI uri;
    
}
