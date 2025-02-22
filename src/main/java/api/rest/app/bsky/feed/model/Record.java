package api.rest.app.bsky.feed.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.rest.JsonFluentObject;
import api.rest.app.bsky.feed.model.embed.AbstractEmbed;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Record implements JsonFluentObject {

    @Nonnull
    @JsonIgnore
    private final ObjectNode json;

    @JsonProperty("$type")
    private String type;

    @JsonProperty("createdAt")
    private Date createdAt;

    @JsonProperty("embed")
    private AbstractEmbed embed; 

    @JsonProperty("langs")
    private List<String> langs;

    @JsonProperty("text")
    private String text;

    public Record() {
        json = new ObjectMapper().createObjectNode();
    }

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        return json.set("record", new ObjectMapper().valueToTree(this));
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        return asJsonObject().toPrettyString();
    }

}
