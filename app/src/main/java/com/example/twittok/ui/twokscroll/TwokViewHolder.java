package com.example.twittok.ui.twokscroll;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twittok.R;
import com.example.twittok.datasource.ContextSupplier;
import com.example.twittok.datasource.model.TwokModel;
import com.example.twittok.dto.TwokUserWrapper;
import com.example.twittok.ui.home.HomeFragmentDirections;

public class TwokViewHolder extends RecyclerView.ViewHolder {

    // --- ATTRIBUTES ----------------------------------------------------------------------------

    private TextView twokContent;
    private TextView userName;
    private ImageView userPicture;
    private Button followButton;
    private Button positionButton;
    private ConstraintLayout userContainer;
    private static final String TAG = "TWOK_HOLDER";


    public TwokViewHolder(@NonNull View itemView) {
        super(itemView);
        twokContent = itemView.findViewById(R.id.twokContent);
        userName = itemView.findViewById(R.id.userName);
        userPicture = itemView.findViewById(R.id.userPicture);
        followButton = itemView.findViewById(R.id.followButton);
        positionButton = itemView.findViewById(R.id.positionButton);
        userContainer = itemView.findViewById(R.id.userContainer);
    }

    public void updateContent(TwokUserWrapper twokToShowData) {
        TwokModel twokToShow = twokToShowData.getTwok();

        // --- POSITION ----------------------------------------------------------------------------
        if (isValidGeoData(twokToShow.getLat(), twokToShow.getLon())) {
            positionButton.setVisibility(View.VISIBLE);
            positionButton.setOnClickListener(clickedView -> {
                NavDirections action = com.example.twittok.ui.home.HomeFragmentDirections.actionNavDirectionHomeToMapsFragment(
                        twokToShow.getLat().floatValue(),
                        twokToShow.getLon().floatValue(),
                        twokToShow.getName()
                );
                Navigation.findNavController(clickedView).navigate(action);
            });
        } else positionButton.setVisibility(View.GONE);

        // --- NAVIGATE TO USER BOARD --------------------------------------------------------------
        userContainer.setOnClickListener(clickedView -> {
            NavDirections action = HomeFragmentDirections.actionNavDirectionHomeToUserBoardFragment(twokToShow.getUid());
            Navigation.findNavController(clickedView).navigate(action);
        });


        // --- FOLLOW ------------------------------------------------------------------------------
        styleFollowButton(twokToShowData.isFollowed());
        followButton.setOnClickListener(view -> {
            view.setClickable(false);
            styleFollowButton(!twokToShowData.isFollowed());
            twokToShowData.getOnFollowToggleClickListener().onFollowToggleClick(twokToShow.getUid());
        });

// --- TWOK CONTENT --------------------------------------------------------------------------------
        // --- TWOK PICTURE ------------------------------------------------------------------------
        userPicture.setImageBitmap(twokToShowData.getImage());

        // --- TWOK NAME ---------------------------------------------------------------------------
        userName.setText(twokToShow.getName());

        // --- TWOK TEXT ---------------------------------------------------------------------------
        twokContent.setText(twokToShow.getText());

        // --- TWOK BGCOL --------------------------------------------------------------------------
        try {
            twokContent.setBackgroundColor(Color.parseColor("#" + twokToShow.getBgcol()));
        } catch (IllegalArgumentException e) {
            try {
                twokContent.setBackgroundColor(Color.parseColor(twokToShow.getBgcol()));
            } catch (IllegalArgumentException | StringIndexOutOfBoundsException ex) {
                Log.d("backgroundTest", "Color for BACKGROUND not applied: " + ex.getLocalizedMessage());
            }
        }

        // --- TWOK FONTCOL ------------------------------------------------------------------------
        try {
            twokContent.setBackgroundColor(Color.parseColor("#" + twokToShow.getFontcol()));
        } catch (IllegalArgumentException e) {
            try {
                twokContent.setBackgroundColor(Color.parseColor(twokToShow.getFontcol()));
            } catch (IllegalArgumentException | StringIndexOutOfBoundsException ex) {
                Log.d("fontcolTest", "Color for FONT not applied: " + ex.getLocalizedMessage());
            }
        }

        // --- TWOK FONTSIZE -----------------------------------------------------------------------
        switch (twokToShow.getFontsize()) {
            case 1:
                twokContent.setTextSize(48);
                break;
            case 2:
                twokContent.setTextSize(60);
                break;
            default:
                twokContent.setTextSize(34);
                break;
        }

        // --- TWOK FONTTYPE -----------------------------------------------------------------------
        switch (twokToShow.getFonttype()) {
            case 1:
                twokContent.setTypeface(Typeface.MONOSPACE);
                break;
            case 2:
                twokContent.setTypeface(Typeface.SERIF);
                break;
            default:
                twokContent.setTypeface(Typeface.DEFAULT);
                break;
        }

        // --- TWOK HALIGN -------------------------------------------------------------------------
        switch (twokToShow.getHalign()) {
            case 0:
                twokContent.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                break;
            case 2:
                twokContent.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                break;
            default:
                twokContent.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                break;
        }

        // --- TWOK VALIGN -------------------------------------------------------------------------
        switch (twokToShow.getValign()) {
            case 0:
                twokContent.setGravity(Gravity.TOP);
                break;
            case 2:
                twokContent.setGravity(Gravity.BOTTOM);
                break;
            default:
                twokContent.setGravity(Gravity.CENTER_VERTICAL);
                break;
        }
    }

    public boolean isValidGeoData(Double lat, Double lon) {
        if (lat == null || lon == null) return false;
        if (lat < -90 || lat > 90) return false;
        if (lon < -180 || lon > 180) return false;
        return true;
    }

    public void styleFollowButton(boolean isFollowed){
        if(isFollowed){
            followButton.setText(R.string.button_unfollow_text);
            followButton.setBackgroundTintList(ColorStateList.valueOf(ContextSupplier.getContext().getColor((R.color.grey))));
        }else{
            followButton.setBackgroundTintList(ColorStateList.valueOf(ContextSupplier.getContext().getColor((R.color.purple))));
            followButton.setText(R.string.button_follow_text);
        }
    }
}
