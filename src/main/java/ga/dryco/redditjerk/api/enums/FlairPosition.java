package ga.dryco.redditjerk.api.enums;


/**
 * Values for flair possition
 */
public enum FlairPosition {
    LEFT("left"),
    RIGHT("right");

    private String position;

    FlairPosition(String position){
        this.position = position;
    }

    @Override
    public String toString(){
        return this.position;
    }
}
