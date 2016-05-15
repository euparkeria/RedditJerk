package ga.dryco.redditJerk;

enum Endpoints {
    USER("user/%s/about/"),
    ME("api/v1/me"),
    OVERVIEW("user/%s/?limit=%d&sort=%s"),
    SUBREDDIT( "r/%s/about"),
    USER_COMMENTS("user/%s/comments/?limit=%d&sort=%s"),
    USER_SUBS("user/%s/submitted/?limit=%d&sort=%s"),
    USER_GILDED("user/%s/gilded/?limit=%d"),
    USER_UPVOTED("user/%s/upvoted/?limit=%d"),
    USER_DOWNVOTED("user/%s/downvoted/?limit=%d"),
    USER_HIDDEN("user/%s/hidden/?limit=%d"),
    USER_SAVED("user/%s/saved/?limit=%d"),
    SUBREDDIT_PAGE("/r/%s/%s/?limit=%d&t=%s"),
    SUBREDDIT_COMMENTS("/r/%s/comments/?limit=%d"),
    VOTE("/api/vote"),
    SUBMIT("/api/submit"),
    DELETE( "/api/del"),
    HIDE("/api/hide"),
    UNHIDE("/api/unhide"),
    REPLY("/api/comment"),
    EDIT("/api/editusertext"),
    SUB_MODERATORS("/r/%s/about/moderators/"),
    INFO("/api/info/?id=%s"),
    SUBSCRIBE("/api/subscribe"),
    ACCEPT_MOD_INVITE("/r/%s/api/accept_moderator_invite"),
    LEAVE_MODERATOR("/api/leavemoderator"),
    LEAVE_CONTRIBUTOR("/api/leavecontributor"),
    IGNORE_REPORTS("/api/ignore_reports"),
    UNIGNORE_REPORTS("/api/unignore_reports"),
    MODERATION_COMMENTS("/r/%s/about/%s/?only=comments&limit=%d"),
    MODERATION_SUBMISSIONS("/r/%s/about/%s/?only=comments&limit=%d"),
    APPROVE("/api/approve"),
    REMOVE("/api/remove"),
    DISTINGUISH("/api/distinguish");




    private String url;

    Endpoints(String url) {
        this.url = url;
    }

    @Override
    public String toString(){
        return this.url;
    }

}

