package api.rest.app.bsky.actor.defs;

import api.rest.JsonFluentObject;
import api.rest.app.bsky.actor.defs.profile.ProfileView;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import lombok.*;

import java.util.List;

/**
 * Get a list of suggested actors. Expected use is discovery of accounts to
 * follow during new account onboarding.
 * 
 * TODO: Look at creating a Response folder and a params folder
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Suggestions extends JsonFluentObject {

    @Nullable
    @JsonProperty("cursor")
    private String cursor;

    @Nullable
    @JsonProperty("actors")
    private List<ProfileView> actors;

    @Nullable
    @JsonProperty("recId")
    private Long recId;
}
