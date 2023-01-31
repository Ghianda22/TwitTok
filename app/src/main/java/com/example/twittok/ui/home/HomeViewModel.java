package com.example.twittok.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavDirections;

import com.example.twittok.dto.TwokUserWrapper;
import com.example.twittok.repositories.FollowedRepository;
import com.example.twittok.repositories.TwokRepository;
import com.example.twittok.repositories.UserRepository;
import com.example.twittok.ui.userboard.UserBoardFragmentDirections;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<ArrayList<TwokUserWrapper>> twokArrayList = new MutableLiveData<>(new ArrayList<>());
    private static final String TAG = "HOME_VIEWMODEL";

    public LiveData<ArrayList<TwokUserWrapper>> getTwokArrayList() {
        return twokArrayList;
    }


    public void addTwok() {
        new TwokRepository().loadTwok(twokResponse -> {
//            --> pass uid to UserRepo and wait for image
            new UserRepository().checkImageVersion(
                    twokResponse.getUid(), twokResponse.getPversion(),
                    updatedImage -> {
//                        --> pass uid to FollowedRepo and wait for result
                        new FollowedRepository().checkIfFollowed(
                                twokResponse.getUid(),
                                isFollowed -> {
//                                    --> set TwokUserWrapper and append it to the list
                                    TwokUserWrapper twokUserWrapper = new TwokUserWrapper(
                                            twokResponse,
                                            updatedImage,
                                            isFollowed.getFollowed(),
                                            uid -> followToggle(uid, isFollowed.getFollowed())
                                    );

                                    // navigation problem handler
                                    if(twokResponse.getLat() != null){
                                        NavDirections action = HomeFragmentDirections.actionNavDirectionHomeToMapsFragment(
                                                twokResponse.getLat().floatValue(),
                                                twokResponse.getLon().floatValue(),
                                                twokResponse.getName()
                                        );
                                        twokUserWrapper.setActionToMap(action);
                                    }
                                    twokUserWrapper.setActionToUserboard(HomeFragmentDirections.actionNavDirectionHomeToUserBoardFragment(twokResponse.getUid()));
                                    append(twokUserWrapper);

                                });
                    });
        });
    }

    public void followToggle(Integer uid, boolean isFollowed) {
        if(isFollowed){
            new FollowedRepository().unfollow(uid);
        }else{
            new FollowedRepository().follow(uid);
        }
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