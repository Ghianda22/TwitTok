package com.example.twittok.ui.followed;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.twittok.databinding.FragmentFollowedBinding;
import com.example.twittok.repositories.SidRepository;

import java.util.ArrayList;

public class FollowedFragment extends Fragment {
    // --- ATTRIBUTES ------------------------------------------
    private FollowedViewModel followedViewModel;
    private FragmentFollowedBinding binding;
    private static final String TAG = "FOLLOWED_FRAGMENT";

    // --- CONSTRUCTORS ---------------------------------------------------------------------------------
    public static FollowedFragment newInstance() {
        return new FollowedFragment();
    }




    // --- METHODS ------------------------------------------
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentFollowedBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        followedViewModel = new ViewModelProvider(this).get(FollowedViewModel.class);

        RecyclerView recyclerView = binding.followedListContainer;
        FollowedViewAdapter followedViewAdapter = new FollowedViewAdapter(new ArrayList<>());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if (followedViewModel.isEmpty()) {
            Log.d(TAG, "onViewCreated: followed list is empty");
            followedViewModel.addFollowed();
        }
        followedViewModel.getNoFollowed().observe(
                getViewLifecycleOwner(),
                result -> {
                    binding.noFollowed.setVisibility(View.VISIBLE);
                }
        );

        followedViewModel.getListOfFollowed().observe(
                getViewLifecycleOwner(),
                listOfFollowed -> {
                    Log.d(TAG, "onViewCreated: followed list length " + listOfFollowed.size());
                    binding.spinningWheel.setVisibility(View.GONE);
                    if(listOfFollowed.size() > 0)
                        binding.noFollowed.setVisibility(View.GONE);
                    followedViewAdapter.setFollowedArrayList(listOfFollowed);
                    recyclerView.setAdapter(followedViewAdapter);
                }
        );
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        followedViewModel = null;
    }
}