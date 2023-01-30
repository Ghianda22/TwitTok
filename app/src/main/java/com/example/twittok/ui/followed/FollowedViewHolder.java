package com.example.twittok.ui.followed;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twittok.datasource.model.UserModel;
import com.example.twittok.dto.FollowedUserWrapper;

public class FollowedViewHolder extends RecyclerView.ViewHolder {
    // --- ATTRIBUTES ---------------------------------------------------------------------------------



    // --- CONSTRUCTORS ---------------------------------------------------------------------------------
    public FollowedViewHolder(@NonNull View itemView) {
        super(itemView);
    }




    // --- METHODS ---------------------------------------------------------------------------------
    public void updateContent(FollowedUserWrapper userToShow){
        UserModel followedUser = userToShow.getUser();
        String userImage = userToShow.getImage();


    }
}
