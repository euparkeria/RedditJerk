package ga.dryco.redditjerk.api;

import ga.dryco.redditjerk.api.enums.Sorting;
import ga.dryco.redditjerk.wrappers.Comment;
import ga.dryco.redditjerk.wrappers.Link;
import ga.dryco.redditjerk.wrappers.Post;
import ga.dryco.redditjerk.wrappers.RedditThread;
import ga.dryco.redditjerk.datamodels.MoreChildren;

import java.net.MalformedURLException;
import java.util.List;

/**
 * Comment and Link related functions
 */

public interface PostApi {
    RedditThread getRedditThread(String url, Sorting sort) throws MalformedURLException;
    void vote(String fullnameId, String dir);
    Comment reply(String fullnameId, String text);
    void delete(String fullnameId);
    Post edit(String fullnameId, String text);
    void hide(String fullnameId);
    void unhide(String fullnameId);
    MoreChildren getMoreChildren(List<String> idList, String linkId, Sorting sort);
    Link Submit(String subreddit, String title, String bodyOrUrl, String kind);
    List<Link> getInfo_link(List<String> idList);
    List<Comment> getInfo_comment(List<String> idList);
}
