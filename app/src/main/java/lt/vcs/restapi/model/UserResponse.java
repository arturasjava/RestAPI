package lt.vcs.restapi.model;

import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("data")
    private User data;

    @SerializedName("support")
    private Support support;

    // constructor, getters and setters

    public String toString() {
        return "User API response [data=" + data + " , " + support + "]";
    }
}