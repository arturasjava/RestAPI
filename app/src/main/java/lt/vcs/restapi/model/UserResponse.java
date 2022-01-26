package lt.vcs.restapi.model;

public class UserResponse {
    private User data;
    private Support support;

    // constructor, getters and setters

    public String toString() {
        return "User API response [data=" + data + " , " + support + "]";
    }
}