package org.example;

import api.rest.HttpClientUtils;
import api.rest.app.bsky.actor.preferences.PreferencesDef;
import api.rest.app.bsky.actor.profile.Profile;
import api.rest.app.bsky.actor.suggestions.Request;
import api.rest.app.bsky.actor.suggestions.SuggestionsDef;
import api.rest.defs.BskySession;
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
import java.time.Instant;
import java.util.Date;

import static api.rest.GlobalVars.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

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
        String did = client.target(BSKY_URL + DID_URL)
                .queryParam("handle", HANDLE)
                .request(MediaType.TEXT_PLAIN).get(String.class);
        System.out.println("Bsky DID: " + did);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode user = mapper.createObjectNode();

        /* Creating a Bluesky session *********************************************************************************/
//        user.put("identifier", HANDLE);
//        user.put("password", APP_TOKEN);
//        Response response = client.target(BSKY_URL + API_KEY_URL)
//                .request(MediaType.APPLICATION_JSON)
//                .post(Entity.json(user.toString()));
//        String bskySession = response.readEntity(String.class);
//        System.out.println("\n\nSession: " + bskySession);
        BskySession session = HttpClientUtils.getSession(HANDLE, APP_TOKEN, null);
        System.out.println("\n\n******************** Session ********************\n" + session.asJsonString());
        

        /* Searching posts in BlueSky *********************************************************************************/
        System.out.println("SEARCHING BSKY RESULTS:\n" + searchPosts("Can anyone PLEASE", jwtToken));

        /* Getting friend suggestions from BlueSky ********************************************************************/
        Request request = new Request(20, null);
        SuggestionsDef suggestions = getSuggestions(request, jwtToken);
        System.out.println("**************** SUGGESTIONS:\n" + suggestions.asJsonString());

        /* Getting posts from my feed *********************************************************************************/
        String jsonResponse = client.target(BSKY_URL + FEED_URL)
                .queryParam("actor", HANDLE)
                .queryParam("limit", 20)
                .request(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + jwtToken)
                .get(String.class);
        System.out.println("\n\nFeed: " + jsonResponse);

        /* Getting my account preferences *****************************************************************************/
        PreferencesDef prefs = client.target(BSKY_URL + PREFERENCES)
                .request(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + jwtToken)
                .get(PreferencesDef.class);
        System.out.println("\n\nPreferences1: " + prefs.asJsonString());

        /* Getting my profile information *****************************************************************************/
        Profile profile = client.target(BSKY_URL + PROFILE)
                .queryParam("actor", HANDLE)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + jwtToken)
                .get(Profile.class);
        System.out.println("\n\nProfile: " + profile.asJsonString());

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
        System.out.println("Date: " + parsedDate.getTime() + "\nParsed Date: " + formattedDate);
    }

    private static Response createRecord(String sessionToken) {
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date timestamp = Date.from(Instant.now());

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode request = mapper.createObjectNode();
        ObjectNode record = mapper.createObjectNode();
        record.put("$type", "app.bsky.feed.post")
                .put("text", "This is a test and occurred on " + Date.from(Instant.now()))
                .put("createdAt", outputFormat.format(timestamp));
        request.put("repo", DID)
                .put("collection", "app.bsky.feed.post")
                .put("validate", true)
                .set("record", record);
        ;

        System.out.println("Record: " + request.toString());

        try (Client client = ClientBuilder.newClient()) {
            return client.target(BSKY_URL + CREATE_RECORD)
                    .request(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + sessionToken)
                    .post(Entity.json(request));
        }
    }

    private static String searchPosts(String query, String sessionToken) {
        try (Client client = ClientBuilder.newClient()) {
            return client.target(BSKY_URL + "app.bsky.feed.searchPosts")
                    .queryParam("q", query)
                    .queryParam("sort", "top")
                    .queryParam("author", DID)
                    .request(MediaType.APPLICATION_JSON)
                    .header("Authorization", "Bearer " + sessionToken)
                    .get(String.class);
        }
    }

    private static SuggestionsDef getSuggestions(Request request, String sessionToken) {
        try (Client client = ClientBuilder.newClient()) {
            return client.target(BSKY_URL+GET_SUGGESTIONS)
                    .queryParam("limit",request.getLimit())
                    .queryParam("cursor", request.getCursor())
                    .request(MediaType.APPLICATION_JSON)
                    .header("Authorization", "Bearer " + sessionToken)
                    .get(SuggestionsDef.class);
        }
    }
}
