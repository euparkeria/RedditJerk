package ga.dryco.redditjerk.datamodels;


import com.google.gson.annotations.Expose;


public abstract class Thing<T> {

    @Expose
    private String kind;
    @Expose
    private T data;

    /**
     *
     * @return
     * The kind
     */
    public String getKind() {
        return kind;
    }

    /**
     *
     * @param kind
     * The kind
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     *
     * @return
     * The data
     */
    public T getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(T data) {
        this.data = data;
    }

}