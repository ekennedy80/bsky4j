package api.rest.app.bsky.feed.defs;

import java.net.URI;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import api.rest.JsonFluentObject;
import api.rest.app.bsky.actor.defs.profile.ProfileView;

public class RepostedBy extends JsonFluentObject{
    
    @JsonProperty("uri")
    private URI uri;

    @JsonProperty("cid")
    private String cid;

    @JsonProperty("cursor")
    private String cursor;

    @JsonProperty("repostedBy")
    private List<ProfileView> repostedBy;

}
