package api.rest.app.bsky.feed.defs.embed;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.rest.JsonFluentObject;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class Ref implements JsonFluentObject {

    @Nonnull
    @JsonIgnore
    private final ObjectNode json;

    @JsonProperty("$link")
    private String link;

    public Ref() {
        json = new ObjectMapper().createObjectNode();
    }

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        return json.put("$link", link);
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        return json.put("$link", link).toPrettyString();
    }
}
