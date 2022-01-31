package lt.vcs.restapi;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import lt.vcs.restapi.model.User;
import lt.vcs.restapi.model.UserResponse;
import lt.vcs.restapi.model.UsersResponse;
import lt.vcs.restapi.network.UserDataService;
import lt.vcs.restapi.network.UserServiceClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<UserResponse> user;
    private MutableLiveData<List<User>> users;

    public static final String LOG_TAG = "app_test";

    public LiveData<UserResponse> getUser(){
        if (user == null){
            user = new MutableLiveData<UserResponse>();
        }
        return user;
    }

    public LiveData<List<User>> getUsers(){
        if (users == null){
            users = new MutableLiveData<List<User>>();
        }
        return users;
    }

    public void fetchUser() {
        UserDataService service =
                UserServiceClient.getUserInstance().create(UserDataService.class);

        Call<UserResponse> call = service.getUser(2);

        Callback<UserResponse> callback = new Callback<UserResponse>() {
            @Override
            public void onResponse(@NonNull Call<UserResponse> call, Response<UserResponse> response) {
//                Log.i(LOG_TAG, "onResponse: " + response.body());
                user.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<UserResponse> call, @NonNull Throwable t) {
                Log.i(LOG_TAG, "Failed to retrieve data");
                call.cancel();
            }
        };

        call.enqueue(callback);
    }

    public void fetchAllUsers(){
        UserDataService service =
                UserServiceClient.getUserInstance().create(UserDataService.class);

        Call<UsersResponse> call = service.getAllUsers(1,20);

        Callback<UsersResponse> callback = new Callback<UsersResponse>() {
            @Override
            public void onResponse(@NonNull Call<UsersResponse> call, Response<UsersResponse> response) {
                Log.i(LOG_TAG, "GetAllUsers onResponse: " + response.body());
                users.postValue(response.body().getUserData());
            }

            @Override
            public void onFailure(@NonNull Call<UsersResponse> call, Throwable t) {
                Log.i(LOG_TAG, "GetAllUsers FAILED to retrieve data " + t.getMessage());
                call.cancel();
            }
        };

        call.enqueue(callback);
    }
}
