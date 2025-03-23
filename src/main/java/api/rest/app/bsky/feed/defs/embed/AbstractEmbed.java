package api.rest.app.bsky.feed.defs.embed;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import api.rest.JsonFluentObject;
import api.rest.app.bsky.feed.defs.embed.external.ExternalMain;
import api.rest.app.bsky.feed.defs.embed.external.ExternalView;
import api.rest.app.bsky.feed.defs.embed.images.EmbeddedImage;
import api.rest.app.bsky.feed.defs.embed.images.ImageMain;
import api.rest.app.bsky.feed.defs.embed.images.ImageView;
import api.rest.app.bsky.feed.defs.embed.record.Record;
import api.rest.app.bsky.feed.defs.embed.record.ViewRecord;
import api.rest.app.bsky.feed.defs.embed.record.RecordWithMedia;
import api.rest.app.bsky.feed.defs.embed.record.RecordWithMediaView;
import api.rest.app.bsky.feed.defs.embed.video.VideoCaption;
import api.rest.app.bsky.feed.defs.embed.video.VideoMain;
import api.rest.app.bsky.feed.defs.embed.video.VideoView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString(exclude = {"json"})
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "$type", visible = true)
@JsonSubTypes({
    //External
    // @JsonSubTypes.Type(value = External.class,     name = "app.bsky.embed.external#external"),
    @JsonSubTypes.Type(value = ExternalMain.class, name = "app.bsky.embed.external"),
    @JsonSubTypes.Type(value = ExternalView.class, name = "app.bsky.embed.external#view"),
    // @JsonSubTypes.Type(value = ViewExternal.class, name = "app.bsky.embed.external#viewExternal"),
    //Images
    @JsonSubTypes.Type(value = EmbeddedImage.class, name = "app.bsky.embed.images#image"),
    @JsonSubTypes.Type(value = ImageMain.class, name = "app.bsky.embed.images"),
    @JsonSubTypes.Type(value = ImageView.class, name = "app.bsky.embed.images#view"),
    // @JsonSubTypes.Type(value = ViewImage.class, name = "app.bsky.embed.images#viewImage"),
    //Records
    @JsonSubTypes.Type(value = Record.class, name = "app.bsky.embed.record"),
    @JsonSubTypes.Type(value = ViewRecord.class, name = "app.bsky.embed.record#view"),
    @JsonSubTypes.Type(value = RecordWithMedia.class, name = "app.bsky.embed.recordWithMedia"),
    @JsonSubTypes.Type(value = RecordWithMediaView.class, name = "app.bsky.embed.recordWithMedia#view"),
    //Videos
    @JsonSubTypes.Type(value = VideoCaption.class, name = "app.bsky.embed.video#caption"),
    @JsonSubTypes.Type(value = VideoMain.class, name = "app.bsky.embed.video"),
    @JsonSubTypes.Type(value = VideoView.class, name = "app.bsky.embed.video#view")
})
public abstract class AbstractEmbed extends JsonFluentObject {

    private static final Logger LOGGER = LogManager.getLogger(AbstractEmbed.class);
    
    @JsonProperty("$type")
    private String type;
        
    @JsonIgnore
    protected final ObjectNode json;

    protected AbstractEmbed() {
        this.json = new ObjectMapper().createObjectNode();
    }
        
    protected AbstractEmbed(String type) {
        this.json = new ObjectMapper().createObjectNode();
        this.type = type;
        if(LOGGER.isInfoEnabled())
            LOGGER.info("Embeded type: {}", this.type);
    }

    // @Setter("$type")
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

}
