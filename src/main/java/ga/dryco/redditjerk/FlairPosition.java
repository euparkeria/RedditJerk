package ga.dryco.redditjerk;

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
