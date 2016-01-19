# RedditJerk

RedditJerk is a Reddit API wrapper for java.  It's aim is to make it 
as simple as possible to use and implement many high level utility methods usually not included in Api libraries.

######Still in development!

###Example Usage:


```Java
 //Getting the api instance with useragent as parameter:
 Reddit red = RedditApi.getRedditApiInstance("Reddit client test v1313");
 
 //OAuth login, returns User object of the logged in account
 User myUser = red.login("BotUsername", "BotPassword", "AppId", "AppSecret");
 
 //getting a redditor object
 User jerkUser = red.getUser("reditor123");
 
 //getting user comments, gets 200 newest comments 
 List<Comment> clist = jerkUser.getComments(200,"new");
 
 //getting user's top 100 submissions
 List<Link> slist = jerkUser.getSubmitted(100,"top");
 
 //Getting user's Karma Balance in a moronic subreddit for his last 200 comments
 Integer karmaBalance = jerkUser.getKarmaBalance("MensRights", 200)
 
 //Getting a Subreddit object of a (cool) subreddit
 Subreddit amSubr = red.getSubreddit("ShitAmericansSay");
 //and getting it's front page
 List<Link> amlinkList = amSubr.getHot(25);
 


//Replying to  a submittion
ThreadPost post = red.getThread("https://www.reddit.com/r/southpark/comments/3guton/happy_birthday/");
Link subm = post.getSubmissionPost().getData();
Comment myComment = subm.reply("South Park is Awesome!! :P");
//Editing our comment
myComment.edit("South Park is SUPER Awesome!! :PPP");

//upvoting the submission
subm.upvote();
//hiding the submission
subm.hide();


//Reaplying to first comment in the thread, myComment is the object of the comment you just posted.
Comment firstComment = post.getFlatComments().get(0);
Comment myComment = firstComment.reply("Hello!");
//we can immidately delete our new comment
myComment.delete();

//Submitting a new self post in subreddit TheRedPill that is bound to be upvoted and gilded
red.Submit("TheRedPill", "DAE thinks women's job should be to please and serve men !?", "Anyone ? ", "self");


//Getting a thread and listing the usernames of all commentors in it:
 
 ThreadPost post = red.getThread("https://www.reddit.com/r/ShitAmericansSay/comments/3g5wf3/i_dont_care_how_many_people_die_every_second/");
  for(Comment comm:post.getFlatComments()){
    if(comm.getAuthor() != null){
        System.out.println(comm.getAuthor());
    }

}

//Much much more to come...
 ```
