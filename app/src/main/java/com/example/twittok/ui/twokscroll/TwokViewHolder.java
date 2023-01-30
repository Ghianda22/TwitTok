package com.example.twittok.ui.twokscroll;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
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
    private Button positionButton;
    private static final String TAG = "TWOK_HOLDER";



    public TwokViewHolder(@NonNull View itemView) {
        super(itemView);
        twokContent = itemView.findViewById(R.id.twokContent);
        userName = itemView.findViewById(R.id.userName);
        userPicture = itemView.findViewById(R.id.userPicture);
        followButton = itemView.findViewById(R.id.followButton);
        positionButton = itemView.findViewById(R.id.positionButton);
    }

    public void updateContent(TwokUserWrapper twokData) {
        TwokModel twokToShow = twokData.getTwok();
        Log.d(TAG, "updateContent: the author is followed?" + twokData.isFollowed());
        //extract all twok properties
        //assign to views the twok properties
        twokContent.setText(twokToShow.getText());
        userName.setText(twokToShow.getName());
        userPicture.setImageBitmap(twokData.getImage());
        if(twokToShow.getLat() != null & twokToShow.getLon() != null){
            positionButton.setVisibility(View.VISIBLE);
            positionButton.setOnClickListener(clickedView -> {
                NavDirections action = com.example.twittok.ui.home.HomeFragmentDirections.actionNavDirectionHomeToMapsFragment(
                        twokToShow.getLat().floatValue(),
                        twokToShow.getLon().floatValue(),
                        twokToShow.getName()
                );
                Navigation.findNavController(clickedView).navigate(action);
            });
        }else positionButton.setVisibility(View.GONE);
        // followButton -> callIsFollowed if yes display Unfollow, if no Follow
        // implement the onclick function to block the button after a click and call the right api (Follor or unfollow)
    }
}
