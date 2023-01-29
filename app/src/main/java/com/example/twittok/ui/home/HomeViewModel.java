package com.example.twittok.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.twittok.datasource.model.TwokModel;
import com.example.twittok.repositories.SidRepository;
import com.example.twittok.repositories.TwokRepository;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<ArrayList<TwokModel>> twokArrayList = new MutableLiveData<>(new ArrayList<>());
    private static final String TAG = "HOME_VIEWMODEL";


    public LiveData<ArrayList<TwokModel>> getTwokArrayList() {
        return twokArrayList;
    }

    public void addTwok(){
        Log.d(TAG, "addTwok: called");
        new TwokRepository().loadTwok(twokModel -> {
            append(twokModel);
        });
    }
    public void append(TwokModel newTwok){
        twokArrayList.getValue().add(newTwok);
        twokArrayList.postValue(twokArrayList.getValue());
    }
    public boolean isEmpty(){
        if(twokArrayList == null) return true;
        else if (twokArrayList.getValue() == null) return true;
            else return twokArrayList.getValue().isEmpty();
    }
    public int getSize(){
        return twokArrayList.getValue().size();
    }

    @Override
    public String toString() {
        return "HomeViewModel{" +
                "twokArrayList=" + twokArrayList +
                '}';
    }
    public String arrayListToString() {
        return "TwokArrayList{[" +
                twokArrayList.getValue() +
                ']';
    }
}