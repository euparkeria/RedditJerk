package ga.dryco.redditjerk.wrappers;

import ga.dryco.redditjerk.api.enums.FromPast;
import ga.dryco.redditjerk.api.Reddit;
import ga.dryco.redditjerk.implementation.RedditApi;
import ga.dryco.redditjerk.api.enums.Sorting;
import ga.dryco.redditjerk.datamodels.T5Data;

import java.util.List;


public class Subreddit extends T5Data implements Thingy{

    private Reddit rApi = RedditApi.getRedditInstance();

    public List<Link> getHot(Integer limit)  {
       return rApi.getSubredditPage(super.getDisplayName(), limit, Sorting.HOT, FromPast.DAY);
    }

    public List<Link> getHot(Integer limit, FromPast timespan)  {
        return rApi.getSubredditPage(super.getDisplayName(), limit, Sorting.HOT, timespan);
    }

    public List<Link> getNew(Integer limit)  {
        return rApi.getSubredditPage(super.getDisplayName(), limit, Sorting.NEW, FromPast.DAY);
    }

    public List<Link> getNew(Integer limit, FromPast timespan)  {
        return rApi.getSubredditPage(super.getDisplayName(), limit, Sorting.NEW, timespan);
    }

    public List<Link> getTop(Integer limit)  {
        return rApi.getSubredditPage(super.getDisplayName(), limit, Sorting.TOP, FromPast.DAY);

    }

    public List<Link> getTop(Integer limit, FromPast timespan)  {
        return rApi.getSubredditPage(super.getDisplayName(), limit, Sorting.TOP, timespan);

    }

    public List<Link> getControversial(Integer limit){
        return rApi.getSubredditPage(super.getDisplayName(), limit, Sorting.CONTROVERSIAL, FromPast.DAY);
    }

    public List<Link> getControversial(Integer limit, FromPast timespan){
        return rApi.getSubredditPage(super.getDisplayName(), limit, Sorting.CONTROVERSIAL, timespan);
    }

    public List<Link> getRising(Integer limit){
        return rApi.getSubredditPage(super.getDisplayName(), limit, Sorting.RISING, FromPast.DAY);
    }

    public List<Comment> getComments(Integer limit){
        return rApi.getSubredditComments(super.getDisplayName(), limit);
    }

    public void subscribe(){
        rApi.subscribe(super.getDisplayName());
    }

    public void unsubscribe(){
        rApi.unsubscribe(super.getDisplayName());
    }


}
