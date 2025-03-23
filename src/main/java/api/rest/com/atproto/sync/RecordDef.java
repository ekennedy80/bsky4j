package api.rest.com.atproto.sync;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import api.rest.JsonFluentObject;
import jakarta.annotation.Nonnull;
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
public class RecordDef extends JsonFluentObject {

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
