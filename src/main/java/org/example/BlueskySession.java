package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlueskySession {

    @Nonnull
    @JsonProperty("did")
    private String did;

    @Nullable
    @JsonProperty("didDoc")
    private DidDoc didDoc;

    @Nonnull
    @JsonProperty("handle")
    private String handle;

    @Nullable
    @JsonProperty("email")
    private String email;

    @Nullable
    @JsonProperty("emailConfirmed")
    private Boolean emailConfirmed;

    @Nullable
    @JsonProperty("emailAuthFactor")
    private Boolean emailAuthFactor;

    @Nonnull
    @JsonProperty("accessJwt")
    private String accessJwt;

    @Nonnull
    @JsonProperty("refreshJwt")
    private String refreshJwt;

    @Nullable
    @JsonProperty("active")
    private Boolean active;
}
