package ga.dryco.redditjerk;


import ga.dryco.redditjerk.controllers.*;
import ga.dryco.redditjerk.datamodels.MoreChildren;

import java.net.MalformedURLException;
import java.util.List;


public interface Reddit {
    User getUser(String username);
    RedditThread getRedditThread(String url, Sorting sort) throws MalformedURLException;
    Subreddit getSubreddit(String subredditname);
    Overview getOverview(String username, Integer limit, Sorting sort);
    List<Link> getUserSubmissions(String username, Integer limit, Sorting sort);
    List<Comment> getUserComments(String username, Integer limit, Sorting sort);
    List<Link> getSubredditPage(String subreddit, Integer limit, Sorting sort, FromPast timeperiod);
    User login(String username, String password, String clientId, String secret);
    void vote(String fullnameId, String dir);
    Comment reply(String fullnameId, String text);
    void delete(String fullnameId);
    Post edit(String fullnameId, String text);
    void hide(String fullnameId);
    void unhide(String fullnameId);
    List<User> getSubredditModerators(String subreddit);
    List<Comment> getSubredditComments(String subreddit, Integer limit);
    List<Subreddit> getInfo_subreddit(List<String> idList);
    List<Link> getInfo_link(List<String> idList);
    List<Comment> getInfo_comment(List<String> idList);
    Link Submit(String subreddit, String title, String bodyOrUrl, String kind);
    List<Link> getUserHidden(String username, Integer limit);
    List<Link> getUserDownvoted(String username, Integer limit);
    List<Link> getUserUpvoted(String username, Integer limit);
    List<Comment> getUserGilded(String username, Integer limit);
    void subscribe(String subreddit);
    void unsubscribe(String subreddit);

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
    void deleteFlair(String subreddit, String username);
    void clearFlairTemplates(String subreddit, String flairtype);
    void deleteFlairTemplate(String subreddit, String flairTemplateId);
    void linkFlair(String subreddit, String link_fullName, String text, String css_class);
    void userFlair(String subreddit, String name, String text, String css_class);
    void flairConfig(String flair_enabled, FlairPosition flair_position, Boolean flair_self_assign_enabled, FlairPosition link_flair_position, Boolean link_flair_self_assign_enabled);
    MoreChildren getMoreChildren(List<String> idList, String linkId, Sorting sort);
    void markNsfw(String fullnameId);
    void unmarkNsfw(String fullnameId);
    void lock(String fullnameId);
    void unlock(String fullnameId);

}
