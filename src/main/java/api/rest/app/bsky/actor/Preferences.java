package api.rest.app.bsky.actor;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Get private preferences attached to the current account. Expected use is synchronization between multiple devices,
 * and import/export during account migration. Requires auth.
 */
@Data
@AllArgsConstructor
@Builder
public class Preferences {

    public enum Visibility {
        IGNORE("ignore"),
        SHOW("show"),
        WARN("warn"),
        HIDE("hide");

        private final String value;

        Visibility(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }


}
