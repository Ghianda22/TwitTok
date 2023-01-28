package com.example.twittok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;

import com.example.twittok.databinding.ActivityMainBinding;
import com.example.twittok.datasource.network.SidNetworkDataSource;
import com.example.twittok.datasource.network.UserNetworkDataSource;
import com.example.twittok.datasource.network.config.RequestBody;
import com.example.twittok.datasource.model.SidModel;
import com.example.twittok.repositories.SidRepository;

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
//        ConfigNetworkDataSource.callGetProfile(new RequestBody());
//        ConfigNetworkDataSource.callSetProfile(body);
//        ConfigNetworkDataSource.callFollow(body);
//        ConfigNetworkDataSource.callGetTwok(body);
//        SidNetworkDataSource sidNetworkDataSource = new SidNetworkDataSource();
//        sidNetworkDataSource.callRegister();
//        sidNetworkDataSource.setOnResponseReadyListener(sid -> {
//            RequestBody requestBody = new RequestBody();
//            UserNetworkDataSource.callGetProfile(requestBody);
//        });

        //REPOSITORY TEST
        SidRepository sidRepository = new SidRepository();
        if(sidRepository.getSid() == null) {
            sidRepository.setSid(sidResponse -> {
                Log.d(TAG, "onCreate: " + sidResponse.getSid());
                //here do other stuff & calls
            });
        }

        //SHARED PREF TESTING
//        ConfigNetworkDataSource.callRegister(this);
//        SidLocalDataSource sidLocalDataSource = new SidLocalDataSource(this);
//        Log.d(TAG, "onCreate: " + sidLocalDataSource.getSid());

//        Log.d(TAG, "onCreate: " + new SidModel().getSid());
    }

    @Override //implements backstack
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.fragment_nav_container);
        return NavigationUI.navigateUp(navController, appBarConfig)
                || super.onSupportNavigateUp();
    }

}