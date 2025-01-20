package api.rest.app.bsky.actor.preferences;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

public class PreferencesDefTest {

    @Test
    void testExample1Unmarshalling() {
        ObjectMapper objectMapper = new ObjectMapper();
        PreferencesDef prefData = null;
        try {
            URL resourceAbsolutePath = getClass().getClassLoader().getResource("api/rest/app/bsky/actor/preferences/example1.json");
            Assertions.assertNotNull(resourceAbsolutePath);
            prefData = objectMapper.readValue(resourceAbsolutePath, PreferencesDef.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(prefData);
        //TODO: Assert all data is correctly unmarshalled into PreferencesDef object
    }

    @Test
    void testExample2Unmarshalling() {
        ObjectMapper objectMapper = new ObjectMapper();
        PreferencesDef prefData = null;
        try {
            URL resourceAbsolutePath = getClass().getClassLoader().getResource("api/rest/app/bsky/actor/preferences/example2.json");
            Assertions.assertNotNull(resourceAbsolutePath);
            prefData = objectMapper.readValue(resourceAbsolutePath, PreferencesDef.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(prefData);
        //TODO: Assert all data is correctly unmarshalled into PreferencesDef object
    }
}
