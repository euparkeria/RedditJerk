package ga.dryco.redditJerk;


import ga.dryco.redditJerk.controllers.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by mekoneko on 7/4/2015.
 */
public interface Reddit {
    User getUser(String username) throws IOException;
    RedditThread getThread(String url) throws IOException;
    Subreddit getSubreddit(String subredditname) throws IOException;
    Overview getOverview(String username, Integer limit, String sort) throws IOException;
    List<Link> getUserSubmissions(String username, Integer limit, String sort) throws IOException;
    List<Comment> getUserComments(String username, Integer limit, String sort) throws IOException;
    List<Link> getSubredditPage(String subreddit, Integer limit, String sort) throws IOException;
    User login(String username, String password, String clientId, String secret) throws IOException;
    void vote(String fullnameId, String dir) throws IOException;
    Comment reply(String fullnameId, String text) throws IOException;
    void delete(String fullnameId) throws IOException;
    Post edit(String fullnameId, String text) throws IOException;
    void hide(String fullnameId) throws IOException;
    void unhide(String fullnameId) throws IOException;
    List<User> getSubredditModerators(String subreddit) throws IOException;
}
