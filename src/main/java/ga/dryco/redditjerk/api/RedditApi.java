package ga.dryco.redditjerk.api;


import ga.dryco.redditjerk.wrappers.*;

import java.util.List;


public interface RedditApi extends FlairApi, ModerationApi, PostApi, SubredditApi, UserApi {

    List<Subreddit> getInfo_subreddit(List<String> idList);
    List<Link> getInfo_link(List<String> idList);
    List<Comment> getInfo_comment(List<String> idList);









}
