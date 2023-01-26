package com.example.twittok;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;

import com.example.twittok.databinding.ActivityMainBinding;
import com.example.twittok.datasource.NetworkDataSource;
import com.example.twittok.datasource.RequestBody;
import com.example.twittok.datasource.SidLocalDataSource;
import com.example.twittok.repositories.SidRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AppBarConfiguration appBarConfig;
    private final String TAG = "MAIN_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //NAVIGATION SETUP
        NavController navController = Navigation.findNavController(this, R.id.fragment_nav_container);
        appBarConfig = new AppBarConfiguration.Builder(R.id.nav_direction_followed, R.id.nav_direction_newtwok, R.id.nav_direction_home, R.id.nav_direction_profile).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfig);
        NavigationUI.setupWithNavController(binding.bottomNavView, navController);


        //RETROFIT TESTING
//        RequestBody body = new RequestBody(513802);
//        NetworkDataSource.callGetProfile(new RequestBody());
//        NetworkDataSource.callSetProfile(body);
//        NetworkDataSource.callFollow(body);
//        NetworkDataSource.callGetTwok(body);

        //SHARED PREF TESTING
//        NetworkDataSource.callRegister(this);
//        SidLocalDataSource sidLocalDataSource = new SidLocalDataSource(this);
//        Log.d(TAG, "onCreate: " + sidLocalDataSource.getSid());
    }

    @Override //implements backstack
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.fragment_nav_container);
        return NavigationUI.navigateUp(navController, appBarConfig)
                || super.onSupportNavigateUp();
    }
}