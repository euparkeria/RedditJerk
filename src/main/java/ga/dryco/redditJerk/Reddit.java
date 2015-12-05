package ga.dryco.redditJerk;


import ga.dryco.redditJerk.controllers.*;

import java.net.MalformedURLException;
import java.util.List;


public interface Reddit {
    User getUser(String username);
    RedditThread getRedditThread(String url) throws MalformedURLException;
    Subreddit getSubreddit(String subredditname);
    Overview getOverview(String username, Integer limit, String sort);
    List<Link> getUserSubmissions(String username, Integer limit, String sort);
    List<Comment> getUserComments(String username, Integer limit, String sort);
    List<Link> getSubredditPage(String subreddit, Integer limit, String sort);
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
}
