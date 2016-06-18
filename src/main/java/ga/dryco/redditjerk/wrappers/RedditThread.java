package ga.dryco.redditjerk.wrappers;

import ga.dryco.redditjerk.api.Reddit;
import ga.dryco.redditjerk.implementation.RedditApi;
import ga.dryco.redditjerk.api.enums.Sorting;
import ga.dryco.redditjerk.datamodels.More;
import ga.dryco.redditjerk.datamodels.T1;
import ga.dryco.redditjerk.datamodels.T1Listing;
import ga.dryco.redditjerk.datamodels.RedditThreadData;

import java.util.ArrayList;
import java.util.List;


public class RedditThread extends RedditThreadData {

    private Reddit rApi = RedditApi.getRedditInstance();

    private List<Comment> flatComments;
    private boolean alreadyFlattened = false;
    private boolean moreCommentsAlreadyFetched = false;
    private boolean fetchMoreComments = false;

    public boolean isFetchMoreComments() {
        return fetchMoreComments;
    }

    public void fetchMoreComments(boolean fetchMoreComments) {
        this.fetchMoreComments = fetchMoreComments;
    }

    public List<Comment> getFlatComments() {
        if(!this.alreadyFlattened | this.fetchMoreComments & !this.moreCommentsAlreadyFetched){
            this.flatComments = new ArrayList<>();
            this.flattenComments(super.getComments());
            this.alreadyFlattened = true;
            if(this.fetchMoreComments) this.moreCommentsAlreadyFetched = true;
        }
        return flatComments;
    }


    /**
     * Flatten the nested reply tree with recursion
     * also fetch the MoreComments
     * @param listing T1Listing
     */
    private void flattenComments(T1Listing listing){
        if(listing != null) {
            if(this.fetchMoreComments) {
                //this.moreObjects.addAll(listing.getData().getMoreChildrenComments());
                for (More mor : listing.getData().getMoreChildren()) {
                    Integer MAX_ITEMS_PER_QUERY = 20;
                    List<List<String>> listOfIdLists = new ArrayList<>();
                    //dividing the list into lists of 20 items each
                    for (int i = 0; i <= mor.getData().getChildren().size(); i += MAX_ITEMS_PER_QUERY) {
                        listOfIdLists.add(mor.getData().getChildren().subList(i, Math.min(i + MAX_ITEMS_PER_QUERY, mor.getData().getChildren().size())));
                    }
                    for (List<String> idLst : listOfIdLists) {
                        this.flattenComments(rApi.getMoreChildren(idLst, super.getSubmissionPost().getData().getName(), Sorting.NEW).getMoreChildrenComments());
                    }
                }
            }

            for (T1 comm : listing.getData().getChildren()) {
                flatComments.add(comm.getData());
                if (comm.getData().getReplies() != null) {
                    this.flattenComments(comm.getData().getReplies());
                }
            }
        }
    }
            
    }

