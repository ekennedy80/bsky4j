package api.rest.app.bsky.feed.model;

import java.io.IOException;
import java.net.URL;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.rest.app.bsky.feed.defs.ActorLikes;

class ActorLikesTest {
    
    @Test
    void testActorLikesUnmarshalling1() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ActorLikes actorLikes;
        try {
            URL resourceAbsolutePath = getClass().getClassLoader().getResource("api/rest/app/bsky/feed/ActorLikes.json");
            Assertions.assertNotNull(resourceAbsolutePath);
            actorLikes = objectMapper.readValue(resourceAbsolutePath, ActorLikes.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(actorLikes);
        System.out.println(actorLikes.asJsonString());
        //TODO: Assert all data is correctly unmarshalled into PreferencesDef object
    }
}
