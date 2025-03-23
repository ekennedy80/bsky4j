package api.rest.app.bsky.feed.defs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedGenerator extends JsonFluentObject {
    
    @JsonProperty("view")
    private GeneratorView view;

    @JsonProperty("isOnline")
    private Boolean isOnline;

    @JsonProperty("isValid")
    private Boolean isValid;
    
}
