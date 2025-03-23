package api.rest.app.bsky.feed.defs;

import java.net.URI;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import api.rest.JsonFluentObject;
import api.rest.app.bsky.actor.defs.Labels;
import api.rest.app.bsky.actor.defs.Viewer;
import api.rest.app.bsky.feed.defs.embed.AbstractEmbed;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostView extends JsonFluentObject {

    @JsonProperty("uri")
    private URI uri;

    @JsonProperty("cid")
    private String cid;

    @JsonProperty("author")
    private Author author;

    @JsonProperty("record")
    private Record record;

    @JsonProperty("embed")
    private AbstractEmbed embed;

    @JsonProperty("replyCount")
    private Integer replyCount;

    @JsonProperty("repostCount")
    private Integer repostCount;

    @JsonProperty("likeCount")
    private Integer likeCount;

    @JsonProperty("quoteCount")
    private Integer quoteCount;

    @JsonProperty("indexedAt")
    private Date indexedAt;

    @JsonProperty("viewer")
    private Viewer viewer;

    @JsonProperty("labels")
    private List<Labels> labels;

}
