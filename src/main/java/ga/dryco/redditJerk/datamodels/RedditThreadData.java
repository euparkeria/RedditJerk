package ga.dryco.redditjerk.datamodels;

/**
 * A thread contains a main post(Original Post) and optionally comments
 * the comments are nested and can be flattened into a simple List of T1 objects
 */
public class RedditThreadData {
    private T3 SubmissionPost;
    private T1Listing Comments;

    public T3 getSubmissionPost() {
        return SubmissionPost;
    }

    public void setSubmissionPost(T3 submissionPost) {
        SubmissionPost = submissionPost;
    }

    public T1Listing getComments() {
        return Comments;
    }

    public void setComments(T1Listing comments) {
        Comments = comments;
    }


}
