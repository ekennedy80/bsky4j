package api.rest.app.bsky.actor.suggestions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static api.rest.GlobalVars.BSKY_URL;
import static api.rest.GlobalVars.GET_SUGGESTIONS;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Request {

    @Nullable
    @JsonProperty("limit")
    private Integer limit; //Possible values: >= 1 and <= 100, Default value: 50

    @Nullable
    @JsonProperty("cursor")
    private String cursor;

    public WebTarget getClient() {

        try (Client client = ClientBuilder.newClient()) {
            WebTarget webTarget = client.target(BSKY_URL+GET_SUGGESTIONS);
            if(this.limit != null)
                webTarget.queryParam("limit",this.limit);
            if(this.cursor != null)
                webTarget.queryParam("cursor", this.cursor);

            return webTarget;
        }
    }
}
