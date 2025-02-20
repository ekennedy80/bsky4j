package api.rest.app.bsky.actor.profile;


import api.rest.app.bsky.actor.object.Associated;
import api.rest.app.bsky.actor.profile.defs.JoinedViaStarterPackDef;
import api.rest.app.bsky.actor.object.Labels;
import api.rest.app.bsky.actor.object.Viewer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Profile view of an actor.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Profile {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class PinnedPost {

        @Nonnull
        @JsonProperty("uri")
        private URI uri;

        @Nonnull
        @JsonProperty("cid")
        private String cid;
    }

    @Nonnull
    @JsonProperty("did")
    private String did;

    @Nonnull
    @JsonProperty("handle")
    private String handle;

    @Nullable
    @JsonProperty("displayName")
    private String displayName;

    @Nullable
    @JsonProperty("description")
    private String description;

    @Nullable
    @JsonProperty("avatar")
    private URI avatar;

    @Nullable
    @JsonProperty("banner")
    private URI banner;

    @Nullable
    @JsonProperty("followersCount")
    private Integer followersCount;

    @Nullable
    @JsonProperty("followsCount")
    private Integer followsCount;

    @Nullable
    @JsonProperty("postsCount")
    private Integer postsCount;

    @Nullable
    @JsonProperty("associated")
    private Associated associated;

    @Nullable
    @JsonProperty("joinedViaStarterPack")
    private JoinedViaStarterPackDef joinedViaStarterPack;

    @Nullable
    @JsonProperty("indexedAt")
    private Date indexedAt;

    @Nullable
    @JsonProperty("createdAt")
    private Date createdAt;

    @Nullable
    @JsonProperty("viewer")
    private Viewer viewer;

    @Nullable
    @JsonProperty("labels")
    private List<Labels> labels;

    @Nullable
    @JsonProperty("pinnedPost")
    private PinnedPost pinnedPost;

    @JsonSetter("indexedAt")
    public void setIndexedAt(String date) throws ParseException {
        if (date != null) {
            if (date.contains(":") || date.contains("T") || date.contains("Z")) {
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                this.indexedAt = inputFormat.parse(date);
            } else {
                this.indexedAt = new Date(Long.parseLong(date));
            }
        }
    }

    @JsonSetter("createdAt")
    public void setCreatedAt(String date) throws ParseException {
        if (date != null) {
            if (date.contains(":") || date.contains("T") || date.contains("Z")) {
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                this.createdAt = inputFormat.parse(date);
            } else {
                this.createdAt = new Date(Long.parseLong(date));
            }
        }
    }

    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode json = new ObjectMapper().createObjectNode();
        return json.put("profile", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this));
    }

    public String asJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }

}
