package api.rest.app.bsky.actor.defs.preferences;

import api.rest.JsonFluentObject;
import com.fasterxml.jackson.annotation.*;
import jakarta.annotation.Nonnull;
import lombok.*;

@Data
@NoArgsConstructor(force = true)
@ToString
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "$type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AdultContentPref.class, name = "app.bsky.actor.defs#adultContentPref"),
        @JsonSubTypes.Type(value = BskyAppStatePref.class, name = "app.bsky.actor.defs#bskyAppStatePref"),
        @JsonSubTypes.Type(value = ContentLabelPref.class, name = "app.bsky.actor.defs#contentLabelPref"),
        @JsonSubTypes.Type(value = FeedViewPref.class, name = "app.bsky.actor.defs#feedViewPref"),
        @JsonSubTypes.Type(value = HiddenPostsPref.class, name = "app.bsky.actor.defs#hiddenPostsPref"),
        @JsonSubTypes.Type(value = InterestsPref.class, name = "app.bsky.actor.defs#interestsPref"),
        @JsonSubTypes.Type(value = LabelersPref.class, name = "app.bsky.actor.defs#labelersPref"),
        @JsonSubTypes.Type(value = MutedWordsPref.class, name = "app.bsky.actor.defs#mutedWordsPref"),
        @JsonSubTypes.Type(value = PersonalDetailsPref.class, name = "app.bsky.actor.defs#personalDetailsPref"),
        @JsonSubTypes.Type(value = SavedFeedsPref.class, name = "app.bsky.actor.defs#savedFeedsPref"),
        @JsonSubTypes.Type(value = SavedFeedsPrefV2.class, name = "app.bsky.actor.defs#savedFeedsPrefV2"),
        @JsonSubTypes.Type(value = ThreadViewPref.class, name = "app.bsky.actor.defs#threadViewPref")}
)
public abstract class AbstractPreference extends JsonFluentObject {

    @Nonnull
    @JsonProperty("$type")
    private String type;

    protected AbstractPreference(String type) {
        this.type = type;
    }
}
