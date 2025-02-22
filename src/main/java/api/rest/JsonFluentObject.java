package api.rest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.annotation.Nonnull;

public interface JsonFluentObject {

    public abstract ObjectNode asJsonObject() throws JsonProcessingException;

    public abstract String asJsonString()  throws JsonProcessingException;
}
