package ga.dryco.redditjerk.rest;

import java.io.Serializable;


public class AuthInfo implements Serializable{

    private String username;
    private String password;
    private String clientId;
    private String secret;
    private long timeAquired;

    public AuthInfo(String username, String password, String clientId, String secret){
        this.username = username;
        this.password = password;
        this.clientId = clientId;
        this.secret = secret;
    }

    public long getTimeAquired() {
        return timeAquired;
    }

    public void setTimeAquired(long timeAquired) {
        this.timeAquired = timeAquired;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getClientId() {
        return clientId;
    }

    public String getSecret() {
        return secret;
    }

}
