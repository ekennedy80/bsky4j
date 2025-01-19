package api.rest.app.bsky.actor.profile.defs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.net.URI;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
/**
 * Metadata about the requesting account's relationship with the subject account. Only has meaningful
 * content for authed requests.
 */
public class ViewerDef {

    @Nonnull
    @JsonProperty("muted")
    private Boolean muted;

    @Nonnull
    @JsonProperty("mutedByList")
    private MutedOrBlockingByListDef mutedByList;

    @Nonnull
    @JsonProperty("blockedBy")
    private Boolean blockedBy;

    @Nonnull
    @JsonProperty("blocking")
    private URI blocking;

    @Nonnull
    @JsonProperty("blockingByList")
    private MutedOrBlockingByListDef blockingByList;

    @Nonnull
    @JsonProperty("following")
    private URI following;

    @Nonnull
    @JsonProperty("followedBy")
    private URI followedBy;

    //TODO: need class def
    @Nonnull
    @JsonProperty("knownFollowers")
    private Object knownFollowers;

}
