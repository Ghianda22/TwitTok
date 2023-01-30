package com.example.twittok.ui.profile;

import android.content.DialogInterface;
import android.graphics.Bitmap;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.twittok.datasource.ContextSupplier;
import com.example.twittok.repositories.ProfileRepository;
import com.example.twittok.utils.converter.ImageConverter;

public class ProfileViewModel extends ViewModel {
    // --- ATTRIBUTES ------------------------------------------------------------------------------
    private MutableLiveData<String> profileName = new MutableLiveData<>();
    private MutableLiveData<Bitmap> profilePicture = new MutableLiveData<>();


    // --- GETTERS AND SETTERS ---------------------------------------------------------------------
    public MutableLiveData<String> getProfileName() {
        return profileName;
    }
    public void setProfileName(MutableLiveData<String> profileName) {
        this.profileName = profileName;
    }
    public MutableLiveData<Bitmap> getProfilePicture() {
        return profilePicture;
    }
    public void setProfilePicture(MutableLiveData<Bitmap> profilePicture) {
        this.profilePicture = profilePicture;
    }


    // --- METHODS ---------------------------------------------------------------------------------
    public void showProfile() {
        new ProfileRepository().getProfile(profileResponse -> {
            profileName.setValue(profileResponse.getName());
            profilePicture.setValue(ImageConverter.convertImageToBitmap(profileResponse.getPicture()));
        });
    }

    public void changeProfileName(String newName){
        if(newName.length() < 20)
            new ProfileRepository().setProfile(newName, null);
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(ContextSupplier.getContext());
            builder.setTitle("Name has to be shorter than 20 characters");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {}
            });
        }
    }
    public void changeProfilePicture(Bitmap image){
        String base64Image = ImageConverter.convertImageToBase64(image);
        if(base64Image.length() < 137.000)
            new ProfileRepository().setProfile(null, base64Image);
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(ContextSupplier.getContext());
            builder.setTitle("Picture has to be lighter than 100KB");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {}
            });
        }
    }
}