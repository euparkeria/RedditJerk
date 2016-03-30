package ga.dryco.redditJerk.controllers;

import ga.dryco.redditJerk.Reddit;
import ga.dryco.redditJerk.RedditApi;
import ga.dryco.redditJerk.datamodels.T3Data;

public class Link extends T3Data implements Post{

    private Reddit rApi = RedditApi.getRedditInstance();

    public void downvote()  {
        rApi.vote(super.getName(), "-1");
    }

    public void upvote()  {
        rApi.vote(super.getName(), "1");
    }

    public Comment reply(String text)  {
        return rApi.reply(super.getName(), text);
    }

    public void delete() {
        rApi.delete(super.getName());
    }

    public Link edit(String text)  {
        return (Link) rApi.edit(super.getName(), text);
    }

    public void hide(){
        rApi.hide(super.getName());
    }

}
