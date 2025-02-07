package api.rest.app.bsky;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;

public abstract class AbstractClient implements AutoCloseable {

    protected final Client client;

    public AbstractClient() {
        client = ClientBuilder.newClient();
    }

    public void close() {
        client.close();
    }
}
