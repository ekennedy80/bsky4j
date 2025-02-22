package api.rest.app.bsky.actor.model;

import api.rest.JsonFluentObject;
import api.rest.app.bsky.actor.profile.defs.MutedOrBlockingByList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.net.URI;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * Metadata about the requesting account's relationship with the subject account. Only has meaningful
 * content for authed requests.
 */
public class Viewer implements JsonFluentObject {

    @Nonnull
    @JsonProperty("muted")
    private Boolean muted;

    @Nonnull
    @JsonProperty("mutedByList")
    private MutedOrBlockingByList mutedByList;

    @Nonnull
    @JsonProperty("blockedBy")
    private Boolean blockedBy;

    @Nonnull
    @JsonProperty("blocking")
    private URI blocking;

    @Nonnull
    @JsonProperty("blockingByList")
    private MutedOrBlockingByList blockingByList;

    @Nonnull
    @JsonProperty("following")
    private URI following;

    @Nonnull
    @JsonProperty("followedBy")
    private URI followedBy;

    //TODO: need to define the class definition
    @Nonnull
    @JsonProperty("knownFollowers")
    private Object knownFollowers;

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectNode json = new ObjectMapper().createObjectNode();
        ObjectMapper objectMapper = new ObjectMapper();
        return json.put("muted", muted)
        .put("mutedByList", objectMapper.writeValueAsString(this.mutedByList))
        .put("blockedBy", blockedBy)
        .put("blocking", blocking.toString())
        .put("blockingByList", objectMapper.writeValueAsString(this.blockingByList))
        .put("following", following.toString())
        .put("followedBy", followedBy.toString())
        .put("knownFollowers", objectMapper.writeValueAsString(this.knownFollowers));
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        ObjectNode json = new ObjectMapper().createObjectNode();
        ObjectMapper objectMapper = new ObjectMapper();
        return json.put("muted", muted)
        .put("mutedByList", objectMapper.writeValueAsString(this.mutedByList))
        .put("blockedBy", blockedBy)
        .put("blocking", blocking.toString())
        .put("blockingByList", objectMapper.writeValueAsString(this.blockingByList))
        .put("following", following.toString())
        .put("followedBy", followedBy.toString())
        .put("knownFollowers", objectMapper.writeValueAsString(this.knownFollowers)).toPrettyString();
    }

}
