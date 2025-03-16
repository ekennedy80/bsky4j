package api.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface JsonFluentObject {

    public abstract ObjectNode asJsonObject() throws JsonProcessingException;

    public abstract String asJsonString()  throws JsonProcessingException;
}
