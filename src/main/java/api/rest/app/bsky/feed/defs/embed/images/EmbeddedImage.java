package api.rest.app.bsky.feed.defs.embed.images;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import api.rest.JsonFluentObject;
import api.rest.app.bsky.feed.defs.embed.AspectRatio;
import api.rest.app.bsky.feed.defs.embed.BlobRef;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmbeddedImage extends JsonFluentObject { 

    //AbstractEmbed type: app.bsky.embed.images#image

    @JsonProperty("alt")
    private String alt;

    @JsonProperty("image")
    private BlobRef image;

    @JsonProperty("aspectRatio")
    private AspectRatio aspectRatio;

    
}
