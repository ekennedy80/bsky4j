package api.rest.app.bsky.feed.defs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import api.rest.JsonFluentObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostThread extends JsonFluentObject {


    @JsonSerialize(using = CustomThreadSerializer.class)
    @JsonDeserialize(using = CustomThreadDeserializer.class)
    @JsonProperty("thread")
    private Object thread;

    @JsonProperty("threadgate")
    private ThreadgateView threadgate;

}
