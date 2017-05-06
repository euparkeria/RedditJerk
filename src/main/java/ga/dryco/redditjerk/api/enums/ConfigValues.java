package ga.dryco.redditjerk.api.enums;


/**
 * Contains reddit api URIs for oauth and normal use
 */

public enum ConfigValues {
    API_URL("https://api.reddit.com/"),
    OAUTH_URL("https://oauth.reddit.com/");
    private String url;

    ConfigValues(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return url;
    }
}