package ga.dryco.redditJerk;


import ga.dryco.redditJerk.controllers.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by mekoneko on 7/4/2015.
 */
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
}
