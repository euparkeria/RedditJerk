package ga.dryco.redditJerk;


public enum ConfigValues {
    API_URL("http://api.reddit.com/"),
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