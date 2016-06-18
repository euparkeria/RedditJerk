package ga.dryco.redditjerk.api.enums;

/**
 * Post sorting values
 *
 */
public enum Sorting {

    NEW("new"),
    TOP("top"),
    HOT("hot"),
    CONTROVERSIAL("controversial"),
    RISING("rising");

    private String sortingString;

    Sorting(String sortingString){
        this.sortingString = sortingString;
    }

     @Override
     public final String toString(){
         return this.sortingString;
     }
}
