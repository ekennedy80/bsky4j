package api.rest.app.bsky.feed.defs.embed;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import api.rest.JsonFluentObject;
import api.rest.app.bsky.feed.defs.embed.external.External;
import api.rest.app.bsky.feed.defs.embed.external.ExternalMain;
import api.rest.app.bsky.feed.defs.embed.external.ExternalView;
import api.rest.app.bsky.feed.defs.embed.external.ViewExternal;
import api.rest.app.bsky.feed.defs.embed.images.Image;
import api.rest.app.bsky.feed.defs.embed.images.ImageMain;
import api.rest.app.bsky.feed.defs.embed.images.ImageView;
import api.rest.app.bsky.feed.defs.embed.images.ViewImage;
import api.rest.app.bsky.feed.defs.embed.video.VideoCaption;
import api.rest.app.bsky.feed.defs.embed.video.VideoMain;
import api.rest.app.bsky.feed.defs.embed.video.VideoView;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@ToString(exclude = {"json"})
@EqualsAndHashCode(exclude = {"json"})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "$type", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = External.class, name = "app.bsky.embed.external"),
    @JsonSubTypes.Type(value = ExternalMain.class, name = "app.bsky.embed.external"),
    @JsonSubTypes.Type(value = ExternalView.class, name = "app.bsky.embed.external#view"),
    @JsonSubTypes.Type(value = ViewExternal.class, name = "app.bsky.embed.external#view"),
    //Images
    @JsonSubTypes.Type(value = Image.class, name = "app.bsky.embed.images#image"),
    @JsonSubTypes.Type(value = ImageMain.class, name = "app.bsky.embed.images"),
    @JsonSubTypes.Type(value = ImageView.class, name = "app.bsky.embed.images#view"),
    @JsonSubTypes.Type(value = ViewImage.class, name = "app.bsky.embed.images#viewImage"),
    //Records
    @JsonSubTypes.Type(value = Record.class, name = "app.bsky.embed.record"),
    @JsonSubTypes.Type(value = RecordView.class, name = "app.bsky.embed.record#view"),
    @JsonSubTypes.Type(value = RecordWithMedia.class, name = "app.bsky.embed.recordWithMedia"),
    @JsonSubTypes.Type(value = RecordWithMediaView.class, name = "app.bsky.embed.recordWithMedia#view"),
    //Videos
    @JsonSubTypes.Type(value = VideoCaption.class, name = "app.bsky.embed.video#caption"),
    @JsonSubTypes.Type(value = VideoMain.class, name = "app.bsky.embed.video"),
    @JsonSubTypes.Type(value = VideoView.class, name = "app.bsky.embed.video#view")}
)
public abstract class AbstractEmbed implements JsonFluentObject {
    
    @Nonnull
    @JsonProperty("$type")
    private String type;
        
    @Nonnull
    @JsonIgnore
    protected final ObjectNode json;
        
    protected AbstractEmbed(String type) {
        this.json = new ObjectMapper().createObjectNode();
        this.type = type;
    }
}
