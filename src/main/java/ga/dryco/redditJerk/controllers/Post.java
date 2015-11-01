package ga.dryco.redditJerk.controllers;



/**
 * Interface for Links and Comments
 */
public interface Post {
    Post edit(String text) ;
    void delete() ;
    void upwnvote() ;
    void downvote() ;
    Post reply(String text) ;
}
