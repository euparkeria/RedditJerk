package ga.dryco.redditjerk.datamodels;

import com.google.gson.annotations.Expose;

import java.util.List;


public class ModeratorsData {
    @Expose
    private Long date;

    @Expose
    private List<String> mod_permissions;

    @Expose
    private String name;

    @Expose
    private String id;



    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
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


}
