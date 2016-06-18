package ga.dryco.redditjerk;

import ga.dryco.redditjerk.api.enums.Sorting;
import ga.dryco.redditjerk.implementation.RedditApi;
import ga.dryco.redditjerk.wrappers.*;

import java.net.MalformedURLException;


public class ClientTest {
    public static void main(String[] args) throws MalformedURLException {
        RedditApi rApi = RedditApi.getRedditInstance("Test clv1");


        User myUser = rApi.login("RedditJerkTest", "jerkjerkjerk", "WoXLiKdjulE09Q", "QoG2unmpgAum-IQ92NDhhNy-UKs");

        //rApi.subscribe("flairtestsubreddit");

      //  rApi.acceptModInvite("flairtestsubreddit");

     //   List<Link> rlist = rApi.getModerationReportsSubmissions("flairtestsubreddit", Moderation.UNMODERATED, 100);
     //   for(Link lnk:rlist){
     //       System.out.println(lnk.getTitle());
     //       rApi.distinguish(lnk.getName(), Distinguish.SPECIAL);
    //    }

        //rApi.clearFlairTemplates("flairtestsubreddit", "USER_FLAIR");
        //rApi.leaveModeration("flairtestsubreddit");
     //   rApi.linkFlair("flairtestsubreddit", "t3_4jlhec", "GREATEST", "");
      //  rApi.userFlair("flairtestsubreddit", "seldonn", "CRAP!!", "");


        RedditThread rthread1 = rApi.getRedditThread("https://www.reddit.com/r/science/comments/4kvf0i/nasa_ama_we_are_expanding_the_first_humanrated/", Sorting.NEW);
        rthread1.fetchMoreComments(true);
        System.out.println(rthread1.getFlatComments().size());
        for(Comment com:rthread1.getFlatComments()){
            System.out.println(com.getBody());
        }

        System.out.println(rthread1.getFlatComments().size());


/*
        List<String> idList = new ArrayList<>();
        idList.add("d3bw0lf");
        idList.add("d3bw0le");

        MoreChildren mm = rApi.getMoreChildren(idList,"t3_4k2p3f");
        T1Listing tt = mm.getMoreChildrenComments();
        System.out.println(tt.getData().getChildren().size());
        for(T1 com: tt.getData().getChildren()){
            System.out.println(com.getData().getBody());

        }
*/


/*
        List<Comment> uCom = rApi.getUserComments("iamwiththedconsnow", 10000, Sorting.NEW);
        for(Comment c:uCom){
            System.out.println(c.getReplies());
        }
        System.out.println(uCom.size());
        /*
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
