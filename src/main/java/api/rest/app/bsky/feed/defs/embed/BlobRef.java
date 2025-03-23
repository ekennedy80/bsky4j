package api.rest.app.bsky.feed.defs.embed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import api.rest.JsonFluentObject;
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
public class BlobRef extends JsonFluentObject {

    @JsonProperty("$type")
    private String type;

    @JsonProperty("ref")
    private Ref ref;

    @JsonProperty("mimeType")
    private String mimeType;

    @JsonProperty("size")
    private int size;
}
