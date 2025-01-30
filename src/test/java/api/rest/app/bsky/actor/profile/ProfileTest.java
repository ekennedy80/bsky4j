package api.rest.app.bsky.actor.profile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

class ProfileTest {

    @Test
    void testMyProfileUnmarshalling() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Profile profileData = null;
        try {
            URL resourceAbsolutePath = getClass().getClassLoader().getResource("api/rest/app/bsky/actor/profile/myprofile.json");
            Assertions.assertNotNull(resourceAbsolutePath);
            profileData = objectMapper.readValue(resourceAbsolutePath, Profile.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(profileData);
        //TODO: Assert all data is correctly unmarshalled into PreferencesDef object
    }

    @Test
    void testAutoExampleProfileUnmarshalling() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Profile profileData;
        try {
            URL resourceAbsolutePath = getClass().getClassLoader().getResource("api/rest/app/bsky/actor/profile/auto-example.json");
            Assertions.assertNotNull(resourceAbsolutePath);
            profileData = objectMapper.readValue(resourceAbsolutePath, Profile.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(profileData);
        //TODO: Assert all data is correctly unmarshalled into PreferencesDef object
    }
}
