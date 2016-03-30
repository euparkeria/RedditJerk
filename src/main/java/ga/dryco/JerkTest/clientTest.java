package ga.dryco.JerkTest;

import ga.dryco.redditJerk.Reddit;
import ga.dryco.redditJerk.RedditApi;

import ga.dryco.redditJerk.controllers.*;




public class clientTest {
    public static void main(String[] args){
        Reddit rApi = RedditApi.getRedditInstance("Test clv1");


        User myUser = rApi.login("RedditJerkTest", "jerkjerkjerk", "WoXLiKdjulE09Q", "QoG2unmpgAum-IQ92NDhhNy-UKs");

        rApi.subscribe("news");
        rApi.unsubscribe("news");


        //System.out.println(rApi.authData.getAccessTokenJson());
        //User myuser = rApi.me();
        //System.out.println(myuser.getName());
        /*
        RedditThread tp = null;

        try {
            tp = rApi.getRedditThread("https://www.reddit.com/r/Android/comments/46q9l1/exclusive_android_n_may_not_have_an_app_drawer/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        assert tp != null;
        Comment comm = tp.getFlatComments().get(1);

        Subreddit sub22 = rApi.getSubreddit("Marxism");
        sub22.getHot(20);





        System.out.println("REPLYING");*/
        //Comment replcomm = comm.reply("1YapaYapa22");
        //System.out.println(replcomm.getBody());
        //System.out.println(replcomm.getName());

        //Comment edittedComment = replcomm.edit("WORKS FINALLY ???");
        //System.out.println(edittedComment.getBody());



    }
}
