package api.rest.app.bsky.actor.profile;

import api.rest.app.bsky.actor.preferences.defs.PreferencesDef;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

public class ProfileDefTest {

    @Test
    void testMyProfileUnmarshalling() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ProfileDef profileData = null;
        try {
            URL resourceAbsolutePath = getClass().getClassLoader().getResource("api/rest/app/bsky/actor/profile/myprofile.json");
            Assertions.assertNotNull(resourceAbsolutePath);
            profileData = objectMapper.readValue(resourceAbsolutePath, ProfileDef.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(profileData);
        //TODO: Assert all data is correctly unmarshalled into PreferencesDef object
    }

    @Test
    void testAutoExampleProfileUnmarshalling() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ProfileDef profileData = null;
        try {
            URL resourceAbsolutePath = getClass().getClassLoader().getResource("api/rest/app/bsky/actor/profile/auto-example.json");
            Assertions.assertNotNull(resourceAbsolutePath);
            profileData = objectMapper.readValue(resourceAbsolutePath, ProfileDef.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(profileData);
        //TODO: Assert all data is correctly unmarshalled into PreferencesDef object
    }
}
