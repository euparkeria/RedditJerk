package ga.dryco.JerkTest;

import ga.dryco.redditJerk.Reddit;
import ga.dryco.redditJerk.RedditApi;
import ga.dryco.redditJerk.controllers.Comment;
import ga.dryco.redditJerk.controllers.RedditThread;
import ga.dryco.redditJerk.controllers.User;

import java.io.IOException;

/**
 * Created by mekoneko on 8/11/2015.
 */
public class clientTest {
    public static void main(String[] args){
        Reddit rApi = RedditApi.getRedditInstance("Test clv1");

        try {
            User myUser = rApi.login("RedditJerkTest", "jerkjerkjerk", "WoXLiKdjulE09Q", "QoG2unmpgAum-IQ92NDhhNy-UKs");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(rApi.authData.getAccessTokenJson());
        //User myuser = rApi.me();
        //System.out.println(myuser.getName());
        RedditThread tp = null;
        try {
            tp = rApi.getThread("https://www.reddit.com/r/biggomno/comments/3h881b/test/");
        } catch (IOException e) {
            e.printStackTrace();
        }


        assert tp != null;
        Comment comm = tp.getFlatComments().get(1);

        try {
            System.out.println("REPLYING");
            Comment replcomm = comm.reply("1YapaYapa22");
            System.out.println(replcomm.getBody());
            System.out.println(replcomm.getName());

            Comment edittedComment = replcomm.edit("WORKS FINALLY ???");
            System.out.println(edittedComment.getBody());




        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
