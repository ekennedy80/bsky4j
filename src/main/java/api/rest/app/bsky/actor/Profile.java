package api.rest.app.bsky.actor;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;

/**
 * Get detailed profile view of an actor. Does not require auth, but contains relevant metadata with auth.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {

    @Nonnull
    @JsonProperty("did")
    private String did;

    @Nonnull
    @JsonProperty("handle")
    private String handle;

    @Nullable
    @JsonProperty("displayName")
    private String displayName;

    @Nullable
    @JsonProperty("description")
    private String description;

    @Nullable
    @JsonProperty("avatar")
    private URI avatar;

    @Nullable
    @JsonProperty("banner")
    private URI banner;

    @Nullable
    @JsonProperty("followersCount")
    private Integer followersCount;

    @Nullable
    @JsonProperty("followsCount")
    private Integer followsCount;

    @Nullable
    @JsonProperty("postsCount")
    private Integer postsCount;


}
