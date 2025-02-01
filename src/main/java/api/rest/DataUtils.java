package api.rest;

import java.net.URI;

public class DataUtils {

    public static class NotBskyRecordUriException extends Exception {
        public NotBskyRecordUriException(String message) {
            super(message);
        }
    }

    private DataUtils(){    }

    public static String[] parseRecordUri(URI uri) throws NotBskyRecordUriException {
        if(!uri.toString().startsWith("at://")) {
            throw new NotBskyRecordUriException("The URI does not begin with at://");
        }
        String[] fields = new String[3];
        String[] splitString = uri.toString().split("/");
        fields[0] = splitString[2];
        fields[1] = splitString[3];
        fields[2] = splitString[4];
        return fields;
    }
}
