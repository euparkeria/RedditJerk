package ga.dryco.redditJerk.controllers;

import ga.dryco.redditJerk.Reddit;
import ga.dryco.redditJerk.RedditApi;
import ga.dryco.redditJerk.datamodels.T5Data;
import java.util.List;


public class Subreddit extends T5Data implements Thingy{

    Reddit rApi = RedditApi.getRedditInstance();

    public List<Link> getHot(Integer limit)  {
       return rApi.getSubredditPage(super.getDisplayName(), limit, "hot", "day");
    }

    public List<Link> getNew(Integer limit)  {
        return rApi.getSubredditPage(super.getDisplayName(), limit, "new", "day");
    }

    public List<Link> getTop(Integer limit)  {
        return rApi.getSubredditPage(super.getDisplayName(), limit, "top", "day");
    }

    public List<Comment> getComments(Integer limit){
        return rApi.getSubredditComments(super.getDisplayName(), limit);
    }


}
