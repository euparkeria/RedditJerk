package ga.dryco.redditjerk.rest;

import com.google.gson.Gson;
import ga.dryco.redditjerk.datamodels.AuthData;
import ga.dryco.redditjerk.exceptions.OAuthClientException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public final class OAuthClient {
    private String userAgent;
    private HttpClient postClient;
    private AuthInfo authInfo;



    private AuthData authData;


    public AuthInfo getAuthInfo() {
        return authInfo;
    }

    public void setAuthData(AuthData authData) {
        this.authData = authData;
    }

    public OAuthClient(String useragent){
        this.userAgent = useragent;
    }

    private void renewAccessToken() {
        //if current time is bigger or equal to token's time of aquiering + expire value - 3 minutes
        if(authData != null){
            if(Instant.now().getEpochSecond() >= (authInfo.getTimeAquired() + authData.getExpiresIn() - 180)){

                // requesting new token with token header set will result in 401 error
                this.authData = null;
                this.OAuthAuthenitcation();
            }
        }

    }

    public AuthInfo Authenticate(String username, String password, String clientId, String secret){
        if(this.authInfo == null){
            this.authInfo = new AuthInfo(username, password, clientId, secret);
            this.OAuthAuthenitcation();
        } else this.renewAccessToken();

        return this.authInfo;

    }

    private void OAuthAuthenitcation() {
        if(this.authInfo == null){
            throw new OAuthClientException("No Authentication info present");
        }

        this.authData = getAccessTokenJson();
        this.authInfo.setTimeAquired(Instant.now().getEpochSecond());
    }





    private AuthData getAccessTokenJson() {
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(authInfo.getClientId(), authInfo.getSecret());
        provider.setCredentials(AuthScope.ANY, credentials);
        this.postClient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).setUserAgent(this.userAgent).build();
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("grant_type", "password"));
        urlParameters.add(new BasicNameValuePair("username", authInfo.getUsername()));
        urlParameters.add(new BasicNameValuePair("password", authInfo.getPassword()));

        Gson gson = new Gson();

        HttpPost post = new HttpPost("https://www.reddit.com/api/v1/access_token");

        try {
            post.setEntity(new UrlEncodedFormEntity(urlParameters));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        HttpResponse response;
        try {
            response = this.postClient.execute(post);
        } catch (IOException e) {
            throw new OAuthClientException("Oath getAccessToken Error" , e);
        }

        return gson.fromJson(this.responseReader(response), AuthData.class);

    }


    public String get(String url) throws IllegalArgumentException {
        renewAccessToken();
        HttpClient getClient = HttpClientBuilder.create().setUserAgent(this.userAgent).build();
        HttpGet request = new HttpGet(url);

        if(this.authData != null){
            request.addHeader("Authorization","bearer " + this.authData.getAccessToken());
        }
        HttpResponse response;
        try {
            response = getClient.execute(request);
        } catch (IOException e) {
            throw new OAuthClientException("Oauth Get error", e);
        }

        return this.responseReader(response);

    }


    public String post(String url, List<NameValuePair> urlParameters) {
        renewAccessToken();

        HttpPost post = new HttpPost(url);

        if(this.authData != null){
            post.addHeader("Authorization","bearer " + this.authData.getAccessToken());
        }

        try {
            post.setEntity(new UrlEncodedFormEntity(urlParameters));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        HttpResponse response;
        try {
            response = this.postClient.execute(post);
        } catch (IOException e) {
            throw new OAuthClientException("Oath Post IO Error" , e);
        }


        return this.responseReader(response);

    }

    private String responseReader(HttpResponse response) {
        String line;

        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(sb.toString());
        return sb.toString();
    }


}
