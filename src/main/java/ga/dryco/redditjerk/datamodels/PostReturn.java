package ga.dryco.redditjerk.datamodels;

/**
 * Data class for the JSON returned when POSTing a reply or Link, the deserializer takes care of what to put where
 */
public class PostReturn {

    private T1 comment;
    private T3 link;
    private String kind;
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }



    public T3 getLink() {
        return link;
    }

    public void setLink(T3 link) {
        this.link = link;
    }

    public T1 getComment() {
        return comment;
    }

    public void setComment(T1 comment) {
        this.comment = comment;
    }


}
