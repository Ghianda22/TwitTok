/*
package com.example.twittok.UI.Add;

import static com.google.android.gms.location.Priority.PRIORITY_BALANCED_POWER_ACCURACY;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationRequest;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.twittok.databinding.FragmentAddBinding;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnTokenCanceledListener;

import java.util.concurrent.Executors;

import yuku.ambilwarna.AmbilWarnaDialog;

public class AddFragment extends Fragment {

    // --- STATE -----------------------------------------------------------------------------------
    private FragmentAddBinding binding;
    SharedPreferences prefs;
    private AddViewModel viewModel;
    private FusedLocationProviderClient fusedLocationClient;
    private EditText twokText;
    private View twokBackground;
    private Button moveLeft;
    private Button moveRight;
    private Button moveUp;
    private Button moveDown;
    private Button bgcolButton;
    private Button fontcolButton;
    private Button fontsizeButton;
    private Button fonttypeButton;
    private Button positionButton;
    private Button sendButton;
    private ImageView positionSet;
    // ---------------------------------------------------------------------------------------------



    // --- ON CREATE VIEW --------------------------------------------------------------------------
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    // ---------------------------------------------------------------------------------------------


    // --- ON VIEW CREATED -------------------------------------------------------------------------
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prefs = getActivity().getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        viewModel = new ViewModelProvider(requireActivity()).get(AddViewModel.class);
        String sid = prefs.getString("sid", "");

        twokText = binding.twokTextField;
        twokBackground = binding.twokBackground;
        moveLeft = binding.moveLeft;
        moveRight = binding.moveRight;
        moveUp = binding.moveUp;
        moveDown = binding.moveDown;
        bgcolButton = binding.bgcolButton;
        fontcolButton = binding.fontcolButton;
        fontsizeButton = binding.fontsizeButton;
        fonttypeButton = binding.fonttypeButton;
        positionButton = binding.positionButton;
        sendButton = binding.sendButton;
        positionSet = binding.positionSet;

        viewModel.getLiveTwok().observe(
                getViewLifecycleOwner(),
                twokToAdd -> {
                    twokText.setText(viewModel.getLiveText().getValue());
                    switch (viewModel.getHalign()) {
                        case 0: twokText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START); break;
                        case 1: twokText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER); break;
                        case 2: twokText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END); break;
                    }
                    switch (viewModel.getValign()) {
                        case 0: twokText.setGravity(Gravity.TOP); break;
                        case 1: twokText.setGravity(Gravity.CENTER_VERTICAL); break;
                        case 2: twokText.setGravity(Gravity.BOTTOM); break;
                    }
                    twokBackground.setBackgroundColor(Color.parseColor("#" + viewModel.getBgcol()));
                    twokText.setTextColor(Color.parseColor("#" + viewModel.getFontcol()));
                    switch (viewModel.getFontsize()) {
                        case 0: twokText.setTextSize(19); break;
                        case 1: twokText.setTextSize(28); break;
                        case 2: twokText.setTextSize(37); break;
                    }
                    switch (viewModel.getFonttype()) {
                        case 0: twokText.setTypeface(Typeface.DEFAULT); break;
                        case 1: twokText.setTypeface(Typeface.MONOSPACE); break;
                        case 2: twokText.setTypeface(Typeface.SERIF); break;
                    }
                    if (twokToAdd.getLat() == null && twokToAdd.getLon() == null) {
                        positionSet.setVisibility(View.GONE);
                    } else {
                        positionSet.setVisibility(View.VISIBLE);
                    }
                });

        twokText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.setLiveText(editable.toString());
            }
        });

        moveLeft.setOnClickListener(v -> {
            switch (viewModel.getHalign()) {
                case 0: break;
                case 1: viewModel.setHalign(0); break;
                case 2: viewModel.setHalign(1); break;
            }
        });

        moveRight.setOnClickListener(v -> {
            switch (viewModel.getHalign()) {
                case 2: break;
                case 1: viewModel.setHalign(2); break;
                case 0: viewModel.setHalign(1); break;
            }
        });

        moveUp.setOnClickListener(v -> {
            switch (viewModel.getValign()) {
                case 0: break;
                case 1: viewModel.setValign(0); break;
                case 2: viewModel.setValign(1); break;
            }
        });

        moveDown.setOnClickListener(v -> {
            switch (viewModel.getValign()) {
                case 2: break;
                case 1: viewModel.setValign(2); break;
                case 0: viewModel.setValign(1); break;
            }
        });

        bgcolButton.setOnClickListener(v -> setBgcol(viewModel));

        fontcolButton.setOnClickListener(v -> setFontcol(viewModel));

        fontsizeButton.setOnClickListener(v -> {
            switch (viewModel.getFontsize()) {
                case 0: viewModel.setFontsize(1); break;
                case 1: viewModel.setFontsize(2); break;
                case 2: viewModel.setFontsize(0); break;
            }
        });

        fonttypeButton.setOnClickListener(v -> {
            switch (viewModel.getFonttype()) {
                case 0: viewModel.setFonttype(1); break;
                case 1: viewModel.setFonttype(2); break;
                case 2: viewModel.setFonttype(0); break;
            }
        });

        ActivityResultLauncher<String[]> locationPermissionRequest = registerForActivityResult(
                new ActivityResultContracts.RequestMultiplePermissions(),
                result -> {
                    Boolean fineLocationGranted = result.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false);
                    Boolean coarseLocationGranted = result.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false);
                    if (fineLocationGranted != null && fineLocationGranted) {
                        Log.d("permissions", "Precise location access granted.");
                    } else if (coarseLocationGranted != null && coarseLocationGranted) {
                        Log.d("permissions", "Only approximate location access granted.");
                    } else {
                        Log.d("permissions", "No location access granted.");
                    }
                });

        positionButton.setOnClickListener(v -> {
            fusedLocationClient = LocationServices.getFusedLocationProviderClient(getContext());
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                locationPermissionRequest.launch(new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                });
            } else {
                Log.d("userPosition", "Hellooo, I'm in!");
                fusedLocationClient.getCurrentLocation(PRIORITY_BALANCED_POWER_ACCURACY, null).addOnSuccessListener(Executors.newSingleThreadExecutor(), new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            Log.d("userPosition", "Current location:" + location.getLatitude() + " " + location.getLongitude());
                            viewModel.postLat(location.getLatitude());
                            viewModel.postLon(location.getLongitude());
                        } else {
                            Log.d("userPosition", "Current location not available");
                        }
                    }
                });
            }
        });

        sendButton.setOnClickListener(v-> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Do you confirm adding this Twok?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    viewModel.setSid(sid);
                    viewModel.setText(viewModel.getLiveText().getValue());
                    viewModel.printTwok();
                    viewModel.addTwok(getContext());
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {}
            });
            builder.show();
        });


    }
    // ---------------------------------------------------------------------------------------------




    public void setBgcol(AddViewModel viewModel) {
        AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(
                getContext(),
                Color.WHITE,
                new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {

                    }

                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        viewModel.setBgcol(String.format("#%06X", (0xFFFFFF & color)).substring(1));
                    }
                }
        );
        ambilWarnaDialog.show();
    }

    public void setFontcol(AddViewModel viewModel) {
        AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(
                getContext(),
                Color.WHITE,
                new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {

                    }

                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        viewModel.setFontcol(String.format("#%06X", (0xFFFFFF & color)).substring(1));
                    }
                }
        );
        ambilWarnaDialog.show();
    }



    // --- ON DESTROY VIEW -------------------------------------------------------------------------
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    // ---------------------------------------------------------------------------------------------
}
*/
