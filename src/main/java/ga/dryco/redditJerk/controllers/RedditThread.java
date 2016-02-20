package ga.dryco.redditJerk.controllers;

import ga.dryco.redditJerk.datamodels.More;
import ga.dryco.redditJerk.datamodels.T1;
import ga.dryco.redditJerk.datamodels.T1Listing;
import ga.dryco.redditJerk.datamodels.RedditThreadData;

import java.util.ArrayList;
import java.util.List;


public class RedditThread extends RedditThreadData {
    private List<Comment> flatComments = new ArrayList<>();
    private List<More> more = new ArrayList<>();
    private boolean alreadyFlattened = false;
    public List<Comment> getFlatComments() {
        if(!this.alreadyFlattened){
            this.flattenComments(super.getComments());
            this.alreadyFlattened = true;
        }
        return flatComments;
    }

    public List<More> getMoreComments(){
        return this.more;
    }

    /**
     * Flatten the nested reply tree with recursion
     * @param listing T1Listing
     */
    private void flattenComments(T1Listing listing){
        this.more.addAll(listing.getData().getMoreChildren());
        for(T1 comm:listing.getData().getChildren()){
            flatComments.add(comm.getData());
            if(comm.getData().getReplies() != null){
                this.flattenComments(comm.getData().getReplies());
            }
        }

    }

            
    }

