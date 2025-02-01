package api.rest.com.atproto.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.Getter;

import java.time.Duration;

import static api.rest.GlobalVars.API_KEY_URL;
import static api.rest.GlobalVars.BSKY_URL;

public class SessionRestHandler {

    private Client client = ClientBuilder.newClient();

    @Getter
    private BskySession bskySession;

    /**
     * Create an authentication session. Kicks off a thread that refreshes the session every two minutes.
     * @param identifier Handle or other identifier supported by the server for the authenticating user.
     * @param password
     * @param authFactorToken
     * @return
     */
    public BskySession getSession(String identifier, String password, String authFactorToken) {
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
            bskySession = response.readEntity(BskySession.class);
            return bskySession;
//            try (ExecutorService executor = Executors.newSingleThreadExecutor()) {
//                // Submit a task to the executor
//                executor.submit(() -> {
//                    // Code to run in the background thread
//                    System.out.println("Hello from background thread!");
//                    Thread virtualThread = startVirtualThread("Example Thread");
//                });
//            }
        }
    }

    private static Thread startVirtualThread(String name) {
        return Thread.startVirtualThread(() -> {
            for(int i=0; i<10; i++) {
                System.out.println("==================> Running in " + name);
                try {
                    Thread.sleep(Duration.ofSeconds(1));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(name + " finished");
        });
    }

//    public BskySession refreshSession() {
//
//    }
}
