package api.rest.app.bsky.feed.defs.embed.video;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import api.rest.app.bsky.feed.defs.embed.AbstractEmbed;
import api.rest.app.bsky.feed.defs.embed.AspectRatio;
import api.rest.app.bsky.feed.defs.embed.BlobRef;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoMain extends AbstractEmbed {

    //AbstractEmbed type: app.bsky.embed.video

    @JsonProperty("alt")
    private String alt;

    @JsonProperty("aspectRatio")
    private AspectRatio aspectRatio;

    @JsonProperty("captions")
    private List<VideoCaption> captions;

    @JsonProperty("video")
    private BlobRef video;
    
}
