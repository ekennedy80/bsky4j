package api.rest.com.atproto.repo;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StrongRef {

    @Nonnull
    @JsonProperty("uri")
    private URI uri;

    @Nonnull
    @JsonProperty("cid")
    private String cid;
}
