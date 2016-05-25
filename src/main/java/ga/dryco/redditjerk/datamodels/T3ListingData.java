package ga.dryco.redditjerk.datamodels;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;


public class T3ListingData extends ListingData{

    /**
     * Listing that will contain Children of type t3
     *
     */
    @Expose
    private List<T3> children = new ArrayList<>();

    public List<T3> getChildren() {
        return children;
    }

    /**
     *
     * @param children
     * The children
     */
    public void setChildren(List<T3> children) {
        this.children = children;
    }



}