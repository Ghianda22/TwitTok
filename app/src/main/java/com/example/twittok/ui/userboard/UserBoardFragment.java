package com.example.twittok.ui.userboard;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.twittok.R;
import com.example.twittok.databinding.FragmentFollowedBinding;
import com.example.twittok.databinding.FragmentUserBoardBinding;

public class UserBoardFragment extends Fragment {

    private UserBoardViewModel mViewModel;
    private FragmentUserBoardBinding binding;
    public static UserBoardFragment newInstance() {
        return new UserBoardFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentUserBoardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding = FragmentUserBoardBinding.inflate(getLayoutInflater());
        Integer uid = UserBoardFragmentArgs.fromBundle(getArguments()).getSelectedUser();
        Log.d("prova", "onViewCreated: " + "Selected user: " + uid);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UserBoardViewModel.class);
        // TODO: Use the ViewModel
    }

}