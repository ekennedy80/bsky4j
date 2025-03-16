package api.rest.app.bsky.feed.defs;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class RootDeserializer extends StdDeserializer<Object> {

    public RootDeserializer() {
        this(null);
    }

    public RootDeserializer(Class<Object> t) {
        super(t);
    }

    private static final Logger LOGGER = LogManager.getLogger(RootDeserializer.class); 

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {

        JsonNode node = p.getCodec().readTree(p);
        String type = node.get("$type").asText();
        switch(type) {
            case "app.bsky.feed.defs#postView": 
                if(LOGGER.isDebugEnabled())
                    LOGGER.info("Deserialized root to PostView");
                return createPostView(p);
            case "app.bsky.feed.defs#notFoundPost":
                if(LOGGER.isDebugEnabled())
                    LOGGER.info("Deserialized root to NotFoundPost");
                return createNotFoundPost(p);
            case "app.bsky.feed.defs#blockedPost":
                if(LOGGER.isDebugEnabled())
                    LOGGER.info("Deserialized root to BlockedPost");
                return createBlockedPost(p);
            default:
                return null;
        }

    }

    private PostView createPostView(JsonParser jsonParser) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonParser, PostView.class);
    }

    private NotFoundPost createNotFoundPost(JsonParser jsonParser) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonParser, NotFoundPost.class);
    }

    private BlockedPost createBlockedPost(JsonParser jsonParser) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonParser, BlockedPost.class);
    }
    
}
