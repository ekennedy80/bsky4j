package api.rest.app.bsky.actor.defs;

import api.rest.JsonFluentObject;
import api.rest.app.bsky.actor.defs.profile.ProfileView;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.Nonnull;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Actors implements JsonFluentObject {

    @Nonnull
    @JsonProperty("actors")
    @Getter
    @Setter
    private List<ProfileView> actors;

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode json = new ObjectMapper().createObjectNode();
        return json.put("actors", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this));
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }
}
