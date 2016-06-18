package ga.dryco.redditjerk;

import ga.dryco.redditjerk.api.Reddit;
import ga.dryco.redditjerk.api.enums.Distinguish;
import ga.dryco.redditjerk.api.enums.FromPast;
import ga.dryco.redditjerk.api.enums.Moderation;
import ga.dryco.redditjerk.api.enums.Sorting;
import ga.dryco.redditjerk.implementation.RedditApi;
import ga.dryco.redditjerk.wrappers.*;

import java.net.MalformedURLException;
import java.util.List;

public class ExamplesTest {
    public static void main(String[] args) throws MalformedURLException {


        //Getting the api instance with useragent as parameter:
        Reddit red = RedditApi.getRedditInstance("Reddit client Test v1313");

        //OAuth login, returns User object of the logged in account
        User myUser = red.login("RedditJerkTest", "jerkjerkjerk", "WoXLiKdjulE09Q", "QoG2unmpgAum-IQ92NDhhNy-UKs");

        //getting a redditor object
        User jerkUser = red.getUser("reditor123");

        //Give user reditor123 six months worth of Reddit Gold
        red.giveGold("reditor123", 6);

        //getting user comments, gets 200 newest comments
        List<Comment> clist = jerkUser.getComments(200, Sorting.NEW);

        //getting user's top 100 submissions
        List<Link> slist = jerkUser.getSubmitted(100, Sorting.TOP);

        //Getting user's Karma Balance in a moronic subreddit for his last 200 comments
        Integer karmaBalance = jerkUser.getKarmaBalance("MensRights", 200);

        //Getting a Subreddit object of a subreddit
        Subreddit amSubr = red.getSubreddit("ShitAmericansSay");

        //get /r/ShitAmericansSay 50 controversial submissions
        amSubr.getControversial(50);

        //get /r/ShitAmericansSay top 10 submissions, default timespan is DAY
        amSubr.getTop(10);

        //we can also specify the timespan
        amSubr.getTop(100, FromPast.ALL_TIME);
        amSubr.getTop(100, FromPast.WEEK);

        //Subscribe to the subreddit
        amSubr.subscribe();
        //Unsubscribe
        amSubr.unsubscribe();

        //Subscribe and unsibscribe from subreddits without gettinga Subreddit object
        red.subscribe("Socialism");
        red.unsubscribe("Funny");

        //and getting it's front page
        List<Link> amlinkList = amSubr.getHot(25);

        //Getting a reddit Thread object
        RedditThread post = red.getRedditThread(
                "https://www.reddit.com/r/Economics/comments/46lkfz/can_sanders_do_it_is_it_plausible_that_there/d06k38f", Sorting.NEW);

        //We can flatten comments like this, this will return all the comments in the
        // thread as a flat list, not inclding the MoreComments hidden comments.
        List<Comment> flatComments = post.getFlatComments();

        //If you want to get ALL the comments you should set fetchMoreComments property of the thread object to true
        //before you get the flat comments, this will make a lot of api calls and take a long time.
        post.fetchMoreComments(true);
        List<Comment> ALLflatComments = post.getFlatComments();

        Link subm = post.getSubmissionPost().getData();
        Comment myComment2 = subm.reply("South Park is Awesome!! :P");

        //Editing our comment
        myComment2.edit("South Park is SUPER Awesome!! :PPP");

        //upvoting the submission
        subm.upvote();

        //hiding and unhiding the submission
        subm.hide();
        subm.unhide();

        //Reaplying to first comment in the thread, myComment is the object of the comment you just posted.
        Comment firstComment = post.getFlatComments().get(0);
        Comment myComment1 = firstComment.reply("Hello!");

        //we can immidately delete our new comment
        myComment1.delete();

        //Submitting a new self post in subreddit TheRedPill that is bound to be upvoted and gilded
        red.Submit("TheRedPill", "DAE thinks women's job should be to please and serve men !?", "Anyone ? ", "self");

        //get top 5 submittions of the week in /r/learnprogramming
        List<Link> learnPrgrTop = red.getSubredditPage("learnprogramming", 5, Sorting.TOP, FromPast.WEEK);

        //getting /r/learnprogramming's moderators
        List<User> learnPrgMods = red.getSubredditModerators("learnprogramming");

        //printing their usernames
        for(User modusr: learnPrgMods){
            System.out.println(modusr.getName());
        }

        /**
         *
         * MODERATION API
         *
         *
         */

        //Accept an invitation to be moderator in /r/Movies
        red.acceptModInvite("Movies");

        //Leaving as moderator in /r/Videos
        red.leaveModeration("Videos");

        red.approve("t3_4jeqzj");

        //remove comment or submission, second parameter: spam= true or false.
        red.remove("t3_4jeqzj", true);

        //Ignore reports from a thing, submission or comment fullId.
        red.ignoreReports("t3_4jeqzj");

        //unignore
        red.unignoreReports("t3_4jeqzj");

        //Distinguish
        red.distinguish("t3_4jeqzj", Distinguish.YES);
        red.distinguish("t3_4jeqzj", Distinguish.ADMIN);
        red.distinguish("t3_4jeqzj", Distinguish.SPECIAL);
        red.distinguish("t3_4jeqzj", Distinguish.NO);

        //Get 100 reported comments in a subreddit you are a moderator of
        red.getModerationReportsComments("Movies", Moderation.REPORTED, 100);

        //Reported 100 Submissions
        red.getModerationReportsSubmissions("Movies", Moderation.REPORTED, 100);

        //Get 100 Spam comments
        red.getModerationReportsComments("Movies", Moderation.SPAM, 100);

        //Get 20 queued moderation Submissions
        red.getModerationReportsSubmissions("Movies", Moderation.QUEUE, 20);

        //Get 50 Unmoderated Submissions
        red.getModerationReportsSubmissions("Movies", Moderation.UNMODERATED, 50);

        //Get Edited comments
        red.getModerationReportsComments("Movies", Moderation.EDITED, 20);


        /**
         * Flair API
         *
         */
        //Clear the Flair templates, second argument should be either ""USER_FLAIR" for user flairs
        // or "LINK_FLAIR" for the link flairs
        red.clearFlairTemplates("flairtestsubreddit", "USER_FLAIR");

        //Set flair to a link, last argument is css_class, it can be left empty if none
        red.linkFlair("Movies", "t3_4jlhec", "GREATEST", "");

        //Set flair to a User, last argument is css_class, it can be left empty if none
        red.userFlair("Movies", "kakunas", "CRAP!!", "");



    }

}
