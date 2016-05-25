package ga.dryco.redditjerk;

/**
 * Created by madcat on 15/05/2016.
 */
public enum  Distinguish {
    YES("yes"),
    NO("no"),
    ADMIN("admin"),
    SPECIAL("special");

    private String distinguish;

    Distinguish(String distinguish){
        this.distinguish = distinguish;
    }

    public String toString(){
        return this.distinguish;
    }

}
