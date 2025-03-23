package api.rest.com.atproto.server;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.rest.JsonFluentObject;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.*;
import org.example.DidDoc;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BskySession extends JsonFluentObject {

    @Nonnull
    @JsonProperty("accessJwt")
    @Getter
    private String accessJwt;

    @Nonnull
    @JsonProperty("refreshJwt")
    @Getter
    private String refreshJwt;

    @Nonnull
    @JsonProperty("handle")
    @Getter
    private String handle;

    @Nonnull
    @JsonProperty("did")
    @Getter
    private String did;

    @Nullable
    @JsonProperty("didDoc")
    @Getter
    private DidDoc didDoc;

    @Nullable
    @JsonProperty("email")
    @Getter
    private String email;

    @Nullable
    @JsonProperty("emailConfirmed")
    @Getter
    private Boolean emailConfirmed;

    @Nullable
    @JsonProperty("emailAuthFactor")
    @Getter
    private Boolean emailAuthFactor;

    @Nullable
    @JsonProperty("active")
    @Getter
    private Boolean active;

    /**
     * If active=false, this optional field indicates a possible reason for why the account is not active.
     * If active=false and no status is supplied, then the host makes no claim for why the repository is no
     * longer being hosted.
     * Possible values: [takendown, suspended, deactivated]
     */
    @Nullable
    @JsonProperty("status")
    @Getter
    private String status;

}
