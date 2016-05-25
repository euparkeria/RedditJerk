package ga.dryco.redditjerk.datamodels;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * data of type t1 represents a Comment type object,
 * all comments are t1 objects
 * User OverviewData page Listing can contain both t3 and t1 objects *
 *
 * */

public class T1Data extends PostData {


    @SerializedName("link_title")
    @Expose
    private String linkTitle;

    @SerializedName("link_id")
    @Expose
    private String linkId;

    @SerializedName("link_author")
    @Expose
    private String linkAuthor;

    // replies can contain a mixed listing of Things of both "t1" and "more"
    @Expose
    private T1Listing replies;

    @SerializedName("parent_id")
    @Expose
    private String parentId;

    @Expose
    private Integer controversiality;
    @Expose
    private String body;

    @SerializedName("body_html")
    @Expose
    private String bodyHtml;

    @SerializedName("score_hidden")
    @Expose
    private Boolean scoreHidden;

    @SerializedName("link_url")
    @Expose
    private String linkUrl;


    public String getLinkTitle() {
        return linkTitle;
    }

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getLinkAuthor() {
        return linkAuthor;
    }

    public void setLinkAuthor(String linkAuthor) {
        this.linkAuthor = linkAuthor;
    }

    public T1Listing getReplies() {
        return replies;
    }

    public void setReplies(T1Listing replies) {
        this.replies = replies;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getControversiality() {
        return controversiality;
    }

    public void setControversiality(Integer controversiality) {
        this.controversiality = controversiality;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBodyHtml() {
        return bodyHtml;
    }

    public void setBodyHtml(String bodyHtml) {
        this.bodyHtml = bodyHtml;
    }

    public Boolean getScoreHidden() {
        return scoreHidden;
    }

    public void setScoreHidden(Boolean scoreHidden) {
        this.scoreHidden = scoreHidden;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }


}