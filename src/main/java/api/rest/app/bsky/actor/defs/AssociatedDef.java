package api.rest.app.bsky.actor.defs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssociatedDef {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class Chat {

        @Nonnull
        @JsonProperty("allowIncoming")
        private String allowIncoming; //Possible values: [all, none, following]
    }

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
    private Chat chat;

}
