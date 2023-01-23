package com.example.twittok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.twittok.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AppBarConfiguration appBarConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavController navController = Navigation.findNavController(this, R.id.fragment_nav_container);
        appBarConfig = new AppBarConfiguration.Builder(R.id.nav_direction_followed, R.id.nav_direction_newtwok, R.id.nav_direction_home, R.id.nav_direction_profile).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfig);
        NavigationUI.setupWithNavController(binding.bottomNavView, navController);


    }

    @Override //implements backstack
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.fragment_nav_container);
        return NavigationUI.navigateUp(navController, appBarConfig)
                || super.onSupportNavigateUp();
    }
}