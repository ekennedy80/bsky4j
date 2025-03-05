package api.rest.app.bsky.feed.defs.embed.external;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.rest.app.bsky.feed.defs.embed.AbstractEmbed;
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
@EqualsAndHashCode(callSuper=true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ViewExternal extends AbstractEmbed {

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asJsonObject'");
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asJsonString'");
    }
}


