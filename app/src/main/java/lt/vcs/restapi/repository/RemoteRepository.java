package lt.vcs.restapi.repository;

import android.util.Log;

import androidx.annotation.NonNull;

import lt.vcs.restapi.model.UserResponse;
import lt.vcs.restapi.network.UserDataService;
import lt.vcs.restapi.network.UserServiceClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteRepository {
    public static final String LOG_TAG = "app_test";

    public void getUser() {
        UserDataService service =
                UserServiceClient.getUserInstance().create(UserDataService.class);

        Call<UserResponse> call = service.getUser(2);

        Callback<UserResponse> callback = new Callback<UserResponse>() {
            @Override
            public void onResponse(@NonNull Call<UserResponse> call, Response<UserResponse> response) {
                Log.i(LOG_TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(@NonNull Call<UserResponse> call, @NonNull Throwable t) {
                Log.i(LOG_TAG, "Failed to retrieve data " + t.getMessage());
                call.cancel();
            }
        };

        call.enqueue(callback);
    }

}
