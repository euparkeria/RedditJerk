package ga.dryco.JerkTest;

import ga.dryco.redditJerk.Reddit;
import ga.dryco.redditJerk.RedditApi;
import ga.dryco.redditJerk.controllers.*;
import ga.dryco.redditJerk.datamodels.PostData;
import ga.dryco.redditJerk.datamodels.Thing;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;
import java.util.stream.Collectors;


public class test2 {
    public static void main(String[] args) throws MalformedURLException {
        Reddit red = RedditApi.getRedditInstance("TestCliefnt34");
        //red.login("RedditJerkTest", "jerkjerkjerk", "WoXLiKdjulE09Q", "QoG2unmpgAum-IQ92NDhhNy-UKs");

        long startTime = System.currentTimeMillis();

        User someone = red.getUser("IAmAQuantumMechanic");
        List<Comment> comlst = someone.getGilded(5);

        for(Comment com:comlst){
            System.out.println(com.getBody());
        }


/*
        List<String> idList = new ArrayList<>();
        for(int i = 4594320; i<=4594350; i++){

            idList.add("t5_" + Integer.toString(i, 36));

        }

        Double numOfQueries = (idList.size() / 100) + 0.5;
        Integer num = numOfQueries.intValue();
        Integer curIndex = 0;
        List<Subreddit> subreddits = new ArrayList<>();

        for(int i = 0; i <= num; i++){

            subreddits.addAll(red.getInfo_subreddit(idList.subList(curIndex, (curIndex + 100) > idList.size() ? idList.size() : curIndex + 100)));
            curIndex =+100;
            System.out.println("Query:" + i + ", " + subreddits.size());

        }

        System.out.println(subreddits.size());
        System.out.println(subreddits);

        for(Subreddit sub: subreddits){
            System.out.println(sub.getAccountsActive());

        }
*/
/*

        List<Subreddit> subreddits = red.getInfo_subreddit(idList);
        System.out.println(subreddits.size());

        for(Subreddit sbr:  subreddits){
            System.out.println(sbr.getDisplayName());
        }


*/

/*

        List<Comment> onionComList = red.getSubredditComments("movies", 1000);
        for(Comment com: onionComList){
            System.out.println(com.getBody());
        }
*/
/*
        User user = red.getUser("sav2880");

        List<Link> linklist123 = user.getSubmitted(1000);
        System.out.println(linklist123.size());
        for(Link com: linklist123){
            System.out.println(com.getSubreddit());
        }
*/
/**

*/
/**
        Map<Integer, Integer> hourAggr = new HashMap<>();
        Calendar calendar = Calendar.getInstance();

        for(PostData pst: linklist123){

            calendar.setTimeInMillis(pst.getCreatedUtc() * 1000);

            Integer hour = calendar.get(Calendar.HOUR_OF_DAY);

            Integer value = hourAggr.get(hour);
            if(value == null){
                hourAggr.put(hour, 1);
            }else {
                hourAggr.put(hour, value + 1);
            }

        }

        System.out.println(hourAggr);
        */

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);



/**

        RedditThread post = red.getRedditThread("https://www.reddit.com/r/videos/comments/3onrrk/worlds_most_pathetic_elevator_chime/");

        for(Comment comm:post.getFlatComments()){
            System.out.println(comm.getBody());

        }
        System.out.println(post.getFlatComments().size());
        System.out.println(post.getMoreComments().size());
        System.out.println(post.getMoreComments().get(0).getData().getChildren().get(0));


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
