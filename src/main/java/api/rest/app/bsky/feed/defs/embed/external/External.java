package api.rest.app.bsky.feed.defs.embed.external;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.rest.app.bsky.feed.defs.embed.AbstractEmbed;
import api.rest.app.bsky.feed.defs.embed.BlobRef;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class External extends AbstractEmbed {

    //AbstractEmbed type: app.bsky.embed.external#external

    @JsonProperty("uri")
    private URI uri;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("thumb")
    private BlobRef thumb;
    
    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        return json.put("uri", uri.toString())
        .put("title", title)
        .put("description", description)
        .set("thumb", thumb.asJsonObject());
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        return json.put("uri", uri.toString())
        .put("title", title)
        .put("description", description)
        .set("thumb", thumb.asJsonObject()).toPrettyString();
    }
    
}