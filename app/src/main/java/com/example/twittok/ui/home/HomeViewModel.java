package com.example.twittok.ui.home;

import android.graphics.Bitmap;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.twittok.datasource.model.TwokModel;
import com.example.twittok.utils.wrapper.TwokUserWrapper;
import com.example.twittok.repositories.FollowedRepository;
import com.example.twittok.repositories.TwokRepository;
import com.example.twittok.repositories.UserRepository;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<ArrayList<TwokUserWrapper>> twokArrayList = new MutableLiveData<>(new ArrayList<>());
    private static final String TAG = "HOME_VIEWMODEL";

    public LiveData<ArrayList<TwokUserWrapper>> getTwokArrayList() {
        return twokArrayList;
    }


    public void addTwok() {
        /* in here prepare the wrapped object
        --> call Twok
        --> pass uid to UserRepo and wait for image
        --> pass uid to FollowedRepo and wait for result
        --> create TwokUserWrapper and append it to the list
        */
        TwokUserWrapper twokUserWrapper = new TwokUserWrapper();
        new TwokRepository().loadTwok(twokResponse -> {
            twokUserWrapper.setTwok(twokResponse);
            new UserRepository().checkImageVersion(
                    twokResponse.getUid(), twokResponse.getPversion(),
                    updatedImage -> twokUserWrapper.setImage(updatedImage));
            new FollowedRepository().checkIfFollowed(
                    twokResponse.getUid(),
                    isFollowed -> twokUserWrapper.setFollowed(isFollowed.getFollowed()));
            append(twokUserWrapper);
        });
    }

    public void append(TwokUserWrapper newTwok) {
        twokArrayList.getValue().add(newTwok);
        twokArrayList.postValue(twokArrayList.getValue());
    }

    public boolean isEmpty() {
        if (twokArrayList == null) return true;
        else if (twokArrayList.getValue() == null) return true;
        else return twokArrayList.getValue().isEmpty();
    }

    public int getSize() {
        return twokArrayList.getValue().size();
    }

    @Override
    public String toString() {
        return "\nHomeViewModel{" +
                "\n    twokArrayList=\n      " + twokArrayList.getValue() +
                "\n}";
    }
}