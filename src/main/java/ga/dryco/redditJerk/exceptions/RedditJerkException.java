package ga.dryco.redditjerk.exceptions;


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
