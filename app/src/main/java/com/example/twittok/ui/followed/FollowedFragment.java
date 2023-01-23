package com.example.twittok.ui.followed;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.twittok.R;
import com.example.twittok.databinding.FragmentFollowedBinding;
import com.example.twittok.databinding.FragmentHomeBinding;
import com.example.twittok.ui.home.HomeFragmentDirections;

public class FollowedFragment extends Fragment {

    private FollowedViewModel mViewModel;
    private FragmentFollowedBinding binding;

    public static FollowedFragment newInstance() {
        return new FollowedFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentFollowedBinding.inflate(inflater, container, false);


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.button.setOnClickListener(clickedView -> {
            NavDirections action = FollowedFragmentDirections.actionNavDirectionFollowedToUserBoardFragment();
            Navigation.findNavController(clickedView).navigate(action);
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FollowedViewModel.class);
        // TODO: Use the ViewModel
    }

}