package ga.dryco.redditJerk;

/**
 * Created by mekoneko on 8/22/2015.
 */
public enum Endpoints {
    USER("user/%s/about/"),
    ME("api/v1/me"),
    OVERVIEW("user/%s/?limit=%d&sort=%s"),
    SUBREDDIT( "r/%s/about"),
    USER_COMMENTS("user/%s/comments/?limit=%d&sort=%s"),
    USER_SUBS("user/%s/submitted/?limit=%d&sort=%s"),
    SUBREDDIT_PAGE("/r/%s/%s/?limit=%d"),
    VOTE("/api/vote"),
    SUBMIT("/api/submit"),
    DELETE( "/api/del"),
    HIDE("/api/hide"),
    UNHIDE("/api/unhide"),
    REPLY("/api/comment"),
    EDIT("/api/editusertext");

    private String url;

    private Endpoints(String url) {
        this.url = url;
    }

    @Override
    public String toString(){
        return this.url;
    }

}

