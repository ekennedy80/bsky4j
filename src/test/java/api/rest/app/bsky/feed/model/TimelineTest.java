package api.rest.app.bsky.feed.model;

import java.io.IOException;
import java.net.URL;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.rest.app.bsky.feed.defs.Timeline;

class TimelineTest {
    
    @Test
    void testTimelineUnmarshalling1() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Timeline timeline;
        try {
            URL resourceAbsolutePath = getClass().getClassLoader().getResource("api/rest/app/bsky/feed/Timeline3.json");
            Assertions.assertNotNull(resourceAbsolutePath);
            timeline = objectMapper.readValue(resourceAbsolutePath, Timeline.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(timeline);
        System.out.println(timeline.asJsonString());
        //TODO: Assert all data is correctly unmarshalled into PreferencesDef object
    }
}
