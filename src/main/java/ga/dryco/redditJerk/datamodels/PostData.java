package ga.dryco.redditjerk.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * parent class for t1Data and t3Data
 */
public class PostData {

    @Expose
    private String subreddit;

    @Expose
    private Integer score;

    @Expose
    private String author;

    @Expose
    private long created;

    @SerializedName("created_utc")
    @Expose
    private long createdUtc;

    @SerializedName("subreddit_id")
    @Expose
    private String subredditId;


    @SerializedName("banned_by")
    @Expose
    private String bannedBy;

    @Expose
    private Boolean likes;

    @SerializedName("removal_reason")
    @Expose
    private String removalReason;

    @Expose
    private String id;


    @Expose
    private Integer gilded;

    @Expose
    private Boolean archived;


    @SerializedName("report_reasons")
    @Expose
    private List<String> reportReasons;

    @SerializedName("user_reports")
    @Expose
    private List<Object> userReports = new ArrayList<Object>();


    @SerializedName("approved_by")
    @Expose
    private String approvedBy;


    @SerializedName("author_flair_css_class")
    @Expose
    private String authorFlairCssClass;

    @Expose
    private Integer downs;

    @Expose
    private Boolean saved;


    @Expose
    private String name;

    @SerializedName("author_flair_text")
    @Expose
    private String authorFlairText;

    @Expose
    private String distinguished;

    @SerializedName("mod_reports")
    @Expose
    private List<Object> modReports = new ArrayList<Object>();

    @SerializedName("num_reports")
    @Expose
    private Integer numReports;

    @Expose
    private Integer ups;

    @Expose
    private Boolean quarantine;



    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(long createdUtc) {
        this.createdUtc = createdUtc;
    }

    public String getSubredditId() {
        return subredditId;
    }

    public void setSubredditId(String subredditId) {
        this.subredditId = subredditId;
    }

    public String getBannedBy() {
        return bannedBy;
    }

    public void setBannedBy(String bannedBy) {
        this.bannedBy = bannedBy;
    }

    public Boolean getLikes() {
        return likes;
    }

    public void setLikes(Boolean likes) {
        this.likes = likes;
    }

    public String getRemovalReason() {
        return removalReason;
    }

    public void setRemovalReason(String removalReason) {
        this.removalReason = removalReason;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getGilded() {
        return gilded;
    }

    public void setGilded(Integer gilded) {
        this.gilded = gilded;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public List<String> getReportReasons() {
        return reportReasons;
    }

    public void setReportReasons(List<String> reportReasons) {
        this.reportReasons = reportReasons;
    }

    public List<Object> getUserReports() {
        return userReports;
    }

    public void setUserReports(List<Object> userReports) {
        this.userReports = userReports;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getAuthorFlairCssClass() {
        return authorFlairCssClass;
    }

    public void setAuthorFlairCssClass(String authorFlairCssClass) {
        this.authorFlairCssClass = authorFlairCssClass;
    }

    public Integer getDowns() {
        return downs;
    }

    public void setDowns(Integer downs) {
        this.downs = downs;
    }

    public Boolean getSaved() {
        return saved;
    }

    public void setSaved(Boolean saved) {
        this.saved = saved;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorFlairText() {
        return authorFlairText;
    }

    public void setAuthorFlairText(String authorFlairText) {
        this.authorFlairText = authorFlairText;
    }

    public String getDistinguished() {
        return distinguished;
    }

    public void setDistinguished(String distinguished) {
        this.distinguished = distinguished;
    }

    public List<Object> getModReports() {
        return modReports;
    }

    public void setModReports(List<Object> modReports) {
        this.modReports = modReports;
    }

    public Integer getNumReports() {
        return numReports;
    }

    public void setNumReports(Integer numReports) {
        this.numReports = numReports;
    }

    public Integer getUps() {
        return ups;
    }

    public void setUps(Integer ups) {
        this.ups = ups;
    }

    public Boolean getQuarantine() {
        return quarantine;
    }

    public void setQuarantine(Boolean quarantine) {
        this.quarantine = quarantine;
    }
}
