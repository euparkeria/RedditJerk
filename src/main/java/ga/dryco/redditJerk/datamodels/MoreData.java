package ga.dryco.redditjerk.datamodels;

import com.google.gson.annotations.Expose;

import java.util.List;


public class MoreData {
    @Expose
    private List<String> children;
    @Expose
    private String name;
    @Expose
    private String id;
    @Expose
    private String parent_id;
    @Expose
    private Integer count;


    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


}
