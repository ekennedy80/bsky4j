package api.rest.app.bsky.feed.defs;

import java.net.URI;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import api.rest.JsonFluentObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Interaction extends JsonFluentObject {

    @JsonProperty("event")
    private String event;

    @JsonProperty("item")
    private URI item;

    @JsonProperty("feedContext")
    private String feedContext;
}
