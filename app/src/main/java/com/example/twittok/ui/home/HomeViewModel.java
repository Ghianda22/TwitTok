package com.example.twittok.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<String[]> provaList = null;

    public MutableLiveData<String[]> getProvaList(){
        if(provaList == null){
            provaList = new MutableLiveData<String[]>();
            provaList.setValue(new String[]{"Prova", "Viva la prova", "questa è una prova"});
        }
        return provaList;
    }

}