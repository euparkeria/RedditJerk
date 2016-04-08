package ga.dryco.redditJerk;


import ga.dryco.redditJerk.controllers.*;

import java.net.MalformedURLException;
import java.util.List;
import java.util.StringJoiner;


public interface Reddit {
    User getUser(String username);
    RedditThread getRedditThread(String url) throws MalformedURLException;
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
}
