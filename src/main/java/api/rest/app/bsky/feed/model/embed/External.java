package api.rest.app.bsky.feed.model.embed;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.rest.JsonFluentObject;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class External extends AbstractEmbed {
    
    @Data
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class Thumb implements JsonFluentObject {
        @Nonnull
        @JsonIgnore
        private final ObjectNode json;

        @JsonProperty("$type")
        private String type;

        @JsonProperty("ref")
        private Ref ref;

        @JsonProperty("mimeType")
        private String mimeType;

        @JsonProperty("size")
        private Integer size;

        public Thumb() {
            json = new ObjectMapper().createObjectNode();
        }

        @Override
        public ObjectNode asJsonObject() throws JsonProcessingException {
            return json.put("$type", type)
            .put("mimeType", mimeType)
            .put("size", size)
            .set("ref", ref.asJsonObject());
        }

        @Override
        public String asJsonString() throws JsonProcessingException {
            return json.put("$type", type)
            .put("mimeType", mimeType)
            .put("size", size)
            .set("ref", ref.asJsonObject()).toPrettyString();
        }

    }

    @JsonProperty("uri")
    private URI uri;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("thumb")
    private Thumb thumb;
    
    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        return json.put("uri", uri.toString())
        .put("title", title)
        .put("description", description)
        .set("thumb", thumb.asJsonObject());
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        return json.put("uri", uri.toString())
        .put("title", title)
        .put("description", description)
        .set("thumb", thumb.asJsonObject()).toPrettyString();
    }
    
}