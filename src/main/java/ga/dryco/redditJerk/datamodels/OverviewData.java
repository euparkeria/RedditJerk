package ga.dryco.redditJerk.datamodels;


import java.util.List;


public class OverviewData extends ListingData{
    private List<T3> Submissions;
    private List<T1> Comments;

    public List<? extends Thing> getChildren(){
        return Comments;
    }


    public List<T3> getSubmissions() {
        return Submissions;
    }

    public void setSubmissions(List<T3> submissions) {
        Submissions = submissions;
    }

    public List<T1> getComments() {
        return Comments;
    }

    public void setComments(List<T1> comments) {
        Comments = comments;
    }
}
