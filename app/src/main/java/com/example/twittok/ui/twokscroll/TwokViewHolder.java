package com.example.twittok.ui.twokscroll;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twittok.R;
import com.example.twittok.datasource.model.TwokModel;
import com.example.twittok.dto.TwokUserWrapper;

public class TwokViewHolder extends RecyclerView.ViewHolder {

    //create here all views to be updated in twok_item
    private TextView twokContent;
    private TextView userName;
    private ImageView userPicture;
    private Button followButton;
    private static final String TAG = "TWOK_HOLDER";



    public TwokViewHolder(@NonNull View itemView) {
        super(itemView);
        twokContent = itemView.findViewById(R.id.twokContent);
        userName = itemView.findViewById(R.id.userName);
        userPicture = itemView.findViewById(R.id.userPicture);
        followButton = itemView.findViewById(R.id.followButton);
    }

    public void updateContent(TwokUserWrapper twokData) {
        TwokModel twokToShow = twokData.getTwok();
        Log.d(TAG, "updateContent: the author is followed?" + twokData.isFollowed());
        //extract all twok properties
        //assign to views the twok properties
        twokContent.setText(twokToShow.getText());
        userName.setText(twokToShow.getName());
        userPicture.setImageBitmap(twokData.getImage());
        // followButton -> callIsFollowed if yes display Unfollow, if no Follow
        // implement the onclick function to block the button after a click and call the right api (Follor or unfollow)
    }
}
