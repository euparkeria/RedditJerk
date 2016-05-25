package ga.dryco.redditjerk.datamodels;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;


public class T1ListingData extends ListingData {

    /**
     * Listing that will contain Children of type "t1" and type "more"
     *
     */
    @Expose
    private List<T1> children = new ArrayList<>();

    private List<More> moreChildren = new ArrayList<>();


    public List<T1> getChildren() {
        return children;
    }

    public void setChildren(List<T1> children) {
        this.children = children;
    }

    public List<More> getMoreChildren() {
        return moreChildren;
    }

    public void setMoreChildren(List<More> moreChildren) {
        this.moreChildren = moreChildren;
    }


}