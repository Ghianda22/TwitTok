package com.example.twittok.ui.followed;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twittok.R;
import com.example.twittok.datasource.model.UserModel;
import com.example.twittok.dto.FollowedUserWrapper;

public class FollowedViewHolder extends RecyclerView.ViewHolder {
    // --- ATTRIBUTES ---------------------------------------------------------------------------------
    private Button followButton;
    private TextView userName;
    private ImageView userPicture;


    // --- CONSTRUCTORS ---------------------------------------------------------------------------------
    public FollowedViewHolder(@NonNull View itemView) {
        super(itemView);
        followButton = itemView.findViewById(R.id.followButton);
        userName = itemView.findViewById(R.id.userName);
        userPicture = itemView.findViewById(R.id.userPicture);
    }




    // --- METHODS ---------------------------------------------------------------------------------
    public void updateContent(FollowedUserWrapper userToShow){
        UserModel followedUser = userToShow.getUser();

        userName.setText(followedUser.getName());
        userPicture.setImageBitmap(userToShow.getImage());

        followButton.setOnClickListener(clickedView ->
                userToShow.getOnFollowToggleClickListener().onFollowToggleClick(followedUser.getUid())
        );

    }
}
