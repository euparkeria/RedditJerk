package ga.dryco.redditjerk.api.enums;


/**
 * Timespan values for posts
 *
 */
public enum FromPast {
    HOUR("hour"),
    DAY("day"),
    WEEK("week"),
    MONTH("month"),
    YEAR("year"),
    ALL_TIME("all");

    private String fromPastString;

    FromPast(String fromPastString){
        this.fromPastString = fromPastString;
    }

    @Override
    public final String toString(){
        return this.fromPastString;
    }
}
