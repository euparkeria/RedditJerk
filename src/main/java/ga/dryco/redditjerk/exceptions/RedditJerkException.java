package ga.dryco.redditjerk.exceptions;


/**
 * General RedditJerk Exception
 *
 */
public class RedditJerkException  extends RuntimeException {
    public RedditJerkException(){
        super();
    }

    public RedditJerkException(String message) {
        super(message);
    }

    public RedditJerkException(String message, Throwable cause) {
        super(message, cause);
    }


}
