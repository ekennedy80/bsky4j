package api.rest.app.bsky.feed.defs.embed.external;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.rest.JsonFluentObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
    "uri" : "https://apnews.com/article/trump-revokes-ethics-rules-drain-swamp-b8e3ba0f98c9c60af11a8e70cbc902bd",
    "title" : "Trump has canceled Biden's ethics rules. Critics call it the opposite of 'drain the swamp'",
    "description" : "Donald Trump took office eight years ago pledging to “drain the swamp” of the dominance of Washington influence peddlers.",
    "thumb" : "https://cdn.bsky.app/img/feed_thumbnail/plain/did:plc:y5xyloyy7s4a2bwfeimj7r3b/bafkreidler5ehdk27ujomrhpl3y5h2c2byvslcpexb6p3nshtnbk6gl62e@jpeg"
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ViewExternal implements JsonFluentObject {

    //AbstractEmbed type: app.bsky.embed.external#viewExternal
    
    @JsonProperty("uri")
    private URI uri;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("thumb")
    private URI thumb;

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectNode json = new ObjectMapper().createObjectNode();
        return json.put("uri", uri.toString())
        .put("title", title)
        .put("description", description)
        .put("thumb", thumb.toString());
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        return asJsonObject().toPrettyString();
    }
}


