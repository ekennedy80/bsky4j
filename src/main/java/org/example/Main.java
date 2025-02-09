package org.example;

import api.rest.HttpClientUtils;
import api.rest.app.bsky.actor.preferences.Preferences;
import api.rest.app.bsky.actor.profile.Profile;
import api.rest.app.bsky.actor.suggestions.Request;
import api.rest.app.bsky.actor.suggestions.SuggestionsDef;
import api.rest.com.atproto.server.BskySession;
import api.rest.com.atproto.server.ServerHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static api.rest.GlobalVars.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws JsonProcessingException {

//        Client client = ClientBuilder.newClient();
//        String did = client.target(BSKY_URL + DID_URL)
//                .queryParam("handle", HANDLE)
//                .request(MediaType.TEXT_PLAIN).get(String.class);
//        System.out.println("Bsky DID: " + did);

//        ObjectMapper mapper = new ObjectMapper();
//        ObjectNode user = mapper.createObjectNode();

        //Create a thread that creates and Bluesky session and refreshes the session every N minutes
        ServerHandler handler = new ServerHandler();
        BskySession session = handler.createSession(HANDLE, APP_TOKEN, null);

        

//        /* Searching posts in BlueSky *********************************************************************************/
//        System.out.println("SEARCHING BSKY RESULTS:\n" + searchPosts("Can anyone PLEASE", jwtToken));
//
//        /* Getting posts from my feed *********************************************************************************/
//        String jsonResponse = client.target(BSKY_URL + FEED_URL)
//                .queryParam("actor", HANDLE)
//                .queryParam("limit", 20)
//                .request(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + jwtToken)
//                .get(String.class);
//        System.out.println("\n\nFeed: " + jsonResponse);
//
//        /* Getting my account preferences *****************************************************************************/
//        Preferences prefs = client.target(BSKY_URL + PREFERENCES)
//                .request(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + jwtToken)
//                .get(Preferences.class);
//        System.out.println("\n\nPreferences1: " + prefs.asJsonString());
//
//        /* Getting my profile information *****************************************************************************/
//        Profile profile = client.target(BSKY_URL + PROFILE)
//                .queryParam("actor", HANDLE)
//                .request(MediaType.APPLICATION_JSON)
//                .header("Authorization", "Bearer " + jwtToken)
//                .get(Profile.class);
//        System.out.println("\n\nProfile: " + profile.asJsonString());
//
//        /* List records ************************************************************************************************/
//        JsonNode records = client.target(BSKY_URL+LIST_RECORDS)
//                .queryParam("repo", DID)
//                .queryParam("collection", "app.bsky.feed.post")
//                .queryParam("limit", 100)
//                .request(MediaType.APPLICATION_JSON)
//                .header("Authorization", "Bearer " + jwtToken)
//                .get(JsonNode.class);
//        System.out.println("\n\nRecords: " +records);
//        JsonNode array = records.get("records");
//        System.out.println("\n\nArray: " +array);
//        Iterator<JsonNode> itr = array.elements();
//        while(itr.hasNext()) {
//            JsonNode node = itr.next();
//            String post = node.get("value").get("text").toString();
//            System.out.println(post);
////            if(post.equals("\"\"")){
//////                System.out.println("POST IS EMPTY");
////                System.out.println(node);
////            }
////            if(post.toLowerCase().contains("musk")){
////                System.out.println(post);
////            }
//        }
//
//        String date = "2019-07-14T18:30:00.000Z";
//        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
//        Date parsedDate = null;
//        try {
//            parsedDate = inputFormat.parse(date);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        String formattedDate = outputFormat.format(parsedDate);
//        System.out.println("Date: " + parsedDate.getTime() + "\nParsed Date: " + formattedDate);
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
            return client.target(BSKY_URL + SEARCH_POSTS)
                    .queryParam("q", query)
                    .queryParam("sort", "top")
                    .queryParam("author", DID)
                    .request(MediaType.APPLICATION_JSON)
                    .header("Authorization", "Bearer " + sessionToken)
                    .get(String.class);
        }
    }

//    private static SuggestionsDef getSuggestions(Request request, String sessionToken) {
//        try (Client client = ClientBuilder.newClient()) {
//            return client.target(BSKY_URL+GET_SUGGESTIONS)
//                    .queryParam("limit",request.getLimit())
//                    .queryParam("cursor", request.getCursor())
//                    .request(MediaType.APPLICATION_JSON)
//                    .header("Authorization", "Bearer " + sessionToken)
//                    .get(SuggestionsDef.class);
//        }
//    }

    private static Thread startSessionThread(String name) {
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
}
