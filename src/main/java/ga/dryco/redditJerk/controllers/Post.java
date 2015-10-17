package ga.dryco.redditJerk.controllers;

import java.io.IOException;

/**
 * Interface for Links and Comments
 */
public interface Post {
    Post edit(String text) throws IOException;
    void delete() throws IOException;
    void upwnvote() throws IOException;
    void downvote() throws IOException;
    Post reply(String text) throws IOException;
}
