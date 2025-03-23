package api.rest.app.bsky.feed.defs.facet;
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
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString(exclude = {"json"})
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "$type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Link.class, name = "app.bsky.richtext.facet#link"),
        @JsonSubTypes.Type(value = Mention.class, name = "app.bsky.richtext.facet#mention"),
        @JsonSubTypes.Type(value = Tag.class, name = "app.bsky.richtext.facet#tag")}
)
public abstract class AbstractFacetFeature extends JsonFluentObject {

    @JsonProperty("$type")
    private String type;
        
    @Nonnull
    @JsonIgnore
    protected final ObjectNode json;

    protected AbstractFacetFeature() {
        this.json = new ObjectMapper().createObjectNode();
    }
        
    protected AbstractFacetFeature(String type) {
        this.json = new ObjectMapper().createObjectNode();
        this.type = type;
    }
}