package api.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class JsonFluentObject {

    protected static ObjectMapper mapper = new ObjectMapper();

    public JsonNode asJsonObject() {
        return mapper.convertValue(this, JsonNode.class);
    }

    public String asJsonString() throws JsonProcessingException {
        return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }
}
