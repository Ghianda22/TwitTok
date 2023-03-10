package com.example.twittok.ui.home;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.twittok.databinding.FragmentHomeBinding;
import com.example.twittok.repositories.SidRepository;
import com.example.twittok.repositories.TwokRepository;
import com.example.twittok.ui.twokscroll.TwokViewAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private boolean firstTime;
    private static final String TAG = "HOME_FRAGMENT";
    private final int bufferSize = 5;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        // --- VIEW PAGER SETUP --------------------------------------------------------------------
        ViewPager2 viewPager = binding.twokListContainer;
        TwokViewAdapter twokViewAdapter = new TwokViewAdapter(new ArrayList<>());
        viewPager.setAdapter(twokViewAdapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(viewPager.getCurrentItem() > homeViewModel.getSize() - bufferSize) {
                    homeViewModel.addTwok();
                    Log.d(TAG, "onPageSelected: ero vicino alla fine");
                }
            }
        });

        // --- VIEW PAGER UPDATE --------------------------------------------------------------------
        firstTime = true;
        Log.d(TAG, "onViewCreated: viewmodel = " + homeViewModel);
        Log.d(TAG, "onViewCreated: viewmodel is empty? " + homeViewModel.isEmpty());
        if (homeViewModel.isEmpty()) {
//          only in the first screen to be loaded
//          --> check the sid presence
            if(SidRepository.getSid() == null) {
                Log.d(TAG, "onViewCreated: sid == null");
                SidRepository.setSid(sidResponse -> {
                    Log.d(TAG, "addTwok: " + sidResponse.getSid());
                    homeViewModel.addTwok();
                });
            }else {
                Log.d(TAG, "onViewCreated: sid != null");
                homeViewModel.addTwok();
            }
        }

        homeViewModel.getTwokArrayList().observe(
                getViewLifecycleOwner(),
                twokArrayList -> {
                    Log.d(TAG, "onViewCreated: array length " + twokArrayList.size());
                    if (firstTime && twokArrayList.size() > 0) {
                        binding.spinningWheel.setVisibility(View.GONE);
                        twokViewAdapter.setTwokArrayList(twokArrayList);
                        viewPager.setAdapter(twokViewAdapter);
                        firstTime = false;
                    }
                    if (twokArrayList.size() > 0 && twokArrayList.size() < bufferSize) {
                        homeViewModel.addTwok();
                    }
                    twokViewAdapter.notifyDataSetChanged();
                }
        );
    }

}