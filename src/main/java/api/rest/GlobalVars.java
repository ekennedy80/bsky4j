package api.rest;

public class GlobalVars {

    private GlobalVars() {}
    public static final String APP_TOKEN = "hjlh-u644-7jk3-bjs7"; //Access token for this specific application instance
    public static final String HANDLE = "ekennedy80.bsky.social"; //My BlueSky handle
    public static final String DID = "did:plc:pgdrqxzv4kxt7tr3sa6pd77y";
    public static final String BSKY_URL = "https://bsky.social/xrpc/"; //Base URL for BlueSky
    public static final String API_KEY_URL = "com.atproto.server.createSession";
    public static final String FEED_URL = "app.bsky.feed.getAuthorFeed";
    public static final String DID_URL = "com.atproto.identity.resolveHandle";
    public static final String PREFERENCES = "app.bsky.actor.getPreferences";
    public static final String PROFILE = "app.bsky.actor.getProfile";
    public static final String CREATE_RECORD = "com.atproto.repo.createRecord";
    public static final String GET_SUGGESTIONS = "app.bsky.actor.getSuggestions";
}
