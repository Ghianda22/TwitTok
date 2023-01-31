package com.example.twittok.ui.followed;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.twittok.dto.FollowedUserWrapper;
import com.example.twittok.repositories.FollowedRepository;
import com.example.twittok.repositories.UserRepository;

import java.util.ArrayList;

public class FollowedViewModel extends ViewModel {

    private static final String TAG = "FRAGMENT_VIEWMODEL";
    private MutableLiveData<ArrayList<FollowedUserWrapper>> listOfFollowed = new MutableLiveData<>(new ArrayList<>());
    private MutableLiveData<Boolean> noFollowed = new MutableLiveData<Boolean>(false);

    public LiveData<ArrayList<FollowedUserWrapper>> getListOfFollowed() {
        return listOfFollowed;
    }

    public LiveData<Boolean> getNoFollowed() {
        return noFollowed;
    }

    // --- METHODS ------------------------------------------
    public void addFollowed() {
//      --> call Followed
        new FollowedRepository().getListOfFollowed(listOfUsers -> {
            if (listOfUsers.size() > 0) {
                Log.d(TAG, "addFollowed: list of follwed = " + listOfUsers);
                listOfUsers.forEach(followedUser -> {
                    Log.d(TAG, "addFollowed: foreach");
//                  --> pass uid to UserRepo and wait for image
                    new UserRepository().checkImageVersion(
                            followedUser.getUid(), followedUser.getPversion(),
                            currentImage -> {
//                              --> create TwokUserWrapper and append it to the list
                                FollowedUserWrapper followedUserWrapper = new FollowedUserWrapper(
                                        followedUser,
                                        currentImage,
                                        uid -> unfollow(uid),
                                        FollowedFragmentDirections.actionNavDirectionFollowedToUserBoardFragment(followedUser.getUid())
                                );

                                append(followedUserWrapper);
                            });
                });
            } else noFollowed.setValue(true);
        });
    }

    public void unfollow(Integer uid) {
        new FollowedRepository().unfollow(uid);
        remove(uid);
    }

    public void append(FollowedUserWrapper newFollowedUser) {
        listOfFollowed.getValue().add(newFollowedUser);
        listOfFollowed.postValue(listOfFollowed.getValue());
    }

    public void remove(Integer uid) {
        listOfFollowed.getValue().removeIf(followedUserWrapper -> followedUserWrapper.getUser().getUid() == uid);
        listOfFollowed.setValue(listOfFollowed.getValue());
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