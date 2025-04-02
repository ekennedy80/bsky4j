package api.rest.graph;

import static api.rest.GlobalVars.BSKY_URL;
import static api.rest.GlobalVars.GET_ACTOR_STARTER_PACKS;
import static api.rest.GlobalVars.GET_BLOCKS_GRAPH;
import static api.rest.GlobalVars.GET_FOLLOWERS;
import static api.rest.GlobalVars.GET_FOLLOWS;
import static api.rest.GlobalVars.GET_KNOWN_FOLLOWERS;

import java.net.URI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import api.rest.app.bsky.AbstractClient;
import api.rest.graph.defs.ActorStarterPacks;
import api.rest.graph.defs.Blocks;
import api.rest.graph.defs.Followers;
import api.rest.graph.defs.Follows;
import api.rest.graph.defs.GraphList;
import api.rest.graph.defs.KnownFollowers;
import jakarta.ws.rs.core.MediaType;

public class GraphHandler extends AbstractClient {

    private static final Logger LOGGER = LogManager.getLogger(GraphHandler.class);

    public GraphHandler() {
        super();
        LOGGER.debug("Instantiating GraphHandler.");
    }

    private static class SingletonHelper {
        private static final GraphHandler INSTANCE = new GraphHandler();
    }

    public static GraphHandler getInstance() {
        return SingletonHelper.INSTANCE;
    }

    /**
     * Get a list of starter packs created by the actor.
     * @param jwtToken
     * @param actor
     * @param limit
     * @param cursor
     * @return
     */
    public ActorStarterPacks getActorStarterPacks(String jwtToken, String actor, Integer limit, String cursor) {
        return client.target(BSKY_URL + GET_ACTOR_STARTER_PACKS)
                .queryParam("actor", actor)
                .queryParam("cursor", cursor)
                .queryParam("limit", limit)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + jwtToken)
                .get(ActorStarterPacks.class);
    }

    /**
     * Enumerates which accounts the requesting account is currently blocking. Requires auth.
     * @param jwtToken
     * @param cursor
     * @param limit
     * @return
     */
    public Blocks getBlocks(String jwtToken, String cursor, Integer limit) {
        return client.target(BSKY_URL + GET_BLOCKS_GRAPH)
                .queryParam("limit", limit)
                .queryParam("cursor", cursor)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + jwtToken)
                .get(Blocks.class);
    }

    /**
     * Enumerates accounts which follow a specified account (actor).
     * @param jwtToken
     * @param actor
     * @param limit
     * @param cursor
     * @return
     */
    public Followers getFollowers(String jwtToken, String actor, Integer limit, String cursor) {
        return client.target(BSKY_URL + GET_FOLLOWERS)
                .queryParam("actor", actor)
                .queryParam("limit", limit)
                .queryParam("cursor", cursor)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + jwtToken)
                .get(Followers.class);
    }

    /**
     * Enumerates accounts which a specified account (actor) follows.
     * @param jwtToken
     * @param actor
     * @param limit
     * @param cursor
     * @return
     */
    public Follows getFollows(String jwtToken, String actor, Integer limit, String cursor) {
        return client.target(BSKY_URL + GET_FOLLOWS)
                .queryParam("actor", actor)
                .queryParam("limit", limit)
                .queryParam("cursor", cursor)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + jwtToken)
                .get(Follows.class);
    }

    /**
     * Enumerates accounts which follow a specified account (actor) and are followed by the viewer.
     * @param jwtToken
     * @param actor
     * @param limit
     * @param cursor
     * @return
     */
    public KnownFollowers getKnownFollowers(String jwtToken, String actor, Integer limit, String cursor) {
        return client.target(BSKY_URL + GET_KNOWN_FOLLOWERS)
                .queryParam("actor", actor)
                .queryParam("limit", limit)
                .queryParam("cursor", cursor)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + jwtToken)
                .get(KnownFollowers.class);
    }

    /**
     * Gets a 'view' (with additional context) of a specified list.
     * @param jwtToken
     * @param list Reference (AT-URI) of the list record to hydrate.
     * @param limit Possible values: >= 1 and <= 100 [Default value: 50]
     * @param cursor
     * @return
     */
    public GraphList getList(String jwtToken, URI list, Integer limit, String cursor) {
        return client.target(BSKY_URL + GET_KNOWN_FOLLOWERS)
                .queryParam("list", list.toString())
                .queryParam("limit", limit)
                .queryParam("cursor", cursor)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + jwtToken)
                .get(GraphList.class);
    }

}
