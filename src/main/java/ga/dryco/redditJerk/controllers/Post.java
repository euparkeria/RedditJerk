package ga.dryco.redditjerk.controllers;


import ga.dryco.redditjerk.Distinguish;

/**
 * Interface for Links and Comments
 */
public interface Post extends Thingy{
    Post edit(String text) ;
    void delete() ;
    void upvote() ;
    void downvote() ;
    Post reply(String text) ;
    void hide();
    void unhide();
    void remove(Boolean spam);
    void approve();
    void distinguish(Distinguish distinguish);
}
