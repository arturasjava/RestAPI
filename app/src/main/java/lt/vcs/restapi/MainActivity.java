package lt.vcs.restapi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import lt.vcs.restapi.repository.RemoteRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RemoteRepository remoteRepository = new RemoteRepository();
        remoteRepository.getUser();
//        remoteRepository.getAllUsers();
    }
}