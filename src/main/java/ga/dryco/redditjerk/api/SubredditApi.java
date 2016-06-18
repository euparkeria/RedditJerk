package ga.dryco.redditjerk.api;

import ga.dryco.redditjerk.api.enums.FromPast;
import ga.dryco.redditjerk.api.enums.Sorting;
import ga.dryco.redditjerk.wrappers.Comment;
import ga.dryco.redditjerk.wrappers.Link;
import ga.dryco.redditjerk.wrappers.Subreddit;
import ga.dryco.redditjerk.wrappers.User;
import ga.dryco.redditjerk.datamodels.ModeratorsData;

import java.util.List;

/**
 * Subreddit related functions
 */

public interface SubredditApi {

    Subreddit getSubreddit(String subredditname);
    List<Link> getSubredditPage(String subreddit, Integer limit, Sorting sort, FromPast timeperiod);
    List<User> getSubredditModerators(String subreddit);
    List<ModeratorsData> getSubredditModeratorsRaw(String subreddit);
    List<Comment> getSubredditComments(String subreddit, Integer limit);
    void subscribe(String subreddit);
    void unsubscribe(String subreddit);
    List<Subreddit> getInfo_subreddit(List<String> idList);


}
