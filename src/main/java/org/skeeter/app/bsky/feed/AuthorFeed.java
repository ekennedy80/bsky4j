package org.skeeter.app.bsky.feed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AuthorFeed {

    public enum FilterType {
        POSTS_WITH_REPLIES("posts_with_replies"),
        POSTS_NO_REPLIES("posts_no_replies"),
        POSTS_WITH_MEDIA("posts_with_media"),
        POSTS_AND_AUTHOR_THREADS("posts_and_author_threads");

        private final String value;

        FilterType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

    private final String actor;
    private Integer limit;
    private String cursor;
    private FilterType filter;
    private Boolean includePins;

    public AuthorFeed(String actor) {
        this.actor = actor;
        //if null, bsky api defaults to 50
        this.filter = FilterType.POSTS_WITH_REPLIES;
    }
}
