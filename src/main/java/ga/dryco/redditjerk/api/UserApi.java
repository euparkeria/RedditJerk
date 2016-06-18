package ga.dryco.redditjerk.api;

import ga.dryco.redditjerk.api.enums.Sorting;
import ga.dryco.redditjerk.wrappers.Comment;
import ga.dryco.redditjerk.wrappers.Link;
import ga.dryco.redditjerk.wrappers.User;

import java.util.List;

/**
 * User related functions
 *
 */

public interface UserApi {
    User login(String username, String password, String clientId, String secret);
    User getUser(String username);

    List<Comment> getUserComments(String username, Integer limit, Sorting sort);
    List<Link> getUserHidden(String username, Integer limit);
    List<Link> getUserDownvoted(String username, Integer limit);
    List<Link> getUserUpvoted(String username, Integer limit);
    List<Comment> getUserGilded(String username, Integer limit);
    List<Link> getUserSubmissions(String username, Integer limit, Sorting sort);
    void giveGold(String username, Integer months);


}
