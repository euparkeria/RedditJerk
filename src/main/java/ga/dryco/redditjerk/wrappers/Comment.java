package ga.dryco.redditjerk.wrappers;

import ga.dryco.redditjerk.api.enums.Distinguish;
import ga.dryco.redditjerk.api.Reddit;
import ga.dryco.redditjerk.implementation.RedditApi;
import ga.dryco.redditjerk.datamodels.T1Data;


public class Comment extends T1Data implements Post {

    private Reddit rApi = RedditApi.getRedditInstance();

    public Comment reply(String text) {
        return rApi.reply(super.getName(), text);
    }

    public void downvote()  {
        rApi.vote(super.getName(), "-1");
    }

    public void upvote()  {
        rApi.vote(super.getName(), "1");
    }

    public void delete() {
        rApi.delete(super.getName());
    }

    public Comment edit(String text)  {
        return (Comment) rApi.edit(super.getName(), text);
    }

    public void hide(){
        rApi.hide(super.getName());
    }

    public void unhide(){
        rApi.unhide(super.getName());
    }

    public void approve(){
        rApi.approve(super.getName());
    }

    public void remove(Boolean spam){
        rApi.remove(super.getName(), spam);
    }

    public void distinguish(Distinguish distinguish){
        rApi.distinguish(super.getName(), distinguish);
    }

}
