package ga.dryco.redditjerk.datamodels;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class T5Data {

    @SerializedName("banner_img")
    @Expose
    private String bannerImg;

    @SerializedName("user_is_banned")
    @Expose
    private Boolean userIsBanned;

    @Expose
    private String id;
    @SerializedName("user_is_contributor")
    @Expose
    private Boolean userIsContributor;
    @SerializedName("submit_text")
    @Expose
    private String submitText;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("header_img")
    @Expose
    private String headerImg;
    @SerializedName("description_html")
    @Expose
    private String descriptionHtml;
    @Expose
    private String title;
    @SerializedName("collapse_deleted_comments")
    @Expose
    private Boolean collapseDeletedComments;
    @SerializedName("public_description")
    @Expose
    private String publicDescription;
    @Expose
    private Boolean over18;

    @SerializedName("public_description_html")
    @Expose
    private String publicDescriptionHtml;

    @SerializedName("icon_img")
    @Expose
    private String iconImg;

    @Expose
    private String description;

    @SerializedName("accounts_active")
    @Expose
    private Integer accountsActive;

    @SerializedName("public_traffic")
    @Expose
    private Boolean publicTraffic;
    @SerializedName("header_size")
    @Expose
    private List<Integer> headerSize = new ArrayList<Integer>();
    @Expose
    private Integer subscribers;

    @Expose
    private String name;
    @Expose
    private long created;
    @Expose
    private String url;
    @SerializedName("hide_ads")
    @Expose
    private Boolean hideAds;
    @SerializedName("created_utc")
    @Expose
    private long createdUtc;

    @SerializedName("user_is_moderator")
    @Expose
    private Boolean userIsModerator;
    @SerializedName("user_sr_theme_enabled")
    @Expose
    private Boolean userSrThemeEnabled;
    @SerializedName("comment_score_hide_mins")
    @Expose
    private Integer commentScoreHideMins;
    @SerializedName("subreddit_type")
    @Expose
    private String subredditType;
    @SerializedName("submission_type")
    @Expose
    private String submissionType;
    @SerializedName("user_is_subscriber")
    @Expose
    private Boolean userIsSubscriber;

    @Expose
    private Boolean quarantine;


    public Boolean getQuarantine() {
        return quarantine;
    }

    public void setQuarantine(Boolean quarantine) {
        this.quarantine = quarantine;
    }
    /**
     *
     * @return
     * The bannerImg
     */
    public String getBannerImg() {
        return bannerImg;
    }

    /**
     *
     * @param bannerImg
     * The banner_img
     */
    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }


    /**
     *
     * @return
     * The userIsBanned
     */
    public Boolean getUserIsBanned() {
        return userIsBanned;
    }

    /**
     *
     * @param userIsBanned
     * The user_is_banned
     */
    public void setUserIsBanned(Boolean userIsBanned) {
        this.userIsBanned = userIsBanned;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The userIsContributor
     */
    public Boolean getUserIsContributor() {
        return userIsContributor;
    }

    /**
     *
     * @param userIsContributor
     * The user_is_contributor
     */
    public void setUserIsContributor(Boolean userIsContributor) {
        this.userIsContributor = userIsContributor;
    }

    /**
     *
     * @return
     * The submitText
     */
    public String getSubmitText() {
        return submitText;
    }

    /**
     *
     * @param submitText
     * The submit_text
     */
    public void setSubmitText(String submitText) {
        this.submitText = submitText;
    }

    /**
     *
     * @return
     * The displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     *
     * @param displayName
     * The display_name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     *
     * @return
     * The headerImg
     */
    public String getHeaderImg() {
        return headerImg;
    }

    /**
     *
     * @param headerImg
     * The header_img
     */
    public void setHeaderImg(String headerImg) {
        this.headerImg = headerImg;
    }

    /**
     *
     * @return
     * The descriptionHtml
     */
    public String getDescriptionHtml() {
        return descriptionHtml;
    }

    /**
     *
     * @param descriptionHtml
     * The description_html
     */
    public void setDescriptionHtml(String descriptionHtml) {
        this.descriptionHtml = descriptionHtml;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The collapseDeletedComments
     */
    public Boolean getCollapseDeletedComments() {
        return collapseDeletedComments;
    }

    /**
     *
     * @param collapseDeletedComments
     * The collapse_deleted_comments
     */
    public void setCollapseDeletedComments(Boolean collapseDeletedComments) {
        this.collapseDeletedComments = collapseDeletedComments;
    }

    /**
     *
     * @return
     * The publicDescription
     */
    public String getPublicDescription() {
        return publicDescription;
    }

    /**
     *
     * @param publicDescription
     * The public_description
     */
    public void setPublicDescription(String publicDescription) {
        this.publicDescription = publicDescription;
    }

    /**
     *
     * @return
     * The over18
     */
    public Boolean getOver18() {
        return over18;
    }

    /**
     *
     * @param over18
     * The over18
     */
    public void setOver18(Boolean over18) {
        this.over18 = over18;
    }

    /**
     *
     * @return
     * The publicDescriptionHtml
     */
    public String getPublicDescriptionHtml() {
        return publicDescriptionHtml;
    }

    /**
     *
     * @param publicDescriptionHtml
     * The public_description_html
     */
    public void setPublicDescriptionHtml(String publicDescriptionHtml) {
        this.publicDescriptionHtml = publicDescriptionHtml;
    }



    /**
     *
     * @return
     * The iconImg
     */
    public String getIconImg() {
        return iconImg;
    }

    /**
     *
     * @param iconImg
     * The icon_img
     */
    public void setIconImg(String iconImg) {
        this.iconImg = iconImg;
    }



    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     *
     * @return
     * The accountsActive
     */
    public Integer getAccountsActive() {
        return accountsActive;
    }

    /**
     *
     * @param accountsActive
     * The accounts_active
     */
    public void setAccountsActive(Integer accountsActive) {
        this.accountsActive = accountsActive;
    }

    /**
     *
     * @return
     * The publicTraffic
     */
    public Boolean getPublicTraffic() {
        return publicTraffic;
    }

    /**
     *
     * @param publicTraffic
     * The public_traffic
     */
    public void setPublicTraffic(Boolean publicTraffic) {
        this.publicTraffic = publicTraffic;
    }

    /**
     *
     * @return
     * The headerSize
     */
    public List<Integer> getHeaderSize() {
        return headerSize;
    }

    /**
     *
     * @param headerSize
     * The header_size
     */
    public void setHeaderSize(List<Integer> headerSize) {
        this.headerSize = headerSize;
    }

    /**
     *
     * @return
     * The subscribers
     */
    public Integer getSubscribers() {
        return subscribers;
    }

    /**
     *
     * @param subscribers
     * The subscribers
     */
    public void setSubscribers(Integer subscribers) {
        this.subscribers = subscribers;
    }


    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The created
     */
    public long getCreated() {
        return created;
    }

    /**
     *
     * @param created
     * The created
     */
    public void setCreated(long created) {
        this.created = created;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The hideAds
     */
    public Boolean getHideAds() {
        return hideAds;
    }

    /**
     *
     * @param hideAds
     * The hide_ads
     */
    public void setHideAds(Boolean hideAds) {
        this.hideAds = hideAds;
    }

    /**
     *
     * @return
     * The createdUtc
     */
    public long getCreatedUtc() {
        return createdUtc;
    }

    /**
     *
     * @param createdUtc
     * The created_utc
     */
    public void setCreatedUtc(long createdUtc) {
        this.createdUtc = createdUtc;
    }

    /**
     *
     * @return
     * The userIsModerator
     */
    public Boolean getUserIsModerator() {
        return userIsModerator;
    }

    /**
     *
     * @param userIsModerator
     * The user_is_moderator
     */
    public void setUserIsModerator(Boolean userIsModerator) {
        this.userIsModerator = userIsModerator;
    }

    /**
     *
     * @return
     * The userSrThemeEnabled
     */
    public Boolean getUserSrThemeEnabled() {
        return userSrThemeEnabled;
    }

    /**
     *
     * @param userSrThemeEnabled
     * The user_sr_theme_enabled
     */
    public void setUserSrThemeEnabled(Boolean userSrThemeEnabled) {
        this.userSrThemeEnabled = userSrThemeEnabled;
    }

    /**
     *
     * @return
     * The commentScoreHideMins
     */
    public Integer getCommentScoreHideMins() {
        return commentScoreHideMins;
    }

    /**
     *
     * @param commentScoreHideMins
     * The comment_score_hide_mins
     */
    public void setCommentScoreHideMins(Integer commentScoreHideMins) {
        this.commentScoreHideMins = commentScoreHideMins;
    }

    /**
     *
     * @return
     * The subredditType
     */
    public String getSubredditType() {
        return subredditType;
    }

    /**
     *
     * @param subredditType
     * The subreddit_type
     */
    public void setSubredditType(String subredditType) {
        this.subredditType = subredditType;
    }

    /**
     *
     * @return
     * The submissionType
     */
    public String getSubmissionType() {
        return submissionType;
    }

    /**
     *
     * @param submissionType
     * The submission_type
     */
    public void setSubmissionType(String submissionType) {
        this.submissionType = submissionType;
    }

    /**
     *
     * @return
     * The userIsSubscriber
     */
    public Boolean getUserIsSubscriber() {
        return userIsSubscriber;
    }

    /**
     *
     * @param userIsSubscriber
     * The user_is_subscriber
     */
    public void setUserIsSubscriber(Boolean userIsSubscriber) {
        this.userIsSubscriber = userIsSubscriber;
    }

}
