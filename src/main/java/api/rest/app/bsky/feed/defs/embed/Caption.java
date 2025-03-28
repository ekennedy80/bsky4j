package api.rest.app.bsky.feed.defs.embed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import api.rest.JsonFluentObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Caption extends JsonFluentObject {

    class File {
        @JsonProperty("$type")
        private String type;

        @JsonProperty("ref")
        private Ref ref;

        @JsonProperty("mimeType")
        private String mimeType;

        @JsonProperty("size")
        private Integer size;
    }

    @JsonProperty("$type")
    private String type;

    @JsonProperty("file")
    private File file;

    @JsonProperty("lang")
    private String lang;

}
