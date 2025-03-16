package api.rest.app.bsky.actor.defs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.rest.JsonFluentObject;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Labels implements JsonFluentObject {

    @Nullable
    @JsonProperty("ver")
    private Integer ver;

    @Nonnull
    @JsonProperty("src")
    private String src;

    @Nonnull
    @JsonProperty("uri")
    private URI uri;

    @Nonnull
    @JsonProperty("cid")
    private String cid;

    @Nonnull
    @JsonProperty("val")
    private String val;

    @Nullable
    @JsonProperty("neg")
    private Boolean neg;

    @Nonnull
    @JsonProperty("cts")
    private Date cts;

    @Nullable
    @JsonProperty("exp")
    private Date exp;

    @Nullable
    @JsonProperty("sig")
    private Byte sig;

    @JsonSetter("cts")
    public void setCts(String date) throws ParseException {
        if (date != null) {
            if (date.contains(":") || date.contains("T") || date.contains("Z")) {
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                this.cts = inputFormat.parse(date);
            } else {
                this.cts = new Date(Long.parseLong(date));
            }
        }
    }

    @JsonSetter("exp")
    public void setExp(String date) throws ParseException {
        if (date != null) {
            if (date.contains(":") || date.contains("T") || date.contains("Z")) {
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                this.exp = inputFormat.parse(date);
            } else {
                this.exp = new Date(Long.parseLong(date));
            }
        }
    }

    @Override
    public ObjectNode asJsonObject() throws JsonProcessingException {
        ObjectNode json = new ObjectMapper().createObjectNode();

        return json.put("ver", this.uri.toString())
            .put("src", this.cid)
            .put("uri", uri.toString())
            .put("cid", cid)
            .put("val", val)
            .put("neg", neg)
            .put("cts", cts.toString())
            .put("exp", exp.toString())
            .put("sig", sig);
    }

    @Override
    public String asJsonString() throws JsonProcessingException {
        return asJsonObject().toPrettyString();
    }
}
