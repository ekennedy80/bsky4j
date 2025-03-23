package api.rest.app.bsky.feed.defs.embed.images;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import api.rest.JsonFluentObject;
import api.rest.app.bsky.feed.defs.embed.AspectRatio;
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
public class ViewImage extends JsonFluentObject {

    //AbstractEmbed type: app.bsky.embed.images#viewImage

    @JsonProperty("thumb")
    private URI thumb;

    @JsonProperty("fullsize")
    private URI fullsize;

    @JsonProperty("alt")
    private String alt;

    @JsonProperty("aspectRatio")
    private AspectRatio aspectRatio;

    
}
