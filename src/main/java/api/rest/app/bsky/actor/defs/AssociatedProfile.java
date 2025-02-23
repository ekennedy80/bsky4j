package api.rest.app.bsky.actor.defs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssociatedProfile {

    @Nullable
    @JsonProperty("lists")
    private Integer lists;

    @Nullable
    @JsonProperty("feedgens")
    private Integer feedgens;

    @Nullable
    @JsonProperty("starterPacks")
    private Integer starterPacks;

    @Nullable
    @JsonProperty("labeler")
    private Boolean labeler;

    @Nullable
    @JsonProperty("chat")
    private AssociatedProfileChat chat;

}
