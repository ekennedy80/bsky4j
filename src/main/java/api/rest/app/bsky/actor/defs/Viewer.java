package api.rest.app.bsky.actor.defs;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Viewer extends JsonFluentObject {

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
}
