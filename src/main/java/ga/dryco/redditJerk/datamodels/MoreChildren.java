package ga.dryco.redditjerk.datamodels;

/**
 * returned data from /api/morechildren is converted to T1Listing and encaplusated in moreChildrenComments
 */
public class MoreChildren {
    private T1Listing moreChildrenComments;

    public T1Listing getMoreChildrenComments() {
        return moreChildrenComments;
    }

    public void setMoreChildrenComments(T1Listing moreChildrenComments) {
        this.moreChildrenComments = moreChildrenComments;
    }
}
