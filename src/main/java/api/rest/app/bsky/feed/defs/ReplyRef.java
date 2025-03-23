package api.rest.app.bsky.feed.defs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import api.rest.JsonFluentObject;
import api.rest.app.bsky.actor.defs.profile.ProfileViewBasic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReplyRef extends JsonFluentObject {
    
    @JsonSerialize(using = RootSerializer.class)
    @JsonDeserialize(using = RootDeserializer.class)
    @JsonProperty("root")
    private JsonFluentObject root;

    @JsonSerialize(using = RootSerializer.class)
    @JsonDeserialize(using = RootDeserializer.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("parent")
    private JsonFluentObject parent;

    @JsonProperty("grandparentAuthor")
    private ProfileViewBasic grandparentAuthor;
    
   
}
