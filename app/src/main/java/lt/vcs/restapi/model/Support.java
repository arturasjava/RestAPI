package lt.vcs.restapi.model;

import com.google.gson.annotations.SerializedName;

public class Support {
    @SerializedName("url")
    private String url;

    @SerializedName("text")
    private String text;

    @Override
    public String toString() {
        return "Support [url=" + url + ", "
                + "text=" + text + "]";
    }
}
