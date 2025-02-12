package api.rest;

public class GlobalVars {

    private GlobalVars() {}
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    public static final String APP_TOKEN = "hjlh-u644-7jk3-bjs7"; //Access token for this specific application instance
    public static final String HANDLE = "ekennedy80.bsky.social"; //My BlueSky handle
    public static final String DID = "did:plc:pgdrqxzv4kxt7tr3sa6pd77y";
    public static final String BSKY_URL = "https://bsky.social/xrpc/"; //Base URL for BlueSky
    // app.bsky.actor xrpc methods
    public static final String GET_PREFERENCES = "app.bsky.actor.getPreferences";
    public static final String GET_PROFILE = "app.bsky.actor.getProfile";
    public static final String GET_PROFILES = "app.bsky.actor.getProfiles";
    public static final String GET_SUGGESTIONS = "app.bsky.actor.getSuggestions";
    public static final String PUT_PREFERENCES = "app.bsky.actor.putPreferences";
    public static final String SEARCH_ACTORS_TYPE_AHEAD = "app.bsky.actor.searchActorsTypeahead";
    public static final String SEARCH_ACTORS = "app.bsky.actor.searchActors";
    // app.bsky.feed xrpc methods
    public static final String DESCRIBE_FEED_GENERATOR = "app.bsky.feed.describeFeedGenerator";
    public static final String GET_ACTOR_FEEDS = "app.bsky.feed.getActorFeeds";
    public static final String GET_ACTOR_LIKES = "app.bsky.feed.getActorLikes";
    public static final String GET_AUTHOR_FEED = "app.bsky.feed.getAuthorFeed";
    public static final String GET_FEED_GENERATOR = "app.bsky.feed.getFeedGenerator";
    public static final String GET_FEED_GENERATORS = "app.bsky.feed.getFeedGenerators";
    public static final String GET_FEED_SKELETON = "app.bsky.feed.getFeedSkeleton";
    public static final String GET_FEED = "app.bsky.feed.getFeed";
    public static final String GET_LIKES = "app.bsky.feed.getLikes";
    public static final String GET_LIST_FEED = "app.bsky.feed.getListFeed";
    public static final String GET_POST_THREAD = "app.bsky.feed.getPostThread";
    public static final String GET_POSTS = "app.bsky.feed.getPosts";
    public static final String GET_QUOTES = "app.bsky.feed.getQuotes";
    public static final String GET_REPOSTED_BY = "app.bsky.feed.getRepostedBy";
    public static final String GET_SUGGESTED_FEEDS = "app.bsky.feed.getSuggestedFeeds";
    public static final String GET_TIMELINE = "app.bsky.feed.getTimeline";
    public static final String SEARCH_POSTS = "app.bsky.feed.searchPosts";
    public static final String SEND_INTERACTIONS = "app.bsky.feed.sendInteractions";
    // app.bsky.graph xrpc methods
    public static final String GET_AUTHOR_STARTER_PACKS = "";
    public static final String GET_BLOCKS_GRAPH = "";
    public static final String GET_FOLLOWERS = "";
    public static final String GET_FOLLOWS = "";
    public static final String GET_KNOWN_FOLLOWERS = "";
    public static final String GET_LIST_BLOCKS = "";
    public static final String GET_LIST_MUTES = "";
    public static final String GET_LIST = "";
    public static final String GET_LISTS = "";
    public static final String GET_MUTES = "";
    public static final String GET_RELATIONSHIPS = "";
    public static final String GET_STARTER_PACK = "";
    public static final String GET_STARTER_PACKS = "";
    public static final String GET_SUGGESTED_FOLLOWS_BY_ACTOR = "";
    public static final String MUTE_ACTOR_LIST = "";
    public static final String MUTE_ACTOR = "";
    public static final String MUTE_THREAD = "";
    public static final String SEARCH_STARTER_PACKS = "";
    public static final String UNMUTE_ACTOR_LIST = "";
    public static final String UNMUTE_ACTOR = "";
    public static final String UNMUTE_THREAD = "";
    // app.bsky.labeler xrpc methods
    public static final String GET_SERVICES = "app.bsky.labeler.getServices";
    // app.bsky.notification xrpc methods
    public static final String GET_UNREAD_COUNT = "";
    public static final String LIST_NOTIFICATIONS = "";
    public static final String PUT_PREFERENCES_NOTIF = "";
    public static final String REGISTER_PUSH = "";
    public static final String UPDATE_SEEN = "";
    // app.bsky.video xrpc methods
    public static final String GET_JOB_STATUS = "";
    public static final String GET_UPLOAD_LIMITS = "";
    public static final String UPLOAD_VIDEO = "";
    // chat.bsky.actor xrpc methods
    public static final String DELETE_ACCOUNT_ACTOR = "";
    public static final String EXPORT_ACCOUNT_DATA = "";
    // chat.bsky.convo xrpc methods
    public static final String DELETE_MESSAGE_FOR_SELF = "";
    public static final String GET_CONVO_FOR_MEMBERS = "";
    public static final String GET_CONVO = "";
    public static final String GET_LOG = "";
    public static final String GET_MESSAGES = "";
    public static final String LEAVE_CONVO = "";
    public static final String LIST_CONVOS = "";
    public static final String MUTE_CONVO = "";
    public static final String SEND_MESSAGE_BATCH = "";
    public static final String SEND_MESSAGE = "";
    public static final String UNMUTE_CONVO = "";
    public static final String UPDATE_READ = "";
    // chat.bsky.moderation xrpc methods
    public static final String GET_ACTOR_METADATA = "";
    public static final String GET_MESSAGE_CONTEXT = "";
    public static final String UPDATE_ACTOR_ACCESS = "";
    // com.atproto.admin xrpc methods
    public static final String DELETE_ACCOUNT_ADMIN = "";
    public static final String DISABLE_ACCOUNT_INVITES = "";
    public static final String DISABLE_INVITE_CODES = "";
    public static final String ENABLE_ACCOUNT_INVITES = "";
    public static final String GET_ACCOUNT_INFO = "";
    public static final String GET_ACCOUNT_INFOS = "";
    public static final String GET_INVITE_CODES = "";
    public static final String GET_SUBJECT_STATUS = "";
    public static final String SEARCH_ACCOUNTS = "";
    public static final String SEND_EMAIL = "";
    public static final String UPDATE_ACCOUNT_EMAIL = "";
    public static final String UPDATE_ACCOUNT_HANDLE = "";
    public static final String UPDATE_ACCOUNT_PASSWORD = "";
    public static final String UPDATE_SUBJECT_STATUS = "";
    // com.atproto.identity xrpc methods
    public static final String GET_RECOMMENDED_DID_CREDENTIALS = "";
    public static final String REQUEST_PLC_OPERATION_SIGNATURE = "";
    public static final String RESOLVE_HANDLE = "com.atproto.identity.resolveHandle";
    public static final String SIGN_PLC_OPERATION = "";
    public static final String SUBMIT_PLC_OPERATION = "";
    public static final String UPDATE_HANDLE = "";
    // com.atproto.label xrpc methods
    public static final String QUERY_LABELS = "";
    // com.atproto.moderation xrpc methods
    public static final String CREATE_REPORT = "";
    // com.atproto.repo xrpc methods
    public static final String APPLT_WRITES = "";
    public static final String CREATE_RECORD = "com.atproto.repo.createRecord";
    public static final String DELETE_RECORD = "";
    public static final String DESCRIBE_REPO = "";
    public static final String GET_RECORD_REPO = "";
    public static final String IMPORT_REPO = "";
    public static final String LIST_MISSING_BLOBS = "";
    public static final String LIST_RECORDS = "com.atproto.repo.listRecords";
    public static final String PUT_RECORD = "";
    public static final String UPLOAD_BLOB = "";
    // com.atproto.server xrpc methods
    public static final String ACTIVATE_ACCOUNT = "";
    public static final String CHECK_ACCOUNT_STATUS = "";
    public static final String CONFIRM_EMAIL = "";
    public static final String CREATE_ACCOUNT = "";
    public static final String CREATE_APP_PASSWORD = "";
    public static final String CREATE_INVITE_CODE = "";
    public static final String CREATE_INVITE_CODES = "";
    public static final String CREATE_SESSION = "com.atproto.server.createSession";
    public static final String DEACTIVATE_ACCOUNT = "";
    public static final String DELETE_ACCOUNT_SERVER = "";
    public static final String DELETE_SESSION = "com.atproto.server.deleteSession";
    public static final String DESCRIBE_SERVER = "";
    public static final String GET_ACCOUNT_INVITE_CODES = "";
    public static final String GET_SERVICE_AUTH = "";
    public static final String GET_SESSION = "com.atproto.server.getSession";
    public static final String LIST_APP_PASSWORDS = "";
    public static final String REFRESH_SESSION = "com.atproto.server.refreshSession";
    public static final String REQUEST_ACCOUNT_DELETE = "";
    public static final String REQUEST_EMAIL_CONFIRMATION = "";
    public static final String REQUEST_EMAIL_UPDATE = "";
    public static final String REQUEST_PASSWORD_RESET = "";
    public static final String RESERVE_SIGNING_KEY = "";
    public static final String RESET_PASSWORD = "";
    public static final String REVOKE_APP_PASSWORD = "";
    public static final String UPDATE_EMAIL = "";
    // com.atproto.sync xrpc methods
    public static final String GET_BLOB = "";
    public static final String GET_BLOCKS_SYNC = "";
    public static final String GET_LATEST_COMMIT = "";
    public static final String GET_RECORD_SYNC = "";
    public static final String GET_REPO_STATUS = "";
    public static final String GET_REPO = "";
    public static final String LIST_BLOBS = "";
    public static final String LIST_REPOS = "";
    public static final String NOTIFY_OF_UPDATE = "";
    public static final String REQUEST_CRAWL = "";
    // tools.ozone.communication xrpc methods
}
