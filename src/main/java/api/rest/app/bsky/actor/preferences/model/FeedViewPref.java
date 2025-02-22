package api.rest.app.bsky.actor.preferences.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
public class FeedViewPref extends AbstractPreference {

    @Nonnull
    @JsonProperty("feed")
    private String feed;

    @Nullable
    @JsonProperty("hideReplies")
    private Boolean hideReplies;

    @Nullable
    @JsonProperty("hideRepliesByUnfollowed")
    private Boolean hideRepliesByUnfollowed;

    @Nullable
    @JsonProperty("hideRepliesByLikeCount")
    private Integer hideRepliesByLikeCount;

    @Nullable
    @JsonProperty("hideReposts")
    private Boolean hideReposts;

    @Nullable
    @JsonProperty("hideQuotePosts")
    private Boolean hideQuotePosts;

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        return null;
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        return "";
    }
}
