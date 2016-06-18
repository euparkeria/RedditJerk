package ga.dryco.redditjerk;

import ga.dryco.redditjerk.api.Reddit;
import ga.dryco.redditjerk.api.enums.FromPast;
import ga.dryco.redditjerk.api.enums.Sorting;
import ga.dryco.redditjerk.implementation.RedditApi;
import ga.dryco.redditjerk.wrappers.Link;

import java.util.ArrayList;
import java.util.List;


public class TestBot {
    public static void main(String[] args){

        List<String> done = new ArrayList<>();
        List<String> keywords = new ArrayList<>();
        Integer submsLastRun = 0;

        keywords.add("Linux");
        keywords.add("Cisco");
        keywords.add("Java");
        keywords.add("Windows");
        keywords.add("Fl Studio");
        keywords.add("Ahsoka");
        Reddit red = RedditApi.getRedditInstance("TestClient34");

        //red.login("RedditJerkTest", "jerkjerkjerk", "WoXLiKdjulE09Q", "QoG2unmpgAum-IQ92NDhhNy-UKs");

        while (true){
            List<Link> all;
            Integer sbmCount = 0;

            all = red.getSubredditPage("all", submsLastRun + 50, Sorting.NEW, FromPast.DAY);

            assert all != null;
            for(Link sbm: all){
                if(!done.contains(sbm.getName())){
                    sbmCount++;
                    keywords.stream().filter(str -> sbm.getTitle().toLowerCase().contains(str.toLowerCase())).forEach(str -> System.out.println("Keyword Matched: " + str + ", " + sbm.getName()));
                    done.add(sbm.getName());
                }

            }
            System.out.println("Already done:" + done.size() + "\nThis run:" + sbmCount);
            submsLastRun = sbmCount;
            try {
                System.out.println("Sleeping");
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
