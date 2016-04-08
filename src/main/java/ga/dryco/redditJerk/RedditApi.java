package ga.dryco.redditJerk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import ga.dryco.redditJerk.controllers.*;
import ga.dryco.redditJerk.datamodels.*;
import ga.dryco.redditJerk.datamodels.Deserializers.*;
import ga.dryco.redditJerk.exceptions.RedditJerkException;
import ga.dryco.redditJerk.rest.OAuthClient;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Default api implementation.
 */
public final class RedditApi implements Reddit  {
    private final OAuthClient client;


    private String ApiURL = ConfigValues.API_URL.toString();
    private final Gson gson;

    private RedditApi(String useragent){
        this.client = new OAuthClient(useragent);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(T1.class, new T1Deserializer());
        gsonBuilder.registerTypeAdapter(T3.class, new T3Deserializer());
        gsonBuilder.registerTypeAdapter(RedditThread.class, new ThreadDeserializer());
        gsonBuilder.registerTypeAdapter(OverviewData.class, new OverviewDeserializer());
        gsonBuilder.registerTypeAdapter(PostReturn.class, new PostReturnDeserializer());
        gsonBuilder.registerTypeAdapter(T1Listing.class, new T1ListingDeserializer());
        this.gson = gsonBuilder.create();

    }

    private static Reddit ApiINSTANCE;

    public static Reddit getRedditInstance(String userAgent){
        if(ApiINSTANCE == null)
            ApiINSTANCE = new RedditApi(userAgent);
        return ApiINSTANCE;
    }

    public static Reddit getRedditInstance(){
        return ApiINSTANCE;
    }


    /**
     *
     * @param username reddit username
     * @param password reddit password
     * @param clientId oAuth app id
     * @param secret oAuth Secret
     */
    public User login(String username, String password, String clientId, String secret) {
        this.ApiURL = ConfigValues.OAUTH_URL.toString();
        client.Authenticate(username, password, clientId, secret);

        return this.me();
    }

    /**
     *
     * @param username user to get
     * @return User
     *
     */

    public User getUser(String username) {
        String requesturl = String.format(ApiURL + Endpoints.USER, username);

        T2 t2 = this.getDataObject(makeHttpRequest(requesturl), T2.class);
        return t2.getData();
    }


    private User me() {
        String requesturl = ApiURL + Endpoints.ME;
        return this.getDataObject(makeHttpRequest(requesturl), User.class);

    }

    public RedditThread getRedditThread(String url) throws MalformedURLException {
        URL purl = new URL(url);
        url = purl.getPath();

        String requesturl = ApiURL + url;

        return this.getDataObject(makeHttpRequest(requesturl), RedditThread.class);
    }

    public Overview getOverview(String username, Integer limit, Sorting sort)  {
        String requesturl = String.format(ApiURL + Endpoints.OVERVIEW, username, limit, sort);

        return this.getDataObject(makeHttpRequest(requesturl), Overview.class);
    }

    public Subreddit getSubreddit(String subreddit)  {
        String requesturl = String.format(ApiURL + Endpoints.SUBREDDIT, subreddit);

        return this.getDataObject(makeHttpRequest(requesturl), T5.class).getData();
    }


    public final List<Comment> getUserComments(String username, Integer limit, Sorting sort) {
        String requesturl = String.format(ApiURL + Endpoints.USER_COMMENTS, username, limit, sort);

        return this.getListings(requesturl, limit, T1Listing.class).stream().map(comm -> (Comment) comm).collect(Collectors.toList());
    }

    public final List<Comment> getUserGilded(String username, Integer limit){
        String requesturl = String.format(ApiURL + Endpoints.USER_GILDED, username, limit);

        return this.getListings(requesturl, limit, T1Listing.class).stream().map(comm -> (Comment) comm).collect(Collectors.toList());

    }

    public final List<Link> getUserUpvoted(String username, Integer limit){
        String requesturl = String.format(ApiURL + Endpoints.USER_UPVOTED, username, limit);

        return this.getListings(requesturl, limit, T3Listing.class).stream().map(lnk -> (Link) lnk).collect(Collectors.toList());

    }

    public final List<Link> getUserDownvoted(String username, Integer limit){
        String requesturl = String.format(ApiURL + Endpoints.USER_DOWNVOTED, username, limit);

        return this.getListings(requesturl, limit, T3Listing.class).stream().map(lnk -> (Link) lnk).collect(Collectors.toList());

    }

    public final List<Link> getUserHidden(String username, Integer limit){
        String requesturl = String.format(ApiURL + Endpoints.USER_HIDDEN, username, limit);

        return this.getListings(requesturl, limit, T3Listing.class).stream().map(lnk -> (Link) lnk).collect(Collectors.toList());

    }

    public final List<Link> getUserSubmissions(String username, Integer limit, Sorting sort)  {
        String requesturl = String.format(ApiURL + Endpoints.USER_SUBS, username, limit, sort);

        return this.getListings(requesturl, limit, T3Listing.class).stream().map(lnk -> (Link) lnk).collect(Collectors.toList());
    }

    public List<Link> getSubredditPage(String subreddit, Integer limit, Sorting sort, FromPast timeperiod)  {
        String requesturl = String.format(ApiURL + Endpoints.SUBREDDIT_PAGE, subreddit, sort, limit, timeperiod );

        return this.getListings(requesturl, limit, T3Listing.class).stream().map(lnk -> (Link) lnk).collect(Collectors.toList());
    }

    public List<Comment> getSubredditComments(String subreddit, Integer limit){
        String requesturl = String.format(ApiURL + Endpoints.SUBREDDIT_COMMENTS, subreddit, limit);

        return this.getListings(requesturl, limit, T1Listing.class).stream().map(cmt -> (Comment) cmt).collect(Collectors.toList());

    }

    // list can be of comments, links, or subreddit objects
    public List<Subreddit> getInfo_subreddit(List<String> idList){
        return this.getInfo(idList, T5Listing.class).stream().map(t -> (Subreddit) t).collect(Collectors.toList());
    }

    public List<Link> getInfo_link(List<String> idList){
        return this.getInfo(idList, T3Listing.class).stream().map(t -> (Link) t).collect(Collectors.toList());
    }

    public List<Comment> getInfo_comment(List<String> idList){
        return this.getInfo(idList, T1Listing.class).stream().map(t -> (Comment) t).collect(Collectors.toList());
    }


    private <T extends Thing<? extends ListingData>> List<Thingy> getInfo(List<String> idList, Class<T> typeC){
        final int MAX_INFO_LIST = 100;
        if(idList.size() > MAX_INFO_LIST) throw new RedditJerkException("/api/info thing list larger than 100");
        String ids = String.join(",", idList);

        String requesturl = String.format(ApiURL + Endpoints.INFO, ids);

        return this.getListings(requesturl, MAX_INFO_LIST, typeC).stream().collect(Collectors.toList());

    }

    public List<User> getSubredditModerators(String subreddit) {

        List<User> returnUserList = new ArrayList<>();

        List<ModeratorsData> modListing = this.getSubredditModeratorsRaw(subreddit);

        returnUserList.addAll(modListing.stream().map(modD -> this.getUser(modD.getName())).collect(Collectors.toList()));

        return  returnUserList;

    }

    /**
     * This returns the raw ModeratorsData objects which avoids all the extra getUser() API calls, useful if you
     * dont need actual User objects.
     *
     * @param subreddit subreddit name
     * @return returns a list with ModeratorsData
     */
    private List<ModeratorsData> getSubredditModeratorsRaw(String subreddit){
        String requesturl = String.format(ApiURL + Endpoints.SUB_MODERATORS, subreddit);


        return this.getDataObject(makeHttpRequest(requesturl), ModeratorsListing.class).getData().getChildren();

    }

    /**
     *
     * @param fullnameId Thing Id
     * @param dir "1" for upvote, "-1" for downvote
     *
     */
    public void vote(String fullnameId, String dir)  {
        String requesturl = ApiURL + Endpoints.VOTE;
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("id", fullnameId));
        urlParameters.add(new BasicNameValuePair("dir", dir));
        this.makeHttpRequest(requesturl, urlParameters);
    }


    public final Link Submit(String subreddit, String title, String bodyOrUrl, String kind)  {
        String requesturl = ApiURL + Endpoints.SUBMIT;

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("api_type", "json"));
        urlParameters.add(new BasicNameValuePair("kind", kind));
        urlParameters.add(new BasicNameValuePair("resubmit", "true"));
        urlParameters.add(new BasicNameValuePair("sr", subreddit));
        urlParameters.add(new BasicNameValuePair("title", title));
        if(kind.equals("link")) urlParameters.add(new BasicNameValuePair("url", bodyOrUrl));
        if(kind.equals("self")) urlParameters.add(new BasicNameValuePair("text", bodyOrUrl));

        PostReturn pstr = this.getDataObject(this.makeHttpRequest(requesturl, urlParameters), PostReturn.class);
        return pstr.getLink().getData();


    }

    public final void delete(String fullnameId) {
        String requesturl = ApiURL + Endpoints.DELETE;

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("api_type", "json"));
        urlParameters.add(new BasicNameValuePair("id", fullnameId));

        this.makeHttpRequest(requesturl, urlParameters);

    }

    public final void subscribe(String subreddit){
        String requesturl = ApiURL + Endpoints.SUBSCRIBE;

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("action", "sub"));
        urlParameters.add(new BasicNameValuePair("sr_name", subreddit));

        this.makeHttpRequest(requesturl, urlParameters);

    }

    public final void unsubscribe(String subreddit){
        String requesturl = ApiURL + Endpoints.SUBSCRIBE;

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("action", "unsub"));
        urlParameters.add(new BasicNameValuePair("sr_name", subreddit));

        this.makeHttpRequest(requesturl, urlParameters);

    }


    public final void hide(String fullnameId)  {
        String requesturl = ApiURL + Endpoints.HIDE;

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("id", fullnameId));

        this.makeHttpRequest(requesturl, urlParameters);
    }

    public final void unhide(String fullnameId) {
        String requesturl = ApiURL + Endpoints.UNHIDE;

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("id", fullnameId));

        this.makeHttpRequest(requesturl, urlParameters);
    }

    /**
     *
     * @param fullnameId Thing Id to which to reply
     * @param text Reply body
     *
     */
    public Comment reply(String fullnameId, String text)  {
        String requesturl = ApiURL + Endpoints.REPLY;

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("api_type", "json"));
        urlParameters.add(new BasicNameValuePair("text", text));
        urlParameters.add(new BasicNameValuePair("thing_id", fullnameId));

        PostReturn pstr = this.getDataObject(this.makeHttpRequest(requesturl, urlParameters), PostReturn.class);

        return pstr.getComment().getData();
    }



    public final Post edit(String fullnameId, String text) {
        String requesturl = ApiURL + Endpoints.EDIT;

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("api_type", "json"));
        urlParameters.add(new BasicNameValuePair("text", text));
        urlParameters.add(new BasicNameValuePair("thing_id", fullnameId));


        PostReturn pstr = this.getDataObject(this.makeHttpRequest(requesturl, urlParameters), PostReturn.class);

        if(pstr.getKind().equals("link")){
            return pstr.getLink().getData();
        }
        else return pstr.getComment().getData();

    }


    private <T extends Thing<? extends ListingData>, E extends Thing> List<Thingy> getListings
            (String requesturl, Integer limit, Class<T> type)  {
        Double querynumd = (limit / 100) + 0.5;
        int querynum = querynumd.intValue();
        String afterid = "";
        List<T> listinglist = new ArrayList<>();
        List<E> submlist = new ArrayList<>();
        //TODO: make the last request partial
        System.out.println(requesturl);
        for(int i=0;i<=querynum;i++){
            requesturl = requesturl + "&after=" + afterid;
            T listing = this.getDataObject(makeHttpRequest(requesturl), type);
            listinglist.add(listing);
            afterid = listing.getData().getAfter();

            if(afterid == null) break;
        }

        for(T t1lst:listinglist){
            //submlist.addAll((List<E>)t1lst.getData().getChildren().stream().collect(Collectors.toList()));
            for(E subm:(List<E>)t1lst.getData().getChildren()){
                submlist.add(subm);
            }
        }
        if(submlist.size() > limit)
            submlist = submlist.subList(0, limit);

        return submlist.stream().map(e -> (Thingy) e.getData()).collect(Collectors.toList());

    }


    private String makeHttpRequest(String requesturl){
        return client.get(requesturl);
    }

    private String makeHttpRequest(String requesturl, List<NameValuePair> urlParameters){
        return client.post(requesturl, urlParameters);
    }


    private <T> T getDataObject(String json, Class<T> type)  {

        JsonParser parser = new JsonParser();
        //System.out.println(json);

        try{
            parser.parse(json);
        }catch (com.google.gson.JsonSyntaxException ex){
            throw new RedditJerkException("Server response is not a valid JSON");
        }

        //System.out.println(json);

        //check if the returned json is an error message
        JsonError jerror;
        try{
            jerror = gson.fromJson(json, JsonError.class);
        }catch (com.google.gson.JsonSyntaxException ex){
            jerror = new JsonError();
            jerror.setError(null);

        }


        if(jerror.getError() != null) throw new RedditJerkException("Error Json Object returned, error code:" + jerror.getError());

        return gson.fromJson(json, type);

    }

}
