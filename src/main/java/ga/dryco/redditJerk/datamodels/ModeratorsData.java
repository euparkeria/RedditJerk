package ga.dryco.redditJerk.datamodels;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by mekoneko on 10/17/2015.
 */
public class ModeratorsData {

    public Double getDate() {
        return date;
    }

    public void setDate(Double date) {
        this.date = date;
    }

    public List<String> getMod_permissions() {
        return mod_permissions;
    }

    public void setMod_permissions(List<String> mod_permissions) {
        this.mod_permissions = mod_permissions;
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

    @Expose
    private Double date;

    @Expose
    private List<String> mod_permissions;

    @Expose
    private String name;

    @Expose
    private String id;
}
