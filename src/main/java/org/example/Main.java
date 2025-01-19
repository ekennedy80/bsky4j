package org.example;

import api.rest.app.bsky.actor.preferences.defs.PreferencesDef;
import api.rest.app.bsky.actor.profile.ProfileDef;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String APP_TOKEN = "hjlh-u644-7jk3-bjs7";
    private static final String HANDLE = "ekennedy80.bsky.social";
    private static final String BSKY_URL = "https://bsky.social/";
    private static final String API_KEY_URL = "xrpc/com.atproto.server.createSession";
    private static final String FEED_URL = "xrpc/app.bsky.feed.getAuthorFeed";
    private static final String DID_URL = "xrpc/com.atproto.identity.resolveHandle";
    private static final String PREFERENCES = "xrpc/app.bsky.actor.getPreferences";
    private static final String PROFILE = "xrpc/app.bsky.actor.getProfile";

    public static void main(String[] args) throws JsonProcessingException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!%n");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        Client client = ClientBuilder.newClient();
        String did = client.target(BSKY_URL+DID_URL)
                .queryParam("handle",HANDLE)
                .request(MediaType.TEXT_PLAIN).get(String.class);
        System.out.println("Bsky DID: "+did);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode user = mapper.createObjectNode();
        user.put("identifier",HANDLE);
        user.put("password",APP_TOKEN);
        Response response = client.target(BSKY_URL+API_KEY_URL)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(user.toString()));
        String bskySession = response.readEntity(String.class);
        System.out.println("\n\nSession: "+bskySession);
        BlueskySession session = null;
        try {
            session = mapper.readValue(bskySession, BlueskySession.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        String jwtToken = session.getAccessJwt();
        System.out.println("\n\nSession: "+session);

        String jsonResponse = client.target(BSKY_URL+FEED_URL)
                .queryParam("actor", HANDLE)
                .queryParam("limit", 2)
                .request(MediaType.APPLICATION_JSON).header("Authorization","Bearer "+jwtToken)
                .get(String.class);
        System.out.println("\n\nFeed: "+jsonResponse);

        PreferencesDef prefs = client.target(BSKY_URL+PREFERENCES)
                .request(MediaType.APPLICATION_JSON).header("Authorization","Bearer "+jwtToken)
                .get(PreferencesDef.class);
        System.out.println("\n\nPreferences1: "+prefs.asJsonString());

        ProfileDef profileDef = client.target(BSKY_URL+PROFILE)
                .queryParam("actor", HANDLE)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization","Bearer "+jwtToken)
                .get(ProfileDef.class);
        System.out.println("\n\nProfile: "+profileDef.asJsonString());

        String date = "2019-07-14T18:30:00.000Z";
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        Date parsedDate = null;
        try {
            parsedDate = inputFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String formattedDate = outputFormat.format(parsedDate);
        System.out.println("Date: "+parsedDate.getTime()+"\nParsed Date: "+formattedDate);
    }
}