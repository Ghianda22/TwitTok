package com.example.twittok.ui.profile;

import androidx.lifecycle.ViewModelProvider;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.twittok.R;
import com.example.twittok.databinding.FragmentHomeBinding;
import com.example.twittok.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private ProfileViewModel mViewModel;
    private static final String TAG = "PROFILE_FRAGMENT";
    private FragmentProfileBinding binding;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        mViewModel.getUserProfile().observe(getViewLifecycleOwner(), userProfile -> {
            binding.userName.setText(userProfile.getName());
            if(userProfile.getPicture() != null && userProfile.checkPicture()){
                binding.userImage.setImageBitmap(userProfile.baseToBitmap());
            }
        });
    }

}