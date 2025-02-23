package api.rest.app.bsky.feed.defs.embed;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.rest.JsonFluentObject;
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
    @JsonSubTypes.Type(value = ExternalView.class, name = "app.bsky.embed.external#view"),
    @JsonSubTypes.Type(value = EmbededImage.class, name = "app.bsky.embed.images"),
    @JsonSubTypes.Type(value = ImageView.class, name = "app.bsky.embed.images#view"),
    @JsonSubTypes.Type(value = Record.class, name = "app.bsky.embed.record"),
    @JsonSubTypes.Type(value = RecordView.class, name = "app.bsky.embed.record#view"),
    @JsonSubTypes.Type(value = EmbededVideo.class, name = "app.bsky.embed.video"),
    @JsonSubTypes.Type(value = VideoView.class, name = "app.bsky.embed.video#view"),
    @JsonSubTypes.Type(value = RecordWithMedia.class, name = "app.bsky.embed.recordWithMedia")}
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
