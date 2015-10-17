package ga.dryco.redditJerk;


public enum ConfigValues {
    API_URL("http://api.reddit.com/"),
    OAUTH_URL("https://oauth.reddit.com/");
    private String value;

    private ConfigValues(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}