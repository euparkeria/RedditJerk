package ga.dryco.redditJerk.controllers;

import ga.dryco.redditJerk.Reddit;
import ga.dryco.redditJerk.RedditApi;
import ga.dryco.redditJerk.datamodels.T1Data;


import java.io.IOException;

/**
 * Created by mekoneko on 7/17/2015.
 */
public class Comment extends T1Data implements Post {

    Reddit rApi = RedditApi.getRedditInstance();

    public Comment reply(String text) throws IOException{
        return rApi.reply(super.getName(), text);
    }

    public void downvote() throws IOException {
        rApi.vote(super.getName(), "-1");
    }

    public void upwnvote() throws IOException {
        rApi.vote(super.getName(), "1");
    }

    public void delete() throws IOException{
        rApi.delete(super.getName());
    }

    public Comment edit(String text) throws IOException {
        return (Comment) rApi.edit(super.getName(), text);
    }

}
