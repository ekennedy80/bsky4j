package api.rest.app.bsky.actor.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
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
public class Labels {

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
}
