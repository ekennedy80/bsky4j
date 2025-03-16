package api.rest.app.bsky.actor.defs;

import api.rest.JsonFluentObject;
import api.rest.app.bsky.actor.defs.profile.ProfileViewBasic;
import api.rest.app.bsky.feed.defs.FeedViewPost;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KnownFollowers implements JsonFluentObject {

    @Nonnull
    @JsonProperty("count")
    private Integer count;

    @Nonnull
    @JsonProperty("followers")
    private List<ProfileViewBasic> followers;

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectNode json = new ObjectMapper().createObjectNode();
        ArrayNode array = new ObjectMapper().createArrayNode();
        for(ProfileViewBasic follow : followers) {
            array.add(follow.asJsonString());
        }
        return json.put("count", count)
            .put("followers", followers.toString());
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        return asJsonObject().toPrettyString();
    }

}
