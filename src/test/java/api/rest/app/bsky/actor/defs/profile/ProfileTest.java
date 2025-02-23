package api.rest.app.bsky.actor.defs.profile;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

class ProfileTest {

    @Test
    void profileUnmarshallingTest() {
        ObjectMapper objectMapper = new ObjectMapper();
        ProfileViewDetailed profile = null;
        try {
            URL resourceAbsolutePath = getClass().getClassLoader().getResource("api/rest/app/bsky/actor/profile/profile.json");
            Assertions.assertNotNull(resourceAbsolutePath);
            profile = objectMapper.readValue(resourceAbsolutePath, ProfileViewDetailed.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(profile);
        //TODO: Assert all data is correctly unmarshalled into PreferencesDef object

        Assertions.assertEquals("https://cdn.bsky.app/img/avatar/plain/did:plc:pgdrqxzv4kxt7tr3sa6pd77y/bafkreibie4drzpb2ses65kqpyt2g2fttrpzwwaqbwvsswnaxdzmi64wsve@jpeg", profile.getAvatar().toString());
        Assertions.assertEquals("did:plc:pgdrqxzv4kxt7tr3sa6pd77y", profile.getDid());
        Assertions.assertEquals("Eddie Kennedy", profile.getDisplayName());
        Assertions.assertEquals(new Date(1699856119432L).getTime(), profile.getCreatedAt().getTime());
        // Assertions.assertEquals("ekennedy80.bsky.social", profile.getHandle());
        // Assertions.assertEquals("ekennedy80.bsky.social", profile.getHandle());
        // Assertions.assertEquals("ekennedy80.bsky.social", profile.getHandle());
    }
    
}
