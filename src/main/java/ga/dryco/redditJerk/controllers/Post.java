package ga.dryco.redditJerk.controllers;



/**
 * Interface for Links and Comments
 */
public interface Post extends Thingy{
    Post edit(String text) ;
    void delete() ;
    void upwnvote() ;
    void downvote() ;
    Post reply(String text) ;
}
