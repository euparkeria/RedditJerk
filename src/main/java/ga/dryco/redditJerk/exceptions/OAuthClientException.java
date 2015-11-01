package ga.dryco.redditJerk.exceptions;

/**
 * Created by mekoneko on 11/1/2015.
 */
public class OAuthClientException  extends RuntimeException {
    public OAuthClientException(){
        super();
    }

    public OAuthClientException(String message) {
        super(message);
    }

    public OAuthClientException(String message, Throwable cause) {
        super(message, cause);
    }


}
