package api.rest.app.bsky.feed.defs.embed;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.rest.app.bsky.actor.defs.Labels;
import api.rest.app.bsky.actor.defs.profile.ProfileViewBasic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecordView extends AbstractEmbed {


    @JsonProperty("author")
    private ProfileViewBasic author;

    @JsonProperty("cid")
    private String cid;

    @JsonProperty("embeds")
    private List<AbstractEmbed> embeds;

    @JsonProperty("indexedAt")
    private Date indexedAt;

    @JsonProperty("labels")
    private List<Labels> labels;

    @JsonProperty("likeCount")
    private Integer likeCount;

    @JsonProperty("quoteCount")
    private Integer quoteCount;

    @JsonProperty("replyCount")
    private Integer replyCount;

    @JsonProperty("repostCount")
    private Integer repostCount;

    @JsonProperty("uri")
    private URI uri;

    @JsonProperty("value")
    private api.rest.app.bsky.feed.defs.Record value;

    @JsonSetter("indexedAt")
    public void setIndexedAt(String date) throws ParseException {
        if (date != null) {
            if (date.contains(":") || date.contains("T") || date.contains("Z")) {
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                this.indexedAt = inputFormat.parse(date);
            } else {
                this.indexedAt = new Date(Long.parseLong(date));
            }
        }
    }

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asJsonObject'");
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asJsonString'");
    }
    
}
