package api.rest.app.bsky.feed.model.facet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.rest.JsonFluentObject;
import api.rest.app.bsky.actor.preferences.model.AdultContentPref;
import api.rest.app.bsky.actor.preferences.model.BskyAppStatePref;
import api.rest.app.bsky.actor.preferences.model.ContentLabelPref;
import api.rest.app.bsky.actor.preferences.model.FeedViewPref;
import api.rest.app.bsky.actor.preferences.model.HiddenPostsPref;
import api.rest.app.bsky.actor.preferences.model.InterestsPref;
import api.rest.app.bsky.actor.preferences.model.LabelersPref;
import api.rest.app.bsky.actor.preferences.model.MutedWordsPref;
import api.rest.app.bsky.actor.preferences.model.PersonalDetailsPref;
import api.rest.app.bsky.actor.preferences.model.SavedFeedsPref;
import api.rest.app.bsky.actor.preferences.model.SavedFeedsPrefV2;
import api.rest.app.bsky.actor.preferences.model.ThreadViewPref;
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
        @JsonSubTypes.Type(value = Link.class, name = "app.bsky.richtext.facet#link"),
        @JsonSubTypes.Type(value = Mention.class, name = "app.bsky.richtext.facet#mention"),
        @JsonSubTypes.Type(value = Tag.class, name = "app.bsky.richtext.facet#tag")}
)
public abstract class AbstractFacetFeature implements JsonFluentObject {

    @Nonnull
    @JsonProperty("$type")
    private String type;
        
    @Nonnull
    @JsonIgnore
    protected final ObjectNode json;
        
    protected AbstractFacetFeature(String type) {
        this.json = new ObjectMapper().createObjectNode();
        this.type = type;
    }
}