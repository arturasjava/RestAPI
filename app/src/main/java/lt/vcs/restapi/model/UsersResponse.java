package lt.vcs.restapi.model;

import java.util.List;

public class UsersResponse {
    private List<User> data;

    // constructor, getters and setters
//
//    public List<User> getData() {
//        return data;
//    }
//
//    public void setData(List<User> data) {
//        this.data = data;
//    }

    public String toString() {
        return "Users API response [data=" + data + "]";
    }
}
