# RedditJerk

RedditJerk is a Reddit API wrapper for java.  It's aim is to make it 
as simple as possible to use and implement many high level utility methods usually not included in Api libraries.

######Still in development!

###Example Usage:


```Java
  //Getting the api instance with useragent as parameter:

        Reddit red = RedditApi.getRedditInstance("Reddit client test v1313");

        //OAuth login, returns User object of the logged in account
        User myUser = red.login("RedditJerkTest", "jerkjerkjerk", "WoXLiKdjulE09Q", "QoG2unmpgAum-IQ92NDhhNy-UKs");

        //getting a redditor object
        User jerkUser = red.getUser("reditor123");

        //getting user comments, gets 200 newest comments
        List<Comment> clist = jerkUser.getComments(200, "new");

        //getting user's top 100 submissions
        List<Link> slist = jerkUser.getSubmitted(100,"top");

        //Getting user's Karma Balance in a moronic subreddit for his last 200 comments
        Integer karmaBalance = jerkUser.getKarmaBalance("MensRights", 200);

        //Getting a Subreddit object of a subreddit
        Subreddit amSubr = red.getSubreddit("ShitAmericansSay");
        //and getting it's front page
        List<Link> amlinkList = amSubr.getHot(25);

        //Replying to a submittion

        RedditThread post = red.getRedditThread("https://www.reddit.com/r/Economics/comments/46lkfz/can_sanders_do_it_is_it_plausible_that_there/d06k38f");

        Link subm = post.getSubmissionPost().getData();
        Comment myComment2 = subm.reply("South Park is Awesome!! :P");
        //Editing our comment
        myComment2.edit("South Park is SUPER Awesome!! :PPP");

        //upvoting the submission
        subm.upvote();
        //hiding the submission
        subm.hide();


        //Reaplying to first comment in the thread, myComment is the object of the comment you just posted.
        Comment firstComment = post.getFlatComments().get(0);
        Comment myComment1 = firstComment.reply("Hello!");
        //we can immidately delete our new comment
        myComment1.delete();

        //Submitting a new self post in subreddit TheRedPill that is bound to be upvoted and gilded
        red.Submit("TheRedPill", "DAE thinks women's job should be to please and serve men !?", "Anyone ? ", "self");

        //get top 5 submittions of the week in /r/learnprogramming
        List<Link> learnPrgrTop = red.getSubredditPage("learnprogramming", 5, "top", "week");
        //getting /r/learnprogramming's moderators
        List<User> learnPrgMods = red.getSubredditModerators("learnprogramming");

        //printing their usernames
        for(User modusr: learnPrgMods){
            System.out.println(modusr.getName());
        }

//Much much more to come...
 ```
