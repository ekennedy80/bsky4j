package api.rest.app.bsky.feed.defs;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.rest.JsonFluentObject;
import api.rest.app.bsky.feed.defs.embed.AbstractEmbed;
import api.rest.app.bsky.feed.defs.facet.Facet;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Record extends JsonFluentObject {

    @JsonIgnore
    private final ObjectNode json;

    @JsonProperty("$type")
    private String type;

    @JsonProperty("createdAt")
    private Date createdAt;

    @JsonProperty("embed")
    private AbstractEmbed embed; 

    @JsonProperty("facets")
    private List<Facet> facets;

    @JsonProperty("langs")
    private List<String> langs;

    @JsonProperty("text")
    private String text;

    public Record() {
        json = new ObjectMapper().createObjectNode();
    }


}
