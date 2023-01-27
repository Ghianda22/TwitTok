package com.example.twittok.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.twittok.repositories.TwokRepository;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<TwokRepository[]> twokArray = null;

    public MutableLiveData<TwokRepository[]> getUserProfile(){
        if(twokArray == null){
            twokArray = new MutableLiveData<TwokRepository[]>();

        }
        return twokArray;
    }

}