package api.rest.app.bsky.feed.defs;

import api.rest.JsonFluentObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.*;

import java.net.URI;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DescribeFeedGenerator implements JsonFluentObject {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class Feeds {

        @Nonnull
        @JsonProperty("uri")
        private URI uri;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class Links {

        @JsonProperty("privacyPolicy")
        private String privacyPolicy;

        @JsonProperty("termsOfService")
        private String termsOfService;
    }

    @Nonnull
    @JsonProperty("did")
    @Getter
    private String did;

    @Nonnull
    @JsonProperty("feeds")
    private List<Feeds> feeds;

    @Nullable
    @JsonProperty("links")
    private Links links;

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.valueToTree(this);
//        return json.put("profile", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this));
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }

}
