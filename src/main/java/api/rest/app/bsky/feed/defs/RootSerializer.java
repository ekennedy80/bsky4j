package api.rest.app.bsky.feed.defs;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class RootSerializer extends StdSerializer<Object> {

    public RootSerializer() {
        this(null);
    }

    public RootSerializer(Class<Object> t) {
        super(t);
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        
        if (value instanceof PostView postView) {
            gen.writePOJO(postView);
        } else if (value instanceof NotFoundPost notFoundPost) {
            gen.writePOJO(notFoundPost);
        } else if (value instanceof BlockedPost blockedPost) {
            gen.writePOJO(blockedPost);
        }
    }
    
}
