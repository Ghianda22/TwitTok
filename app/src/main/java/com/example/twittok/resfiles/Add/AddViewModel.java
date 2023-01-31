/*
package com.example.twittok.UI.Add;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.twittok.Network.ApiObjects.Input.TwokToAdd;
import com.google.android.material.snackbar.Snackbar;

public class AddViewModel extends ViewModel {

    // --- ATTRIBUTES ------------------------------------------------------------------------------
    private final String defaultText = "New Twok";
    private final TwokToAdd defaultTwok = new TwokToAdd(
            null,
            null,
            Integer.toHexString(Color.WHITE),
            Integer.toHexString(Color.BLACK),
            0,
            0,
            1,
            1,
            null,
            null
    );
    private MutableLiveData<String> mText = new MutableLiveData<>(defaultText);
    private MutableLiveData<TwokToAdd> mTwok = new MutableLiveData<>(defaultTwok);
    // ---------------------------------------------------------------------------------------------



    // --- METHODS ---------------------------------------------------------------------------------
    public LiveData<String> getLiveText() {
        return  mText;
    }

    public void setLiveText(String text) {
        mText.setValue(text);
    }

    public LiveData<TwokToAdd> getLiveTwok() {
        return mTwok;
    }

    public void setLiveTwok(TwokToAdd twokToAdd) {
        mTwok.setValue(twokToAdd);
    }

    public void resetLiveTwok() {
        mTwok.setValue(new TwokToAdd(
                null,
                null,
                Integer.toHexString(Color.WHITE),
                Integer.toHexString(Color.BLACK),
                0,
                0,
                1,
                1,
                null,
                null
        ));
    }




    // --- GET AND SET SID -------------------------------------------------------------------------
    public String getSid() {
        return mTwok.getValue().getSid();
    }

    public void setSid(String sid) {
        mTwok.getValue().setSid(sid);
        mTwok.setValue(mTwok.getValue());
    }
    // ---------------------------------------------------------------------------------------------



    // --- GET AND SET TEXT ------------------------------------------------------------------------
    public String getText() {
        return mTwok.getValue().getText();
    }

    public void setText(String text) {
        mTwok.getValue().setText(text);
        mTwok.setValue(mTwok.getValue());
    }
    // ---------------------------------------------------------------------------------------------




    // --- GET AND SET BGCOL -----------------------------------------------------------------------
    public String getBgcol() {
        return mTwok.getValue().getBgcol();
    }

    public void setBgcol(String bgcol) {
        mTwok.getValue().setBgcol(bgcol);
        mTwok.setValue(mTwok.getValue());
    }
    // ---------------------------------------------------------------------------------------------



    // --- GET AND SET FONTCOL ---------------------------------------------------------------------
    public String getFontcol() {
        return mTwok.getValue().getFontcol();
    }

    public void setFontcol(String fontcol) {
        mTwok.getValue().setFontcol(fontcol);
        mTwok.setValue(mTwok.getValue());
    }
    // ---------------------------------------------------------------------------------------------



    // --- GET AND SET FONTSIZE --------------------------------------------------------------------
    public Integer getFontsize() {
        return mTwok.getValue().getFontsize();
    }

    public void setFontsize(Integer fontsize) {
        mTwok.getValue().setFontsize(fontsize);
        mTwok.setValue(mTwok.getValue());
    }
    // ---------------------------------------------------------------------------------------------



    // --- GET AND SET FONTTYPE --------------------------------------------------------------------
    public Integer getFonttype() {
        return mTwok.getValue().getFonttype();
    }

    public void setFonttype(Integer fonttype) {
        mTwok.getValue().setFonttype(fonttype);
        mTwok.setValue(mTwok.getValue());
    }
    // ---------------------------------------------------------------------------------------------



    // --- GET AND SET HALIGN ----------------------------------------------------------------------
    public Integer getHalign() {
        return mTwok.getValue().getHalign();
    }

    public void setHalign(Integer halign) {
        mTwok.getValue().setHalign(halign);
        mTwok.setValue(mTwok.getValue());
    }
    // ---------------------------------------------------------------------------------------------



    // --- GET AND SET VALIGN ----------------------------------------------------------------------
    public Integer getValign() {
        return mTwok.getValue().getValign();
    }

    public void setValign(Integer valign) {
        mTwok.getValue().setValign(valign);
        mTwok.setValue(mTwok.getValue());
    }
    // ---------------------------------------------------------------------------------------------



    // --- GET AND SET LAT -------------------------------------------------------------------------
    public Double getLat() {
        return mTwok.getValue().getLat();
    }

    public void setLat(Double lat) {
        mTwok.getValue().setLat(lat);
        mTwok.setValue(mTwok.getValue());
    }

    public void postLat(Double lat) {
        mTwok.getValue().setLat(lat);
        mTwok.postValue(mTwok.getValue());
    }
    // ---------------------------------------------------------------------------------------------



    // --- GET AND SET LON -------------------------------------------------------------------------
    public Double getLon() {
        return mTwok.getValue().getLon();
    }

    public void setLon(Double lon) {
        mTwok.getValue().setLon(lon);
        mTwok.setValue(mTwok.getValue());
    }

    public void postLon(Double lon) {
        mTwok.getValue().setLon(lon);
        mTwok.postValue(mTwok.getValue());
    }
    // ---------------------------------------------------------------------------------------------

    public void addTwok(Context context) {
        AddRepository.addTwok(
                mTwok.getValue(),
                response -> {
                    if (response.isSuccessful()) {
                        setLiveText(defaultText);
                        resetLiveTwok();
                        Toast toast = Toast.makeText(context, "Twok has been added successfully.", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        toast.show();

                    } else {
                        printTwok();
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("Something went wrong. Please try again.");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {}
                        });
                        builder.show();
                    }
                });
    }

    public void printTwok() {
        Log.d("twokToAdd", "SID: " + getSid());
        Log.d("twokToAdd", "TEXT: " + getText());
        Log.d("twokToAdd", "BGCOL: " + getBgcol());
        Log.d("twokToAdd", "FONTCOL: " + getFontcol());
        Log.d("twokToAdd", "FONTSIZE: " + getFontsize());
        Log.d("twokToAdd", "FONTTYPE: " + getFonttype());
        Log.d("twokToAdd", "HALIGN: " + getHalign());
        Log.d("twokToAdd", "VALIGN: " + getValign());
        Log.d("twokToAdd", "LAT: " + getLat());
        Log.d("twokToAdd", "LON: " + getLon());
    }
}*/
