package ga.dryco.redditjerk.api.enums;


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
