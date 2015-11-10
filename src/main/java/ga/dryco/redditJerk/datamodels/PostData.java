package ga.dryco.redditJerk.datamodels;

import com.google.gson.annotations.Expose;

/**
 * parent class for t1Data and t3Data
 */
public class PostData {

    @Expose
    private String subreddit;

    @Expose
    private Integer score;

    @Expose
    private String author;


    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
