package api.rest.com.atproto.sync;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecordDef {

    @Nonnull
    @JsonProperty("did")
    private String did;

    @Nonnull
    @JsonProperty("collection")
    private String collection;

    @Nonnull
    @JsonProperty("rkey")
    private String rkey;
}
