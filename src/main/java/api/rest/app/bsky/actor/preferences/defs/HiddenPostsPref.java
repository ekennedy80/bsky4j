package api.rest.app.bsky.actor.preferences.defs;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HiddenPostsPref {

    @Nonnull
    @JsonProperty("items")
    private List<URI> items;
}
