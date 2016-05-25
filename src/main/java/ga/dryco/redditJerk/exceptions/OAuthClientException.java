package ga.dryco.redditjerk.exceptions;


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
