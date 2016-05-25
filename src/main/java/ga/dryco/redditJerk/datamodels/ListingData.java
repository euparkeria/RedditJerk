package ga.dryco.redditjerk.datamodels;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

import java.util.List;

@Generated("org.jsonschema2pojo")
public abstract class ListingData {

    @Expose
    private String modhash;
    /**
     * This class at first used generics to decide the Children type but the nested generics were getting to
     * confusing so now it is subclassed for every type of Children
     *
     */

    @Expose
    private String after;
    @Expose
    private String before;

    public abstract List<? extends Thing> getChildren();

    /**
     *
     * @return
     * The modhash
     */
    public String getModhash() {
        return modhash;
    }

    /**
     *
     * @param modhash
     * The modhash
     */
    public void setModhash(String modhash) {
        this.modhash = modhash;
    }

    /**
     *
     * @return
     * The after
     */
    public String getAfter() {
        return after;
    }

    /**
     *
     * @param after
     * The after
     */
    public void setAfter(String after) {
        this.after = after;
    }

    /**
     *
     * @return
     * The before
     */
    public String getBefore() {
        return before;
    }

    /**
     *
     * @param before
     * The before
     */
    public void setBefore(String before) {
        this.before = before;
    }

}