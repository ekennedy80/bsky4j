package api.rest.app.bsky.actor.defs;

import api.rest.JsonFluentObject;
import api.rest.app.bsky.actor.defs.profile.ProfileView;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Actors extends JsonFluentObject {

    @Nonnull
    @JsonProperty("actors")
    @Getter
    @Setter
    private List<ProfileView> actors;

}
