package lt.vcs.restapi;

import static lt.vcs.restapi.MainActivityViewModel.LOG_TAG;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import lt.vcs.restapi.model.User;
import lt.vcs.restapi.model.UserResponse;
import lt.vcs.restapi.repository.RemoteRepository;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel viewModel = null;
    RecyclerView recyclerView;
    List<User> list = Collections.emptyList();
//    UsersAdapter usersAdapter;

    RecyclerView.OnScrollListener scrollListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        viewModel.fetchUser();
        viewModel.fetchAllUsers();

//        RemoteRepository remoteRepository = new RemoteRepository();
//        remoteRepository.getUser();
//        remoteRepository.getAllUsers();

        viewModel.getUser().observe(this, new Observer<UserResponse>() {
                    @Override
                    public void onChanged(UserResponse userResponse) {
                        Log.i(LOG_TAG, "Activity onResponse: " + userResponse);
                    }
                }
        );

        viewModel.getUsers().observe(this, new Observer<List<User>>() {
                    @Override
                    public void onChanged(List<User> users) {
                        Log.i(LOG_TAG, "Activity onResponse: " + users);
                        list = users;
//                        usersAdapter.addList(list);
                    }
                }
        );
    }
}