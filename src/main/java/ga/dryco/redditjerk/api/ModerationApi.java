package ga.dryco.redditjerk.api;

import ga.dryco.redditjerk.api.enums.Distinguish;
import ga.dryco.redditjerk.api.enums.Moderation;
import ga.dryco.redditjerk.wrappers.Comment;
import ga.dryco.redditjerk.wrappers.Link;

import java.util.List;

/**
 * Moderation functions
 */
public interface ModerationApi {

    void acceptModInvite(String subreddit);
    void leaveModeration(String subreddit);
    void ignoreReports(String thingFullId);
    List<Comment> getModerationReportsComments(String subreddit, Moderation modreport, Integer limit);
    List<Link> getModerationReportsSubmissions(String subreddit, Moderation modreport, Integer limit);
    void approve(String fullnameId);
    void remove(String fullnameId, Boolean spam);
    void distinguish(String fullnameId, Distinguish distinguish);
    void leaveContributor(String subreddit);
    void unignoreReports(String thingFullId);
    void markNsfw(String fullnameId);
    void unmarkNsfw(String fullnameId);
    void lock(String fullnameId);
    void unlock(String fullnameId);

}
