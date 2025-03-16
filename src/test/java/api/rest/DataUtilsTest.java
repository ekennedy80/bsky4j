package api.rest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;

class DataUtilsTest {

    @Test
    void testParseRecordUri() throws DataUtils.NotBskyRecordUriException, URISyntaxException {
        String[] parts = DataUtils.parseRecordUri(new URI("at://did:plc:c2nnxxpuckisatkcyk2ffbwu/app.bsky.feed.post/3kzgko3cguy2w"));
        for(String str : parts) {
            System.out.println(str);
        }
        Assertions.assertEquals("did:plc:c2nnxxpuckisatkcyk2ffbwu", parts[0]);
        Assertions.assertEquals("app.bsky.feed.post", parts[1]);
        Assertions.assertEquals("3kzgko3cguy2w", parts[2]);
    }
}