package ga.dryco.redditJerk.controllers;

import ga.dryco.redditJerk.Reddit;
import ga.dryco.redditJerk.RedditApi;
import ga.dryco.redditJerk.datamodels.T5Data;

import java.io.IOException;
import java.util.List;

/**
 * Created by mekoneko on 7/17/2015.
 */
public class Subreddit extends T5Data {

    Reddit rApi = RedditApi.getRedditInstance();

    public List<Link> getHot(Integer limit)  {
       return rApi.getSubredditPage(super.getDisplayName(), limit, "hot");
    }

    public List<Link> getNew(Integer limit)  {
        return rApi.getSubredditPage(super.getDisplayName(), limit, "new");
    }

    public List<Link> getTop(Integer limit)  {
        return rApi.getSubredditPage(super.getDisplayName(), limit, "top");
    }


}
