package ga.dryco.redditJerk.datamodels;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * data of type t1 represents a Comment type object,
 * all comments are t1 objects
 * User OverviewData page Listing can contain both t3 and t1 objects *
 *
 * */

public class T1Data extends PostData{

    @SerializedName("subreddit_id")
    @Expose
    private String subredditId;
    @SerializedName("link_title")
    @Expose
    private String linkTitle;
    @SerializedName("banned_by")
    @Expose
    private Object bannedBy;
    @SerializedName("removal_reason")
    @Expose
    private Object removalReason;
    @SerializedName("link_id")
    @Expose
    private String linkId;
    @SerializedName("link_author")
    @Expose
    private String linkAuthor;
    @Expose
    private Boolean likes;
    // replies can contain a mixed listing of Things of both "t1" and "more"
    @Expose
    private T1Listing replies;
    @SerializedName("user_reports")
    @Expose
    private List<Object> userReports = new ArrayList<Object>();
    @Expose
    private Boolean saved;
    @Expose
    private String id;
    @Expose
    private Integer gilded;
    @Expose
    private Boolean archived;
    @SerializedName("report_reasons")
    @Expose
    private Object reportReasons;

    @SerializedName("parent_id")
    @Expose
    private String parentId;

    @SerializedName("approved_by")
    @Expose
    private Object approvedBy;
    @Expose
    private Integer controversiality;
    @Expose
    private String body;
    @SerializedName("author_flair_css_class")
    @Expose
    private Object authorFlairCssClass;
    @Expose
    private Integer downs;
    @SerializedName("body_html")
    @Expose
    private String bodyHtml;

    @SerializedName("score_hidden")
    @Expose
    private Boolean scoreHidden;
    @Expose
    private String name;
    @Expose
    private Double created;
    @SerializedName("author_flair_text")
    @Expose
    private Object authorFlairText;
    @SerializedName("link_url")
    @Expose
    private String linkUrl;
    @SerializedName("created_utc")
    @Expose
    private Double createdUtc;
    @Expose
    private Integer ups;
    @SerializedName("mod_reports")
    @Expose
    private List<Object> modReports = new ArrayList<Object>();
    @SerializedName("num_reports")
    @Expose
    private Object numReports;
    @Expose
    private Object distinguished;

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
     * The linkTitle
     */
    public String getLinkTitle() {
        return linkTitle;
    }

    /**
     *
     * @param linkTitle
     * The link_title
     */
    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
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
     * The linkId
     */
    public String getLinkId() {
        return linkId;
    }

    /**
     *
     * @param linkId
     * The link_id
     */
    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    /**
     *
     * @return
     * The linkAuthor
     */
    public String getLinkAuthor() {
        return linkAuthor;
    }

    /**
     *
     * @param linkAuthor
     * The link_author
     */
    public void setLinkAuthor(String linkAuthor) {
        this.linkAuthor = linkAuthor;
    }

    /**
     *
     * @return
     * The likes
     */
    public Boolean getLikes() {
        return likes;
    }

    /**
     *
     * @param likes
     * The likes
     */
    public void setLikes(Boolean likes) {
        this.likes = likes;
    }

    /**
     *
     * @return
     * The replies
     */
    public T1Listing getReplies() {
        return replies;
    }

    /**
     *
     * @param replies
     * The replies
     */
    public void setReplies(T1Listing replies) {
        this.replies = replies;
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
     * The parentId
     */
    public String getParentId() {
        return parentId;
    }

    /**
     *
     * @param parentId
     * The parent_id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
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
     * The controversiality
     */
    public Integer getControversiality() {
        return controversiality;
    }

    /**
     *
     * @param controversiality
     * The controversiality
     */
    public void setControversiality(Integer controversiality) {
        this.controversiality = controversiality;
    }

    /**
     *
     * @return
     * The body
     */
    public String getBody() {
        return body;
    }

    /**
     *
     * @param body
     * The body
     */
    public void setBody(String body) {
        this.body = body;
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
     * The bodyHtml
     */
    public String getBodyHtml() {
        return bodyHtml;
    }

    /**
     *
     * @param bodyHtml
     * The body_html
     */
    public void setBodyHtml(String bodyHtml) {
        this.bodyHtml = bodyHtml;
    }

    /**
     *
     * @return
     * The scoreHidden
     */
    public Boolean getScoreHidden() {
        return scoreHidden;
    }

    /**
     *
     * @param scoreHidden
     * The score_hidden
     */
    public void setScoreHidden(Boolean scoreHidden) {
        this.scoreHidden = scoreHidden;
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
     * The linkUrl
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     *
     * @param linkUrl
     * The link_url
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
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

}