package api.rest.com.atproto.repo;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

import java.io.Closeable;
import java.io.IOException;

import static api.rest.GlobalVars.BSKY_URL;
import static api.rest.GlobalVars.LIST_RECORDS;

public class RepoRestHandler implements Closeable {

    private final Client client = ClientBuilder.newClient();

    public String listRecords(String repo, String collection, Integer limit, String cursor, Boolean reverse) {
        WebTarget webTarget = client.target(BSKY_URL+LIST_RECORDS);
        webTarget.queryParam("repo", repo).queryParam("collection", collection);
        if(limit != null)
            webTarget.queryParam("limit", limit);
        if(cursor != null)
            webTarget.queryParam("cursor", cursor);
        if(reverse != null)
            webTarget.queryParam("reverse", reverse);
        webTarget.request(MediaType.APPLICATION_JSON)
//                .header("Authorization", "Bearer " + jwtToken)
                .get(JsonNode.class);
        return "";
    }

    @Override
    public void close() throws IOException {
        client.close();
    }
}
