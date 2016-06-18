package ga.dryco.redditjerk.api.enums;


/**
 *
 * Moderation page values
 */
public enum Moderation {
    REPORTED("reports"),
    SPAM("spam"),
    QUEUE("modqueue"),
    EDITED("edited"),
    UNMODERATED("unmoderated");


    private String mod_list;

    Moderation(String mod_list){
        this.mod_list = mod_list;
    }

    @Override
    public String toString(){
        return this.mod_list;
    }
}
