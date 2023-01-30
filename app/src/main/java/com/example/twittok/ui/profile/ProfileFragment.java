package com.example.twittok.ui.profile;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.twittok.R;
import com.example.twittok.databinding.FragmentProfileBinding;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private FragmentProfileBinding binding;
    private static final String TAG = "PROFILE_FRAGMENT";

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        profileViewModel.getProfileName().observe(getViewLifecycleOwner(), binding.username::setText);
        profileViewModel.getProfilePicture().observe(getViewLifecycleOwner(), binding.userPicture::setImageBitmap);

        profileViewModel.showProfile();


        // --- CHANGE PICTURE ------------------------------------------------------------------------
        ActivityResultLauncher<Intent> launchSomeActivity = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        // do your operation from here....
                        if (data != null && data.getData() != null) {
                            Uri selectedImageUri = data.getData();
                            Bitmap selectedImageBitmap = null;
                            try {
                                selectedImageBitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), selectedImageUri);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            profileViewModel.changeProfilePicture(selectedImageBitmap);
                    }
                }
        });
        binding.userPicture.setOnClickListener(
                onClick -> {
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    launchSomeActivity.launch(intent);
                }
        );



        // --- CHANGE NAME ------------------------------------------------------------------------
        binding.username.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                profileViewModel.changeProfileName(editable.toString());
            }
        });


    }

}