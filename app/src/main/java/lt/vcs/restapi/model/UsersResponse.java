package lt.vcs.restapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersResponse {

    @SerializedName("data")
    private List<User> userData;

    // constructor, getters and setters

    public List<User> getUserData() {
        return userData;
    }

    public void setUserData(List<User> userData) {
        this.userData = userData;
    }

    public String toString() {
        return "Users API response [data=" + userData + "]";
    }
}
