package api.rest.graph.defs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import api.rest.JsonFluentObject;
import api.rest.app.bsky.actor.defs.profile.ProfileView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KnownFollowers extends JsonFluentObject{
    
    @JsonProperty("cursor")
    private String cursor;

    @JsonProperty("followers")
    private List<ProfileView> followers;

    @JsonProperty("subject")
    private ProfileView subject;
}
