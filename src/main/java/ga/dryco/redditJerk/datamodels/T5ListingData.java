package ga.dryco.redditjerk.datamodels;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;


public class T5ListingData extends ListingData{

    /**
     * Listing that will contain Children of type t5
     *
     */
    @Expose
    private List<T5> children = new ArrayList<>();

    public List<T5> getChildren() {
        return children;
    }

    /**
     *
     * @param children
     * The children
     */
    public void setChildren(List<T5> children) {
        this.children = children;
    }



}