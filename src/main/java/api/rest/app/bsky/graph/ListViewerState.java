package api.rest.app.bsky.graph;

import java.net.URI;

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
public class ListViewerState {
    
    @Nullable
        @JsonProperty("muted")
        private Boolean muted;

        @Nullable
        @JsonProperty("blocked")
        private URI blocked;
}
