package ga.dryco.redditJerk.controllers;

import ga.dryco.redditJerk.FromPast;
import ga.dryco.redditJerk.Reddit;
import ga.dryco.redditJerk.RedditApi;
import ga.dryco.redditJerk.Sorting;
import ga.dryco.redditJerk.datamodels.T5Data;
import java.util.List;


public class Subreddit extends T5Data implements Thingy{

    private Reddit rApi = RedditApi.getRedditInstance();

    public List<Link> getHot(Integer limit)  {
       return rApi.getSubredditPage(super.getDisplayName(), limit, Sorting.HOT, FromPast.DAY);
    }

    public List<Link> getNew(Integer limit)  {
        return rApi.getSubredditPage(super.getDisplayName(), limit, Sorting.NEW, FromPast.DAY);
    }

    public List<Link> getTop(Integer limit)  {
        return rApi.getSubredditPage(super.getDisplayName(), limit, Sorting.TOP, FromPast.DAY);

    }

    public List<Link> getControversial(Integer limit){
        return rApi.getSubredditPage(super.getDisplayName(), limit, Sorting.CONTROVERSIAL, FromPast.DAY);
    }

    public List<Link> getRising(Integer limit){
        return rApi.getSubredditPage(super.getDisplayName(), limit, Sorting.RISING, FromPast.DAY);
    }

    public List<Comment> getComments(Integer limit){
        return rApi.getSubredditComments(super.getDisplayName(), limit);
    }


}
