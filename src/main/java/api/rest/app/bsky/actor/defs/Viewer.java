package api.rest.app.bsky.actor.defs;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.rest.JsonFluentObject;
import api.rest.app.bsky.graph.ListViewBasic;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

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
    private ListViewBasic mutedByList;

    @Nonnull
    @JsonProperty("blockedBy")
    private Boolean blockedBy;

    @Nonnull
    @JsonProperty("blocking")
    private URI blocking;

    @Nonnull
    @JsonProperty("blockingByList")
    private ListViewBasic blockingByList;

    @Nonnull
    @JsonProperty("following")
    private URI following;

    @Nonnull
    @JsonProperty("followedBy")
    private URI followedBy;

    @Nonnull
    @JsonProperty("knownFollowers")
    private KnownFollowers knownFollowers;

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectNode json = new ObjectMapper().createObjectNode();
        return json.put("muted", muted)
            .put("mutedByList", mutedByList.asJsonString())
            .put("blockedBy", blockedBy)
            .put("blocking", blocking.toString())
            .put("blockingByList", blockingByList.asJsonString())
            .put("following", following.toString())
            .put("followedBy", followedBy.toString())
            .put("knownFollowers", knownFollowers.asJsonString());
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }

}
