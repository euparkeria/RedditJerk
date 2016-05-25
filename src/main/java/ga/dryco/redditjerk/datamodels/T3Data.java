package ga.dryco.redditjerk.datamodels;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * data of type t3 represents a Link type object,
 * all front page or subreddit Listings contain only t3 objects.
 * User OverviewData page Listing can contain both t3 and t1 objects *
 *
 * */


public class T3Data extends PostData {

    @Expose
    private String domain;

    @SerializedName("selftext_html")
    @Expose
    private String selftextHtml;

    @Expose
    private String selftext;

    @SerializedName("suggested_sort")
    @Expose
    private String suggestedSort;

    @SerializedName("secure_media")
    @Expose
    private Object secureMedia;

    @SerializedName("link_flair_text")
    @Expose
    private String linkFlairText;

    @SerializedName("from_kind")
    @Expose
    private String fromKind;

    @Expose
    private Boolean clicked;

    @Expose
    private Object media;

    @SerializedName("over_18")
    @Expose
    private Boolean over18;

    @Expose
    private Boolean hidden;

    @SerializedName("num_comments")
    @Expose
    private Integer numComments;

    @Expose
    private String thumbnail;

    @SerializedName("hide_score")
    @Expose
    private Boolean hideScore;

    @Expose
    private String edited;

    @SerializedName("link_flair_css_class")
    @Expose
    private String linkFlairCssClass;

    @Expose
    private Boolean stickied;

    @Expose
    private String from;

    @SerializedName("is_self")
    @Expose
    private Boolean isSelf;

    @SerializedName("from_id")
    @Expose
    private String fromId;

    @Expose
    private String permalink;

    @Expose
    private Boolean locked;

    @Expose
    private String url;

    @Expose
    private String title;

    @Expose
    private Boolean visited;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSelftextHtml() {
        return selftextHtml;
    }

    public void setSelftextHtml(String selftextHtml) {
        this.selftextHtml = selftextHtml;
    }

    public String getSelftext() {
        return selftext;
    }

    public void setSelftext(String selftext) {
        this.selftext = selftext;
    }

    public String getSuggestedSort() {
        return suggestedSort;
    }

    public void setSuggestedSort(String suggestedSort) {
        this.suggestedSort = suggestedSort;
    }

    public Object getSecureMedia() {
        return secureMedia;
    }

    public void setSecureMedia(Object secureMedia) {
        this.secureMedia = secureMedia;
    }

    public String getLinkFlairText() {
        return linkFlairText;
    }

    public void setLinkFlairText(String linkFlairText) {
        this.linkFlairText = linkFlairText;
    }

    public String getFromKind() {
        return fromKind;
    }

    public void setFromKind(String fromKind) {
        this.fromKind = fromKind;
    }

    public Boolean getClicked() {
        return clicked;
    }

    public void setClicked(Boolean clicked) {
        this.clicked = clicked;
    }

    public Object getMedia() {
        return media;
    }

    public void setMedia(Object media) {
        this.media = media;
    }

    public Boolean getOver18() {
        return over18;
    }

    public void setOver18(Boolean over18) {
        this.over18 = over18;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Integer getNumComments() {
        return numComments;
    }

    public void setNumComments(Integer numComments) {
        this.numComments = numComments;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Boolean getHideScore() {
        return hideScore;
    }

    public void setHideScore(Boolean hideScore) {
        this.hideScore = hideScore;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getLinkFlairCssClass() {
        return linkFlairCssClass;
    }

    public void setLinkFlairCssClass(String linkFlairCssClass) {
        this.linkFlairCssClass = linkFlairCssClass;
    }

    public Boolean getStickied() {
        return stickied;
    }

    public void setStickied(Boolean stickied) {
        this.stickied = stickied;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Boolean getSelf() {
        return isSelf;
    }

    public void setSelf(Boolean self) {
        isSelf = self;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }
}