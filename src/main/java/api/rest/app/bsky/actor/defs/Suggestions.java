package api.rest.app.bsky.actor.defs;

import api.rest.app.bsky.actor.defs.profile.ProfileView;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Suggestions {

    @Nullable
    @JsonProperty("cursor")
    private String cursor;

    @Nullable
    @JsonProperty("actors")
    private List<ProfileView> actors;

    @Nullable
    @JsonProperty("recId")
    private Long recId;

    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode json = new ObjectMapper().createObjectNode();
        return json.put("suggestions", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this));
    }

    public String asJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }
}
