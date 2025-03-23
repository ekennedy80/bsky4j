package api.rest.app.bsky.feed.defs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import api.rest.JsonFluentObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ThreadViewPost extends JsonFluentObject {

    @JsonProperty("post")
    private PostView post;

    @JsonProperty("parent")
    private ThreadViewPost parent;

    @JsonProperty("replies")
    private List<ThreadViewPost> replies;

}
