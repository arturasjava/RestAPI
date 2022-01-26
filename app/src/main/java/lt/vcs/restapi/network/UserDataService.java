package lt.vcs.restapi.network;

import lt.vcs.restapi.model.UserResponse;
import lt.vcs.restapi.model.UsersResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserDataService {
    @GET("/api/users/{id}")
    Call<UserResponse> getUser(@Path("id") long id);

    @GET("/api/users")
    Call<UsersResponse> getAllUsers(
            @Query(value = "page") int page,
            @Query(value = "per_page") int per_page
    );
}
