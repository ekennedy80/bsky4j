package api.rest.app.bsky.actor.profile.defs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.rest.JsonFluentObject;
import api.rest.app.bsky.actor.model.Labels;
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

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MutedOrBlockingByList implements JsonFluentObject {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class Viewer {

        @Nullable
        @JsonProperty("muted")
        private Boolean muted;

        @Nullable
        @JsonProperty("blocked")
        private URI blocked;
    }

    @Nonnull
    @JsonProperty("uri")
    private URI uri;

    @Nonnull
    @JsonProperty("cid")
    private String cid;

    @Nonnull
    @JsonProperty("name")
    private String name;

    @Nonnull
    @JsonProperty("purpose")
    private String purpose;

    @Nullable
    @JsonProperty("avatar")
    private URI avatar;

    @Nullable
    @JsonProperty("listItemCount")
    private Integer listItemCount;

    @Nullable
    @JsonProperty("labels")
    private List<Labels> labels;

    @Nullable
    @JsonProperty("viewer")
    private Viewer viewer;

    @Nullable
    @JsonProperty("indexedAt")
    private Date indexedAt;

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

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asJsonObject'");
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asJsonString'");
    }
}
