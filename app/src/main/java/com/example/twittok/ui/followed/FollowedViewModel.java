package com.example.twittok.ui.followed;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.twittok.dto.FollowedUserWrapper;

import java.util.ArrayList;

public class FollowedViewModel extends ViewModel {

    private static final String TAG = "HOME_VIEWMODEL";
    private MutableLiveData<ArrayList<FollowedUserWrapper>> listOfFollowed = new MutableLiveData<>(new ArrayList<>());

    public LiveData<ArrayList<FollowedUserWrapper>> getListOfFollowed() {
        return listOfFollowed;
    }


    // --- METHODS ------------------------------------------
    public void addFollowed() {
        /* in here prepare the wrapped object
        --> call Followed
        --> pass uid to UserRepo and wait for image
        --> create TwokUserWrapper and append it to the list
        */
    }

    public void append(FollowedUserWrapper newTwok) {
        listOfFollowed.getValue().add(newTwok);
        listOfFollowed.postValue(listOfFollowed.getValue());
    }

    public boolean isEmpty() {
        if (listOfFollowed == null) return true;
        else if (listOfFollowed.getValue() == null) return true;
        else return listOfFollowed.getValue().isEmpty();
    }

    public int getSize() {
        return listOfFollowed.getValue().size();
    }

}