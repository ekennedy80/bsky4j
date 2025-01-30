package api.rest;

import api.rest.defs.BskySession;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import static api.rest.GlobalVars.API_KEY_URL;
import static api.rest.GlobalVars.BSKY_URL;

public final class HttpClientUtils {

    static Client client = ClientBuilder.newClient();

    private HttpClientUtils(){    }

    public static BskySession getSession(String identifier, String password, String authFactorToken) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode user = mapper.createObjectNode();
        user.put("identifier", identifier);
        user.put("password", password);
        if(authFactorToken != null) {
            user.put("authFactorToken", authFactorToken);
        }
        try (Response response = client.target(BSKY_URL + API_KEY_URL)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(user.toString()))) {
            return response.readEntity(BskySession.class);
        }
    }

    public static BskySession refreshSession() {

    }
}
