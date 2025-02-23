package api.rest.app.bsky.actor;

import static api.rest.GlobalVars.AUTHORIZATION;
import static api.rest.GlobalVars.BEARER;
import static api.rest.GlobalVars.BSKY_URL;
import static api.rest.GlobalVars.GET_PREFERENCES;
import static api.rest.GlobalVars.GET_PROFILE;
import static api.rest.GlobalVars.GET_PROFILES;
import static api.rest.GlobalVars.GET_SUGGESTIONS;
import static api.rest.GlobalVars.HANDLE;
import static api.rest.GlobalVars.PUT_PREFERENCES;
import static api.rest.GlobalVars.SEARCH_ACTORS;
import static api.rest.GlobalVars.SEARCH_ACTORS_TYPE_AHEAD;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import api.rest.app.bsky.AbstractClient;
import api.rest.app.bsky.actor.defs.Actors;
import api.rest.app.bsky.actor.defs.Suggestions;
import api.rest.app.bsky.actor.defs.preferences.Preferences;
import api.rest.app.bsky.actor.defs.profile.ProfileViewDetailed;
import api.rest.app.bsky.actor.defs.profile.Profiles;
import jakarta.annotation.Nonnull;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class ActorHandler extends AbstractClient {

    private static final Logger LOGGER = LogManager.getLogger(ActorHandler.class);

    private ActorHandler() {
        super();
        LOGGER.debug("Instantiating ActorHandler.");
    }

    private static class SingletonHelper {
        private static final ActorHandler INSTANCE = new ActorHandler();
    }

    public static ActorHandler getInstance() {
        return SingletonHelper.INSTANCE;
    }

    /**
     * Get private preferences attached to the current account. Expected use is synchronization between multiple
     * devices, and import/export during account migration. Requires auth.
     * @param jwtToken
     * @return
     */
    public Preferences getPreferences(String jwtToken) {
        return client.target(BSKY_URL + GET_PREFERENCES)
                .request(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + jwtToken)
                .get(Preferences.class);
    }

    /**
     * Get detailed profile view of an actor. Does not require auth, but contains relevant metadata with auth.
     * @param jwtToken Session JWT token
     * @param handle The handle or DID
     * @return
     */
    public ProfileViewDetailed getProfile(@Nonnull final String jwtToken, @Nonnull final String handle) {
        return client.target(BSKY_URL + GET_PROFILE)
                .queryParam("actor", HANDLE)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + jwtToken)
                .get(ProfileViewDetailed.class);
    }

    /**
     * Get detailed profile views of multiple actors.
     * @param jwtToken Session JWT token
     * @param handles Handles from multiple actors
     * @return List of profiles from multiple actors with a size <= 25
     */
    public Profiles getProfiles(@Nonnull final String jwtToken, @Nonnull final String[] handles) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode jsonArray = mapper.createArrayNode();
        for(String handle : handles) {
            jsonArray.add(handle);
        }
        return client.target(BSKY_URL + GET_PROFILES)
                .queryParam("actors", jsonArray)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + jwtToken)
                .get(Profiles.class);
    }

    /**
     * Get detailed profile views of multiple actors.
     * @param jwtToken Session JWT token
     * @param handles Handles from multiple actors
     * @return List of profiles from multiple actors with a size <= 25
     */
    public Profiles getProfiles(@Nonnull final String jwtToken, @Nonnull final Collection<String> handles) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode jsonArray = mapper.createArrayNode();
        for(String handle : handles) {
            jsonArray.add(handle);
        }
        return client.target(BSKY_URL + GET_PROFILES)
                .queryParam("actors", jsonArray)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + jwtToken)
                .get(Profiles.class);
    }

    /**
     * Get a list of suggested actors. Expected use is discovery of accounts to follow during new account onboarding.
     * @param jwtToken Session JWT token
     * @param limit Possible values: >= 1 and <= 100. Default value is 50
     * @param cursor
     * @return Suggested accounts to follow
     */
    public Suggestions getSuggestions(@Nonnull final String jwtToken, Integer limit, String cursor) {
        return client.target(BSKY_URL+GET_SUGGESTIONS)
                .queryParam("limit", limit)
                .queryParam("cursor", cursor)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + jwtToken)
                .get(Suggestions.class);
    }

    /**
     * Set the private preferences attached to the account.
     * @param jwtToken
     * @param preferences
     * @return HTTP status code
     */
    public int putPreferences(@Nonnull final String jwtToken, @Nonnull final Preferences preferences) {
        try (Response response = client.target(BSKY_URL + PUT_PREFERENCES)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + jwtToken)
                .post(Entity.json(preferences))) {
            return response.getStatus();
        }
    }

    /**
     * Find actor suggestions for a prefix search term. Expected use is for auto-completion during text field entry.
     * Does not require auth.
     * @param queryString Search query prefix; not a full query string.
     * @param limit Number of actors returned by the service. Possible values: >= 1 and <= 100. Default value: 10
     * @return
     */
    public Actors searchActorsTypeahead(@Nonnull final String jwtToken, @Nonnull final String queryString, Integer limit) {
        LOGGER.info("Searching for Actors for typeahead.");
        return client.target(BSKY_URL+SEARCH_ACTORS_TYPE_AHEAD)
                .queryParam("q", queryString)
                .queryParam("limit", limit)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + jwtToken)
                .get(Actors.class);
    }

    /**
     * Find actors (profiles) matching search criteria. Does not require auth.
     * @param queryString Search query prefix; not a full query string.
     * @param limit Number of actors returned by the service. Possible values: >= 1 and <= 100. Default value: 10
     * @return
     */
    public Actors searchActors(@Nonnull final String jwtToken, @Nonnull final String queryString, Integer limit) {
        LOGGER.info("Searching for Actors.");
        return client.target(BSKY_URL+SEARCH_ACTORS)
                .queryParam("q", queryString)
                .queryParam("limit", limit)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, BEARER + jwtToken)
                .get(Actors.class);
    }
}
