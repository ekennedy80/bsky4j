package api.rest.app.bsky.feed.defs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CustomThreadDeserializer extends StdDeserializer<Object> {

    private static final Logger LOGGER = LogManager.getLogger(CustomThreadDeserializer.class); 

    public CustomThreadDeserializer() {
        this(null);
    }

    public CustomThreadDeserializer(Class<Object> t) {
        super(t);
    }

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        
        JsonNode node = p.getCodec().readTree(p);

        ArrayList<String> fieldNames = new ArrayList<>();
        Iterator<String> itr = node.fieldNames();
        while(itr.hasNext()) {
            String fieldName = itr.next();
            fieldNames.add(fieldName);
            LOGGER.info("FieldName: {}", fieldName);
        }

        if (fieldNames.contains("post")) {
            return createThreadViewPost(p);
        } else if (fieldNames.contains("notFound")) {
            return createNotFoundPost(p);
        } else if (fieldNames.contains("blocked")) {
            return createBlockedPost(p);
        }

        return null;
    }

    private ThreadViewPost createThreadViewPost(JsonParser jsonParser) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonParser, ThreadViewPost.class);
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
