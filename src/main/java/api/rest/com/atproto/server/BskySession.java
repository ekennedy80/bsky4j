package api.rest.com.atproto.server;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
public class BskySession {

    @Nonnull
    @JsonProperty("accessJwt")
    private String accessJwt;

    @Nonnull
    @JsonProperty("refreshJwt")
    private String refreshJwt;

    @Nonnull
    @JsonProperty("handle")
    private String handle;

    @Nonnull
    @JsonProperty("did")
    private String did;

    @Nullable
    @JsonProperty("didDoc")
    private DidDoc didDoc;

    @Nullable
    @JsonProperty("email")
    private String email;

    @Nullable
    @JsonProperty("emailConfirmed")
    private Boolean emailConfirmed;

    @Nullable
    @JsonProperty("emailAuthFactor")
    private Boolean emailAuthFactor;

    @Nullable
    @JsonProperty("active")
    private Boolean active;

    /**
     * If active=false, this optional field indicates a possible reason for why the account is not active.
     * If active=false and no status is supplied, then the host makes no claim for why the repository is no
     * longer being hosted.
     * Possible values: [takendown, suspended, deactivated]
     */
    @Nullable
    @JsonProperty("status")
    private String status;

    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode json = new ObjectMapper().createObjectNode();
        return json.put("BskySession", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this));
    }

    public String asJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }
}
