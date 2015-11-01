package ga.dryco.JerkTest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ga.dryco.redditJerk.controllers.Overview;
import ga.dryco.redditJerk.controllers.RedditThread;
import ga.dryco.redditJerk.datamodels.*;
import ga.dryco.redditJerk.datamodels.Deserializers.OverviewDeserializer;
import ga.dryco.redditJerk.datamodels.Deserializers.T1Deserializer;
import ga.dryco.redditJerk.datamodels.Deserializers.T3Deserializer;
import ga.dryco.redditJerk.datamodels.Deserializers.ThreadDeserializer;
import ga.dryco.redditJerk.datamodels.RedditThreadData;
import ga.dryco.redditJerk.rest.OAuthClient;

import java.io.IOException;


public class test {
    public static void main(String[] args){
        OAuthClient rc = new OAuthClient("RedditGod Bot v0.1 /u/redditgoddus");
        String json = "";
        String json2 = "";
        String json3 = "";
        String json4 = "";
        String json5 = "";
        String json6 = "";

        try{
            json = rc.get("http://api.reddit.com/r/Marxism/about/");
            json2 = rc.get("http://api.reddit.com/user/IamWithTheDConsNow/about/");
            json3 = rc.get("http://api.reddit.com/r/Marxism/");
            json4 = rc.get("http://api.reddit.com/user/IamWithTheDConsNow/comments");
            json5 = rc.get("https://api.reddit.com/r/history/comments/39wnnr/who_will_announce_the_queen_is_dead_long_live_the/");
            json6 = rc.get("https://api.reddit.com/user/IamWithTheDConsNow/?limit=100");
        } catch (IllegalArgumentException e){
            System.out.println("Invalid url");
        }

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(T1.class, new T1Deserializer());
        gsonBuilder.registerTypeAdapter(T3.class, new T3Deserializer());
        gsonBuilder.registerTypeAdapter(RedditThreadData.class, new ThreadDeserializer());
        gsonBuilder.registerTypeAdapter(OverviewData.class, new OverviewDeserializer());

        Gson gson = gsonBuilder.create();



        T5 subreddit = gson.fromJson(json, T5.class);
        System.out.println(subreddit.getData().getTitle());

        T2 user = gson.fromJson(json2, T2.class);
        System.out.println(user.getData().getName());

        T3Listing listlink = gson.fromJson(json3, T3Listing.class);
        for(T3 l:listlink.getData().getChildren()){
            System.out.println(l.getData().getTitle());
        }

        T1Listing comments = gson.fromJson(json4, T1Listing.class);
        System.out.println(comments.getData().getChildren().get(14).getData().getBody());
        for(T1 c:comments.getData().getChildren()){
            System.out.println(c.getData().getBody());
        }

        T1Data comment12 = comments.getData().getChildren().get(12).getData();
        System.out.println(comment12.getAuthor());

        RedditThread cthread = gson.fromJson(json5, RedditThread.class);


        System.out.println(cthread.getSubmissionPost().getData().getTitle());
        System.out.println(cthread.getComments().getData().getChildren().get(0).getData().getBody());

        System.out.println(cthread.getFlatComments().size());
        for(T1Data t1: cthread.getFlatComments()){
            System.out.println(t1.getBody());
        }

        Overview ovrv = gson.fromJson(json6, Overview.class);
        System.out.println(ovrv.getComments().size());
        System.out.println(ovrv.getAfter());
        System.out.println(ovrv.getComments().get(0).getData().getBody());


    }
}
