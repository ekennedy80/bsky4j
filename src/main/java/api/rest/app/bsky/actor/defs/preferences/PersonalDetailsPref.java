package api.rest.app.bsky.actor.defs.preferences;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
public class PersonalDetailsPref extends AbstractPreference {

    @Nullable
    @JsonProperty("birthDate")
    private Date birthDate;

    @JsonSetter("birthDate")
    public void setBirthDate(String date) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        this.birthDate = inputFormat.parse(date);
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

}
