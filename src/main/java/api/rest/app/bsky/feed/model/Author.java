package api.rest.app.bsky.feed.model;

import java.net.URI;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.rest.JsonFluentObject;
import api.rest.app.bsky.actor.model.Labels;
import api.rest.app.bsky.actor.model.Viewer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Author implements JsonFluentObject {

    @JsonProperty("did")
    private String did;

    @JsonProperty("handle")
    private String handle;

    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("avatar")
    private URI avatar;

    @JsonProperty("viewer")
    private Viewer viewer;

    @JsonProperty("labels")
    private Labels labels;

    @JsonProperty("createdAt")
    private Date createdAt;

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asJsonObject'");
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asJsonString'");
    }
    
}
