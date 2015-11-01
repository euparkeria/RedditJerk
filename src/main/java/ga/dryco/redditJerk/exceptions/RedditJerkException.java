package ga.dryco.redditJerk.exceptions;

/**
 * Created by mekoneko on 11/1/2015.
 */
public class RedditJerkException extends Exception {

    public RedditJerkException(String message) {
        super(message);
    }

    public RedditJerkException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
