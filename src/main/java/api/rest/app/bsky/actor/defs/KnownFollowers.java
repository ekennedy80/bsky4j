package api.rest.app.bsky.actor.defs;

import api.rest.app.bsky.actor.defs.profile.ProfileViewBasic;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KnownFollowers {

    @Nonnull
    @JsonProperty("count")
    private Integer count;

    @Nonnull
    @JsonProperty("followers")
    private List<ProfileViewBasic> followers;

}
