package api.rest.app.bsky.actor.suggestions;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

class SuggestionsDefTest {

    @Test
    void testSuggestionsUnmarshalling1() {
        ObjectMapper objectMapper = new ObjectMapper();
        SuggestionsDef suggestionData;
        try {
            URL resourceAbsolutePath = getClass().getClassLoader().getResource("api/rest/app/bsky/actor/suggestions/mysuggestions.json");
            Assertions.assertNotNull(resourceAbsolutePath);
            suggestionData = objectMapper.readValue(resourceAbsolutePath, SuggestionsDef.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(suggestionData);
        //TODO: Assert all data is correctly unmarshalled into PreferencesDef object
    }

    @Test
    void testSuggestionsUnmarshalling2() {
        ObjectMapper objectMapper = new ObjectMapper();
        SuggestionsDef suggestionData;
        try {
            URL resourceAbsolutePath = getClass().getClassLoader().getResource("api/rest/app/bsky/actor/suggestions/suggestions.json");
            Assertions.assertNotNull(resourceAbsolutePath);
            suggestionData = objectMapper.readValue(resourceAbsolutePath, SuggestionsDef.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(suggestionData);

        //TODO: Assert all data is correctly unmarshalled into PreferencesDef object
    }
}
