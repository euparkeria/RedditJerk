package ga.dryco.redditjerk.implementation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.sun.deploy.util.StringUtils;
import ga.dryco.redditjerk.api.*;
import ga.dryco.redditjerk.api.enums.*;
import ga.dryco.redditjerk.wrappers.*;
import ga.dryco.redditjerk.datamodels.*;
import ga.dryco.redditjerk.datamodels.deserializers.*;
import ga.dryco.redditjerk.exceptions.RedditJerkException;
import ga.dryco.redditjerk.rest.OAuthClient;
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
public final class RedditApi implements Reddit {
    private final OAuthClient client;


    private String ApiURL = ConfigValues.API_URL.toString();
    private final Gson gson;

    private RedditApi(String useragent){
        this.client = new OAuthClient(useragent);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(T1.class, new T1Deserializer());
        gsonBuilder.registerTypeAdapter(T3.class, new T3Deserializer());
        gsonBuilder.registerTypeAdapter(RedditThread.class, new ThreadDeserializer());
        gsonBuilder.registerTypeAdapter(PostReturn.class, new PostReturnDeserializer());
        gsonBuilder.registerTypeAdapter(T1Listing.class, new T1ListingDeserializer());
        gsonBuilder.registerTypeAdapter(MoreChildren.class, new MoreChildrenDeserializer());
        this.gson = gsonBuilder.create();

    }

    private static RedditApi ApiINSTANCE;

    public static RedditApi getRedditInstance(String userAgent){
        if(ApiINSTANCE == null)
            ApiINSTANCE = new RedditApi(userAgent);
        return ApiINSTANCE;
    }

    public static RedditApi getRedditInstance(){
        return ApiINSTANCE;
    }


    /**
     *
     * @param username reddit account username
     * @param password reddit account password
     * @param clientId oAuth app id
     * @param secret oAuth Secret
     * @return User object of the logged in user
     */
    public User login(String username, String password, String clientId, String secret) {
        this.ApiURL = ConfigValues.OAUTH_URL.toString();
        client.Authenticate(username, password, clientId, secret);

        return this.me();
    }

    /**
     *
     * @param username username to get
     * @return User object
     *
     */

    public User getUser(String username) {
        String requesturl = String.format(ApiURL + Endpoints.USER, username);

        T2 t2 = this.getDataObject(makeHttpRequest(requesturl), T2.class);
        return t2.getData();
    }


    /**
     *
     * @return User object of the logged in user
     */


    private User me() {
        String requesturl = ApiURL + Endpoints.ME;
        return this.getDataObject(makeHttpRequest(requesturl), User.class);

    }

    /**
     *
     *
     * @param url Url of the reddit thread
     * @param sort Sorting, top, hot, new
     * @return RedditThread object
     * @throws MalformedURLException
     */

    public RedditThread getRedditThread(String url, Sorting sort) throws MalformedURLException {
        URL purl = new URL(url);
        url = purl.getPath();

        String requesturl = String.format(ApiURL + Endpoints.REDDIT_THREAD, url, sort);

        return this.getDataObject(makeHttpRequest(requesturl), RedditThread.class);
    }

    public RedditThread getRandomPostFromSubreddit(String subreddit){

        String requesturl = String.format(ApiURL + Endpoints.SUBREDDIT_PAGE, subreddit, "random", 1, "");

        return this.getDataObject(makeHttpRequest(requesturl), RedditThread.class);

    }


    /**
     *
     * @param idList list of fullname ids for moreChildren comments
     * @param linkId Id of the Link object
     * @param sort Sorting
     * @return MoreChildren object
     */
    public MoreChildren getMoreChildren(List<String> idList, String linkId, Sorting sort){

        String idListComma = StringUtils.join(idList, ",");
        String requesturl = String.format(ApiURL + Endpoints.MORE_CHILDREN, idListComma, linkId, sort);

        return this.getDataObject(makeHttpRequest(requesturl), MoreChildren.class);
    }



    /**
     *
     * @param subreddit subreddit name
     * @return Subreddit object
     */
    public Subreddit getSubreddit(String subreddit)  {
        String requesturl = String.format(ApiURL + Endpoints.SUBREDDIT, subreddit);

        return this.getDataObject(makeHttpRequest(requesturl), T5.class).getData();
    }


    /**
     *
     * @param username reddit username
     * @param limit number of comments to get
     * @param sort Sorting
     * @return returns list of Comment objects
     */
    public final List<Comment> getUserComments(String username, Integer limit, Sorting sort) {
        String requesturl = String.format(ApiURL + Endpoints.USER_COMMENTS, username, limit, sort);

        return this.getListings(requesturl, limit, T1Listing.class).stream().map(comm -> (Comment) comm).collect(Collectors.toList());
    }

    /**
     *
     * @param username reddit username
     * @param limit number of comments to get
     * @return list of Comment objects
     */
    public final List<Comment> getUserGilded(String username, Integer limit){
        String requesturl = String.format(ApiURL + Endpoints.USER_GILDED, username, limit);

        return this.getListings(requesturl, limit, T1Listing.class).stream().map(comm -> (Comment) comm).collect(Collectors.toList());

    }

    /**
     *
     * @param username username to give gold to
     * @param months for how many months, must be between 1 and 36
     */
    public final void giveGold(String username, Integer months){
        String requesturl = String.format(ApiURL + Endpoints.GIVE_GOLD, username);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("months", months.toString()));
        urlParameters.add(new BasicNameValuePair("username", username));


        this.makeHttpRequest(requesturl, urlParameters);


    }


    /**
     *
     * @param username reddit username
     * @param limit number of links to get
     * @return list of Link objects
     */
    public final List<Link> getUserUpvoted(String username, Integer limit){
        String requesturl = String.format(ApiURL + Endpoints.USER_UPVOTED, username, limit);

        return this.getListings(requesturl, limit, T3Listing.class).stream().map(lnk -> (Link) lnk).collect(Collectors.toList());

    }

    /**
     *
     * @param username reddit username
     * @param limit number of links to get
     * @return list of Link objects
     */
    public final List<Link> getUserDownvoted(String username, Integer limit){
        String requesturl = String.format(ApiURL + Endpoints.USER_DOWNVOTED, username, limit);

        return this.getListings(requesturl, limit, T3Listing.class).stream().map(lnk -> (Link) lnk).collect(Collectors.toList());

    }

    /**
     *
     * @param username reddit username
     * @param limit number of links to get
     * @return list of Link objects
     */
    public final List<Link> getUserHidden(String username, Integer limit){
        String requesturl = String.format(ApiURL + Endpoints.USER_HIDDEN, username, limit);

        return this.getListings(requesturl, limit, T3Listing.class).stream().map(lnk -> (Link) lnk).collect(Collectors.toList());

    }

    /**
     *
     * @param username reddit username
     * @param limit number of links to get
     * @param sort Sorting
     * @return list of Link objects
     */
    public final List<Link> getUserSubmissions(String username, Integer limit, Sorting sort)  {
        String requesturl = String.format(ApiURL + Endpoints.USER_SUBS, username, limit, sort);

        return this.getListings(requesturl, limit, T3Listing.class).stream().map(lnk -> (Link) lnk).collect(Collectors.toList());
    }

    /**
     *
     * @param subreddit Subreddit name
     * @param limit number of links to get
     * @param sort Sorting
     * @param timeperiod From how far back to get links
     * @return list of Link objects
     */
    public List<Link> getSubredditPage(String subreddit, Integer limit, Sorting sort, FromPast timeperiod)  {
        String requesturl = String.format(ApiURL + Endpoints.SUBREDDIT_PAGE, subreddit, sort, limit, timeperiod);

        return this.getListings(requesturl, limit, T3Listing.class).stream().map(lnk -> (Link) lnk).collect(Collectors.toList());
    }


    /**
     *
     * @param subreddit subreddit name
     * @param limit number of comments to get
     * @return list of comment objects
     */
    public List<Comment> getSubredditComments(String subreddit, Integer limit){
        String requesturl = String.format(ApiURL + Endpoints.SUBREDDIT_COMMENTS, subreddit, limit);

        return this.getListings(requesturl, limit, T1Listing.class).stream().map(cmt -> (Comment) cmt).collect(Collectors.toList());

    }


    /**
     *
     * @param subreddit
     * @param modreport
     * @param limit
     * @return
     */
    public List<Link> getModerationReportsSubmissions(String subreddit, Moderation modreport, Integer limit){
        String requesturl = String.format(ApiURL + Endpoints.MODERATION_SUBMISSIONS, subreddit, modreport, limit);

        return this.getListings(requesturl, limit, T3Listing.class).stream().map(cmt -> (Link) cmt).collect(Collectors.toList());

    }

    /**
     *
     * @param subreddit
     * @param modreport
     * @param limit
     * @return
     */
    public List<Comment> getModerationReportsComments(String subreddit, Moderation modreport, Integer limit){
        String requesturl = String.format(ApiURL + Endpoints.MODERATION_COMMENTS, subreddit, modreport, limit);

        return this.getListings(requesturl, limit, T1Listing.class).stream().map(cmt -> (Comment) cmt).collect(Collectors.toList());

    }

    /**
     *
     * @param idList
     * @return
     */
    // list can be of comments, links, or subreddit objects
    public List<Subreddit> getInfo_subreddit(List<String> idList){
        return this.getInfo(idList, T5Listing.class).stream().map(t -> (Subreddit) t).collect(Collectors.toList());
    }

    /**
     *
     * @param idList
     * @return
     */
    public List<Link> getInfo_link(List<String> idList){
        return this.getInfo(idList, T3Listing.class).stream().map(t -> (Link) t).collect(Collectors.toList());
    }

    /**
     *
     * @param idList
     * @return
     */
    public List<Comment> getInfo_comment(List<String> idList){
        return this.getInfo(idList, T1Listing.class).stream().map(t -> (Comment) t).collect(Collectors.toList());
    }


    /**
     *
     * @param idList
     * @param typeC
     * @param <T>
     * @return
     */
    private <T extends Thing<? extends ListingData>> List<Thingy> getInfo(List<String> idList, Class<T> typeC){
        final int MAX_INFO_LIST = 100;
        if(idList.size() > MAX_INFO_LIST) throw new RedditJerkException("/api/info thing list larger than 100");
        String ids = String.join(",", idList);

        String requesturl = String.format(ApiURL + Endpoints.INFO, ids);

        return this.getListings(requesturl, MAX_INFO_LIST, typeC).stream().collect(Collectors.toList());

    }

    /**
     *
     * @param subreddit
     * @return
     */
    public List<User> getSubredditModerators(String subreddit) {

        List<User> returnUserList = new ArrayList<>();

        List<ModeratorsData> modListing = this.getSubredditModeratorsRaw(subreddit);

        returnUserList.addAll(modListing.stream().map(modD -> this.getUser(modD.getName())).collect(Collectors.toList()));

        return  returnUserList;

    }

    /**
     * This returns the raw ModeratorsData objects which avoids all the extra getUser() API calls, useful if you
     * dont need the actual User objects.
     *
     * @param subreddit subreddit name
     * @return returns a list with ModeratorsData
     */
    public List<ModeratorsData> getSubredditModeratorsRaw(String subreddit){
        String requesturl = String.format(ApiURL + Endpoints.SUB_MODERATORS, subreddit);


        return this.getDataObject(makeHttpRequest(requesturl), ModeratorsListing.class).getData().getChildren();

    }

    /**
     *
     * @param fullnameId Thing Id
     * @param direction "1" for upvote, "-1" for downvote
     *
     */
    public void vote(String fullnameId, String direction)  {
        String requesturl = ApiURL + Endpoints.VOTE;
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("id", fullnameId));
        urlParameters.add(new BasicNameValuePair("dir", direction));
        this.makeHttpRequest(requesturl, urlParameters);
    }


    /**
     *
     * @param subreddit Subreddit name in which to post a new submission
     * @param title Title of the submission
     * @param bodyOrUrl Url or body of Submission
     * @param kind should be either "link" or "self"
     * @return Link object
     */
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

    /**
     *
     * @param fullnameId Fullname Id of an object to delete
     */
    public final void delete(String fullnameId) {
        String requesturl = ApiURL + Endpoints.DELETE;

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("api_type", "json"));
        urlParameters.add(new BasicNameValuePair("id", fullnameId));

        this.makeHttpRequest(requesturl, urlParameters);

    }

    /**
     *
     * @param subreddit subreddit name
     */
    public final void subscribe(String subreddit){
        String requesturl = ApiURL + Endpoints.SUBSCRIBE;

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("action", "sub"));
        urlParameters.add(new BasicNameValuePair("sr_name", subreddit));

        this.makeHttpRequest(requesturl, urlParameters);

    }

    /**
     *
     * @param subreddit subreddit name
     */
    public final void unsubscribe(String subreddit){
        String requesturl = ApiURL + Endpoints.SUBSCRIBE;

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("action", "unsub"));
        urlParameters.add(new BasicNameValuePair("sr_name", subreddit));

        this.makeHttpRequest(requesturl, urlParameters);

    }

    /**
     *
     * @param fullnameId Fullname Id of the object to hide
     */
    public final void hide(String fullnameId)  {
        String requesturl = ApiURL + Endpoints.HIDE;

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("id", fullnameId));

        this.makeHttpRequest(requesturl, urlParameters);
    }

    /**
     *
     * @param fullnameId ullname Id of the object to unhide
     */
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


    /**
     *
     * @param fullnameId Fullname id of an object to edit
     * @param text Text of the editted object
     * @return Either Comment or Link object
     */
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

    /**
     *
     * @param subreddit subreddit name
     */
    public final void acceptModInvite(String subreddit){
        String requesturl = String.format(ApiURL + Endpoints.ACCEPT_MOD_INVITE, subreddit);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("api_type", "json"));

        this.makeHttpRequest(requesturl, urlParameters);

    }

    /**
     *
     * @param fullnameId fullname id of an object to approve as moderator
     */
    public final void approve(String fullnameId){
        String requesturl = ApiURL + Endpoints.APPROVE;

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("id", fullnameId));

        this.makeHttpRequest(requesturl, urlParameters);

    }


    /**
     *
     * @param fullnameId fullname id of an object to remove as moderator
     * @param spam Is it Spam or not
     */
    public final void remove(String fullnameId, Boolean spam){
        String requesturl = ApiURL + Endpoints.REMOVE;

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("id", fullnameId));
        urlParameters.add(new BasicNameValuePair("spam", spam.toString()));

        this.makeHttpRequest(requesturl, urlParameters);

    }

    /**
     *
     * @param fullnameId Fullname id of an object to distinguish
     * @param distinguish Distinguish
     */
    public final void distinguish(String fullnameId, Distinguish distinguish){
        String requesturl = ApiURL + Endpoints.DISTINGUISH;

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("api_type", "json"));
        urlParameters.add(new BasicNameValuePair("how", distinguish.toString()));
        urlParameters.add(new BasicNameValuePair("id", fullnameId));

        this.makeHttpRequest(requesturl, urlParameters);

    }



    /**
     * The reddit API requires subreddit fullId instead of Name to leave moderation so we do another api call here
     * to get the fullid from a subreddit name
     *
     * @param subreddit subreddit name
     */
    public final void leaveModeration(String subreddit){
        String requesturl = ApiURL + Endpoints.LEAVE_MODERATOR;

        String subFullId = this.getSubreddit(subreddit).getName();

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("id", subFullId));

        this.makeHttpRequest(requesturl, urlParameters);

    }

    /**
     *
     * @param subreddit Subreddit name
     */
    public final void leaveContributor(String subreddit){
        String requesturl = ApiURL + Endpoints.LEAVE_CONTRIBUTOR;

        String subFullId = this.getSubreddit(subreddit).getName();

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("id", subFullId));

        this.makeHttpRequest(requesturl, urlParameters);

    }

    /**
     *
     * @param thingFullId Fullname Id of a thing
     */
    public final void ignoreReports(String thingFullId){
        String requesturl = ApiURL + Endpoints.IGNORE_REPORTS;

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("id", thingFullId));

        this.makeHttpRequest(requesturl, urlParameters);


    }

    /**
     *
     * @param thingFullId Full name id of a thing
     */

    public final void unignoreReports(String thingFullId){
        String requesturl = ApiURL + Endpoints.UNIGNORE_REPORTS;

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("id", thingFullId));

        this.makeHttpRequest(requesturl, urlParameters);


    }


    /**
     *
     * Flair Api
     *
     */

    public final void flairConfig(String flair_enabled, FlairPosition flair_position, Boolean flair_self_assign_enabled, FlairPosition link_flair_position, Boolean link_flair_self_assign_enabled){
        String requesturl = ApiURL + Endpoints.FLAIR_CONFIG;

        List<NameValuePair> urlParameters = new ArrayList<>();

        urlParameters.add(new BasicNameValuePair("api_type", "json"));
        urlParameters.add(new BasicNameValuePair("flair_enabled", flair_enabled));
        urlParameters.add(new BasicNameValuePair("flair_position", flair_position.toString()));
        urlParameters.add(new BasicNameValuePair("flair_self_assign_enabled", flair_self_assign_enabled.toString()));
        urlParameters.add(new BasicNameValuePair("link_flair_position", link_flair_position.toString()));
        urlParameters.add(new BasicNameValuePair("link_flair_self_assign_enabled", link_flair_self_assign_enabled.toString()));

        this.makeHttpRequest(requesturl, urlParameters);


    }

    public void deleteFlair(String subreddit, String username){
        String requesturl = String.format(ApiURL + Endpoints.DELETE_FLAIR, subreddit);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("api_type", "json"));
        urlParameters.add(new BasicNameValuePair("name", username));

        this.makeHttpRequest(requesturl, urlParameters);


    }

    public void clearFlairTemplates(String subreddit, String flairtype){
        String requesturl = String.format(ApiURL + Endpoints.CLEAR_FLAIR_TEMPLATES, subreddit);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("api_type", "json"));
        urlParameters.add(new BasicNameValuePair("flair_type", flairtype));

        this.makeHttpRequest(requesturl, urlParameters);


    }

    public void deleteFlairTemplate(String subreddit, String flairTemplateId){
        String requesturl = String.format(ApiURL + Endpoints.DELETE_FLAIR_TEMPLATE, subreddit);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("api_type", "json"));
        urlParameters.add(new BasicNameValuePair("flair_template_id", flairTemplateId));

        this.makeHttpRequest(requesturl, urlParameters);


    }

    public void userFlair(String subreddit, String name, String text, String css_class){
        String requesturl = String.format(ApiURL + Endpoints.FLAIR, subreddit);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("api_type", "json"));
        urlParameters.add(new BasicNameValuePair("css_class", css_class));
        urlParameters.add(new BasicNameValuePair("name", name));
        urlParameters.add(new BasicNameValuePair("text", text));

        this.makeHttpRequest(requesturl, urlParameters);


    }

    /**
     *
     * @param subreddit name of the subreddit
     * @param link_fullName fullname id of the subreddit, must start with t3_
     * @param text flair text
     * @param css_class css class
     */

    public void linkFlair(String subreddit, String link_fullName, String text, String css_class){
        String requesturl = String.format(ApiURL + Endpoints.FLAIR, subreddit);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("api_type", "json"));
        urlParameters.add(new BasicNameValuePair("link", link_fullName));
        urlParameters.add(new BasicNameValuePair("text", text));
        urlParameters.add(new BasicNameValuePair("css_class", css_class));

        this.makeHttpRequest(requesturl, urlParameters);


    }

    public final void markNsfw(String fullnameId){
        String requesturl = ApiURL + Endpoints.MARK_NSFW;
        List<NameValuePair> urlParameters = new ArrayList<>();

        urlParameters.add(new BasicNameValuePair("id", fullnameId));

        this.makeHttpRequest(requesturl, urlParameters);


    }

    public final void unmarkNsfw(String fullnameId){
        String requesturl = ApiURL + Endpoints.UNMARK_NSFW;
        List<NameValuePair> urlParameters = new ArrayList<>();

        urlParameters.add(new BasicNameValuePair("id", fullnameId));

        this.makeHttpRequest(requesturl, urlParameters);


    }

    public final void lock(String fullnameId){
        String requesturl = ApiURL + Endpoints.LOCK;
        List<NameValuePair> urlParameters = new ArrayList<>();

        urlParameters.add(new BasicNameValuePair("id", fullnameId));

        this.makeHttpRequest(requesturl, urlParameters);


    }

    public final void unlock(String fullnameId){
        String requesturl = ApiURL + Endpoints.UNLOCK;
        List<NameValuePair> urlParameters = new ArrayList<>();

        urlParameters.add(new BasicNameValuePair("id", fullnameId));

        this.makeHttpRequest(requesturl, urlParameters);

    }


    private <T extends Thing<? extends ListingData>, E extends Thing> List<Thingy> getListings
            (String requesturl, Integer limit, Class<T> type)  {

        List<T> listinglist = this.getRawListings(requesturl, limit, type);

        List<E> submlist = new ArrayList<>();

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

    private <T extends Thing<? extends ListingData>> List<T> getRawListings(String requesturl, Integer limit, Class<T> type){

        Integer MAX_ITEMS_PER_QUERY = 100;

        Double querynumd = (limit / MAX_ITEMS_PER_QUERY) + 0.5;
        int querynum = querynumd.intValue();
        String afterid = "";
        List<T> listinglist = new ArrayList<>();
        //TODO: make the last request partial
        //System.out.println(requesturl);
        for(int i=0;i<=querynum;i++){
            requesturl = requesturl + "&after=" + afterid;
            T listing = this.getDataObject(makeHttpRequest(requesturl), type);
            listinglist.add(listing);
            afterid = listing.getData().getAfter();

            if(afterid == null) break;
        }

        return listinglist;

    }


    private String makeHttpRequest(String requesturl){
        return client.get(requesturl);
    }

    private String makeHttpRequest(String requesturl, List<NameValuePair> urlParameters){
        //System.out.println("Post URL parameters:" + urlParameters);
        return client.post(requesturl, urlParameters);

    }


    private <T> T getDataObject(String json, Class<T> type)  {

        JsonParser parser = new JsonParser();

        try{
            parser.parse(json);
        }catch (com.google.gson.JsonSyntaxException ex){
            throw new RedditJerkException("Server response is not a valid JSON");
        }

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
