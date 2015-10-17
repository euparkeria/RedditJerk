package ga.dryco.redditJerk.datamodels;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * data of type t3 represents a Link type object,
 * all front page or subreddit Listings contain only t3 objects.
 * User OverviewData page Listing can contain both t3 and t1 objects *
 *
 * */

@Generated("org.jsonschema2pojo")
public class T3Data {

    @Expose
    private String domain;
    @SerializedName("banned_by")
    @Expose
    private Object bannedBy;
    @Expose
    private String subreddit;
    @SerializedName("selftext_html")
    @Expose
    private Object selftextHtml;
    @Expose
    private String selftext;
    @Expose
    private Object likes;
    @SerializedName("suggested_sort")
    @Expose
    private Object suggestedSort;
    @SerializedName("user_reports")
    @Expose
    private List<Object> userReports = new ArrayList<Object>();
    @SerializedName("secure_media")
    @Expose
    private Object secureMedia;
    @SerializedName("link_flair_text")
    @Expose
    private Object linkFlairText;
    @Expose
    private String id;
    @SerializedName("from_kind")
    @Expose
    private Object fromKind;
    @Expose
    private Integer gilded;
    @Expose
    private Boolean archived;
    @Expose
    private Boolean clicked;
    @SerializedName("report_reasons")
    @Expose
    private Object reportReasons;
    @Expose
    private String author;
    @Expose
    private Object media;
    @Expose
    private Integer score;
    @SerializedName("approved_by")
    @Expose
    private Object approvedBy;
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
    @SerializedName("subreddit_id")
    @Expose
    private String subredditId;
    @Expose
    private String edited;
    @SerializedName("link_flair_css_class")
    @Expose
    private Object linkFlairCssClass;
    @SerializedName("author_flair_css_class")
    @Expose
    private Object authorFlairCssClass;
    @Expose
    private Integer downs;

    @Expose
    private Boolean saved;
    @SerializedName("removal_reason")
    @Expose
    private Object removalReason;
    @Expose
    private Boolean stickied;
    @Expose
    private Object from;
    @SerializedName("is_self")
    @Expose
    private Boolean isSelf;
    @SerializedName("from_id")
    @Expose
    private Object fromId;
    @Expose
    private String permalink;
    @Expose
    private String name;
    @Expose
    private Double created;
    @Expose
    private String url;
    @SerializedName("author_flair_text")
    @Expose
    private Object authorFlairText;
    @Expose
    private String title;
    @SerializedName("created_utc")
    @Expose
    private Double createdUtc;
    @Expose
    private Object distinguished;
    @SerializedName("mod_reports")
    @Expose
    private List<Object> modReports = new ArrayList<Object>();
    @Expose
    private Boolean visited;
    @SerializedName("num_reports")
    @Expose
    private Object numReports;
    @Expose
    private Integer ups;

    /**
     *
     * @return
     * The domain
     */
    public String getDomain() {
        return domain;
    }

    /**
     *
     * @param domain
     * The domain
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     *
     * @return
     * The bannedBy
     */
    public Object getBannedBy() {
        return bannedBy;
    }

    /**
     *
     * @param bannedBy
     * The banned_by
     */
    public void setBannedBy(Object bannedBy) {
        this.bannedBy = bannedBy;
    }


    /**
     *
     * @return
     * The subreddit
     */
    public String getSubreddit() {
        return subreddit;
    }

    /**
     *
     * @param subreddit
     * The subreddit
     */
    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    /**
     *
     * @return
     * The selftextHtml
     */
    public Object getSelftextHtml() {
        return selftextHtml;
    }

    /**
     *
     * @param selftextHtml
     * The selftext_html
     */
    public void setSelftextHtml(Object selftextHtml) {
        this.selftextHtml = selftextHtml;
    }

    /**
     *
     * @return
     * The selftext
     */
    public String getSelftext() {
        return selftext;
    }

    /**
     *
     * @param selftext
     * The selftext
     */
    public void setSelftext(String selftext) {
        this.selftext = selftext;
    }

    /**
     *
     * @return
     * The likes
     */
    public Object getLikes() {
        return likes;
    }

    /**
     *
     * @param likes
     * The likes
     */
    public void setLikes(Object likes) {
        this.likes = likes;
    }

    /**
     *
     * @return
     * The suggestedSort
     */
    public Object getSuggestedSort() {
        return suggestedSort;
    }

    /**
     *
     * @param suggestedSort
     * The suggested_sort
     */
    public void setSuggestedSort(Object suggestedSort) {
        this.suggestedSort = suggestedSort;
    }

    /**
     *
     * @return
     * The userReports
     */
    public List<Object> getUserReports() {
        return userReports;
    }

    /**
     *
     * @param userReports
     * The user_reports
     */
    public void setUserReports(List<Object> userReports) {
        this.userReports = userReports;
    }

    /**
     *
     * @return
     * The secureMedia
     */
    public Object getSecureMedia() {
        return secureMedia;
    }

    /**
     *
     * @param secureMedia
     * The secure_media
     */
    public void setSecureMedia(Object secureMedia) {
        this.secureMedia = secureMedia;
    }

    /**
     *
     * @return
     * The linkFlairText
     */
    public Object getLinkFlairText() {
        return linkFlairText;
    }

    /**
     *
     * @param linkFlairText
     * The link_flair_text
     */
    public void setLinkFlairText(Object linkFlairText) {
        this.linkFlairText = linkFlairText;
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
     * The fromKind
     */
    public Object getFromKind() {
        return fromKind;
    }

    /**
     *
     * @param fromKind
     * The from_kind
     */
    public void setFromKind(Object fromKind) {
        this.fromKind = fromKind;
    }

    /**
     *
     * @return
     * The gilded
     */
    public Integer getGilded() {
        return gilded;
    }

    /**
     *
     * @param gilded
     * The gilded
     */
    public void setGilded(Integer gilded) {
        this.gilded = gilded;
    }

    /**
     *
     * @return
     * The archived
     */
    public Boolean getArchived() {
        return archived;
    }

    /**
     *
     * @param archived
     * The archived
     */
    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    /**
     *
     * @return
     * The clicked
     */
    public Boolean getClicked() {
        return clicked;
    }

    /**
     *
     * @param clicked
     * The clicked
     */
    public void setClicked(Boolean clicked) {
        this.clicked = clicked;
    }

    /**
     *
     * @return
     * The reportReasons
     */
    public Object getReportReasons() {
        return reportReasons;
    }

    /**
     *
     * @param reportReasons
     * The report_reasons
     */
    public void setReportReasons(Object reportReasons) {
        this.reportReasons = reportReasons;
    }

    /**
     *
     * @return
     * The author
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     * The author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return
     * The media
     */
    public Object getMedia() {
        return media;
    }

    /**
     *
     * @param media
     * The media
     */
    public void setMedia(Object media) {
        this.media = media;
    }

    /**
     *
     * @return
     * The score
     */
    public Integer getScore() {
        return score;
    }

    /**
     *
     * @param score
     * The score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     *
     * @return
     * The approvedBy
     */
    public Object getApprovedBy() {
        return approvedBy;
    }

    /**
     *
     * @param approvedBy
     * The approved_by
     */
    public void setApprovedBy(Object approvedBy) {
        this.approvedBy = approvedBy;
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
     * The over_18
     */
    public void setOver18(Boolean over18) {
        this.over18 = over18;
    }

    /**
     *
     * @return
     * The hidden
     */
    public Boolean getHidden() {
        return hidden;
    }

    /**
     *
     * @param hidden
     * The hidden
     */
    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    /**
     *
     * @return
     * The numComments
     */
    public Integer getNumComments() {
        return numComments;
    }

    /**
     *
     * @param numComments
     * The num_comments
     */
    public void setNumComments(Integer numComments) {
        this.numComments = numComments;
    }

    /**
     *
     * @return
     * The thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     *
     * @param thumbnail
     * The thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     *
     * @return
     * The subredditId
     */
    public String getSubredditId() {
        return subredditId;
    }

    /**
     *
     * @param subredditId
     * The subreddit_id
     */
    public void setSubredditId(String subredditId) {
        this.subredditId = subredditId;
    }

    /**
     *
     * @return
     * The edited
     */
    public String getEdited() {
        return edited;
    }

    /**
     *
     * @param edited
     * The edited
     */
    public void setEdited(String edited) {
        this.edited = edited;
    }

    /**
     *
     * @return
     * The linkFlairCssClass
     */
    public Object getLinkFlairCssClass() {
        return linkFlairCssClass;
    }

    /**
     *
     * @param linkFlairCssClass
     * The link_flair_css_class
     */
    public void setLinkFlairCssClass(Object linkFlairCssClass) {
        this.linkFlairCssClass = linkFlairCssClass;
    }

    /**
     *
     * @return
     * The authorFlairCssClass
     */
    public Object getAuthorFlairCssClass() {
        return authorFlairCssClass;
    }

    /**
     *
     * @param authorFlairCssClass
     * The author_flair_css_class
     */
    public void setAuthorFlairCssClass(Object authorFlairCssClass) {
        this.authorFlairCssClass = authorFlairCssClass;
    }

    /**
     *
     * @return
     * The downs
     */
    public Integer getDowns() {
        return downs;
    }

    /**
     *
     * @param downs
     * The downs
     */
    public void setDowns(Integer downs) {
        this.downs = downs;
    }


    /**
     *
     * @return
     * The saved
     */
    public Boolean getSaved() {
        return saved;
    }

    /**
     *
     * @param saved
     * The saved
     */
    public void setSaved(Boolean saved) {
        this.saved = saved;
    }

    /**
     *
     * @return
     * The removalReason
     */
    public Object getRemovalReason() {
        return removalReason;
    }

    /**
     *
     * @param removalReason
     * The removal_reason
     */
    public void setRemovalReason(Object removalReason) {
        this.removalReason = removalReason;
    }

    /**
     *
     * @return
     * The stickied
     */
    public Boolean getStickied() {
        return stickied;
    }

    /**
     *
     * @param stickied
     * The stickied
     */
    public void setStickied(Boolean stickied) {
        this.stickied = stickied;
    }

    /**
     *
     * @return
     * The from
     */
    public Object getFrom() {
        return from;
    }

    /**
     *
     * @param from
     * The from
     */
    public void setFrom(Object from) {
        this.from = from;
    }

    /**
     *
     * @return
     * The isSelf
     */
    public Boolean getIsSelf() {
        return isSelf;
    }

    /**
     *
     * @param isSelf
     * The is_self
     */
    public void setIsSelf(Boolean isSelf) {
        this.isSelf = isSelf;
    }

    /**
     *
     * @return
     * The fromId
     */
    public Object getFromId() {
        return fromId;
    }

    /**
     *
     * @param fromId
     * The from_id
     */
    public void setFromId(Object fromId) {
        this.fromId = fromId;
    }

    /**
     *
     * @return
     * The permalink
     */
    public String getPermalink() {
        return permalink;
    }

    /**
     *
     * @param permalink
     * The permalink
     */
    public void setPermalink(String permalink) {
        this.permalink = permalink;
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
    public Double getCreated() {
        return created;
    }

    /**
     *
     * @param created
     * The created
     */
    public void setCreated(Double created) {
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
     * The authorFlairText
     */
    public Object getAuthorFlairText() {
        return authorFlairText;
    }

    /**
     *
     * @param authorFlairText
     * The author_flair_text
     */
    public void setAuthorFlairText(Object authorFlairText) {
        this.authorFlairText = authorFlairText;
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
     * The createdUtc
     */
    public Double getCreatedUtc() {
        return createdUtc;
    }

    /**
     *
     * @param createdUtc
     * The created_utc
     */
    public void setCreatedUtc(Double createdUtc) {
        this.createdUtc = createdUtc;
    }

    /**
     *
     * @return
     * The distinguished
     */
    public Object getDistinguished() {
        return distinguished;
    }

    /**
     *
     * @param distinguished
     * The distinguished
     */
    public void setDistinguished(Object distinguished) {
        this.distinguished = distinguished;
    }

    /**
     *
     * @return
     * The modReports
     */
    public List<Object> getModReports() {
        return modReports;
    }

    /**
     *
     * @param modReports
     * The mod_reports
     */
    public void setModReports(List<Object> modReports) {
        this.modReports = modReports;
    }

    /**
     *
     * @return
     * The visited
     */
    public Boolean getVisited() {
        return visited;
    }

    /**
     *
     * @param visited
     * The visited
     */
    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    /**
     *
     * @return
     * The numReports
     */
    public Object getNumReports() {
        return numReports;
    }

    /**
     *
     * @param numReports
     * The num_reports
     */
    public void setNumReports(Object numReports) {
        this.numReports = numReports;
    }

    /**
     *
     * @return
     * The ups
     */
    public Integer getUps() {
        return ups;
    }

    /**
     *
     * @param ups
     * The ups
     */
    public void setUps(Integer ups) {
        this.ups = ups;
    }

}