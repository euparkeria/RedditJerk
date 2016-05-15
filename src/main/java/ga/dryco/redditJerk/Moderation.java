package ga.dryco.redditJerk;

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
