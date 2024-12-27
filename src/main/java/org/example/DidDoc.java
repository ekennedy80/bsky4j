package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DidDoc {

    @JsonProperty("@context")
    private List<String> context;

    @JsonProperty("id")
    private String id;

    @JsonProperty("alsoKnownAs")
    private List<String> alsoKnownAs;

    @JsonProperty("verificationMethod")
    private List<VerificationMethod> verificationMethod;

    @JsonProperty("service")
    private List<Service> service;
}
