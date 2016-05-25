package ga.dryco.redditjerk.datamodels;


import com.google.gson.annotations.Expose;

public class JsonError {

    @Expose
    private Integer error;

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

}
