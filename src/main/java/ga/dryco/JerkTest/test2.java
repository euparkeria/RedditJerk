package ga.dryco.JerkTest;

import ga.dryco.redditJerk.Reddit;
import ga.dryco.redditJerk.RedditApi;
import ga.dryco.redditJerk.controllers.*;


import java.io.IOException;


/**
 * Created by mekoneko on 7/14/2015.
 */
public class test2 {
    public static void main(String[] args) throws IOException {
        Reddit red = RedditApi.getRedditInstance("TestClient34");
        //red.login("RedditJerkTest", "jerkjerkjerk", "WoXLiKdjulE09Q", "QoG2unmpgAum-IQ92NDhhNy-UKs");
        User user = red.getUser("IamWithTheDconsNow");
        System.out.println(user.getCommentKarma());
        System.out.println(user.getName());


/**
        RedditThread post = red.getThread("https://www.reddit.com/r/videos/comments/3onrrk/worlds_most_pathetic_elevator_chime/");

        for(Comment comm:post.getFlatComments()){
            System.out.println(comm.getBody());

        }
        System.out.println(post.getFlatComments().size());
        System.out.println(post.getMoreComments().size());
        System.out.println(post.getMoreComments().get(0).getData().getChildren().get(0));
*/
        /**
        List<Comment> clist = user.getComments(299, "new");
        System.out.println(clist.size());
        for(Comment comm:clist){
            System.out.println(comm.getCreated());
        }

        List<Link> slist = user.getSubmitted(100, "top");
        System.out.println(slist.size());
        for(Link subm:slist){
            System.out.println(subm.getScore());
        }

        List<Link> marxism = red.getSubredditPage("all", 25, "new");

        for(Link subm: marxism){
            System.out.println(subm.getTitle());
        }

        System.out.println(user.getKarmaBalance("MMORPG", 20));
*/

    }
}
