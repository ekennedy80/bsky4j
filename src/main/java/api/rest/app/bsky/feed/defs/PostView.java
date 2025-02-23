package api.rest.app.bsky.feed.defs;

import java.net.URI;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.rest.JsonFluentObject;
import api.rest.app.bsky.actor.defs.Labels;
import api.rest.app.bsky.actor.defs.Viewer;
import api.rest.app.bsky.feed.defs.embed.AbstractEmbed;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostView implements JsonFluentObject {
    
    @JsonProperty("uri")
    private URI uri;

    @JsonProperty("cid")
    private String cid;

    @JsonProperty("author")
    private Author author;

    @JsonProperty("record")
    private Record record;

    @JsonProperty("embed")
    private AbstractEmbed embed;

    @JsonProperty("replyCount")
    private Integer replyCount;

    @JsonProperty("repostCount")
    private Integer repostCount;

    @JsonProperty("likeCount")
    private Integer likeCount;

    @JsonProperty("quoteCount")
    private Integer quoteCount;

    @JsonProperty("indexedAt")
    private Date indexedAt;

    @JsonProperty("viewer")
    private Viewer viewer;

    @JsonProperty("labels")
    private List<Labels> labels;

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectNode json = new ObjectMapper().createObjectNode();
        return json.set("post", new ObjectMapper().valueToTree(this));
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        return asJsonObject().toPrettyString();
    }
}
