package com.example.twittok.ui.userboard;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.twittok.databinding.FragmentUserBoardBinding;
import com.example.twittok.repositories.SidRepository;
import com.example.twittok.ui.twokscroll.TwokViewAdapter;

import java.util.ArrayList;

public class UserBoardFragment extends Fragment {

    private UserBoardViewModel userBoardViewModel;
    private FragmentUserBoardBinding binding;
    private boolean firstTime;
    private static final String TAG = "HOME_FRAGMENT";
    private final int bufferSize = 5;

    public static UserBoardFragment newInstance() {
        return new UserBoardFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentUserBoardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userBoardViewModel = new ViewModelProvider(this).get(UserBoardViewModel.class);
        Integer uid = UserBoardFragmentArgs.fromBundle(getArguments()).getSelectedUser();

        // --- VIEW PAGER SETUP --------------------------------------------------------------------
        ViewPager2 viewPager = binding.twokListContainer;
        TwokViewAdapter twokViewAdapter = new TwokViewAdapter(new ArrayList<>());
        viewPager.setAdapter(twokViewAdapter);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (viewPager.getCurrentItem() > userBoardViewModel.getSize() - bufferSize) {
                    userBoardViewModel.addTwok(uid);
                    Log.d(TAG, "onPageSelected: ero vicino alla fine");
                }
            }
        });


        // --- VIEW PAGER UPDATE --------------------------------------------------------------------
        firstTime = true;
        if (userBoardViewModel.isEmpty()) {
            userBoardViewModel.addTwok(uid);

        }
        userBoardViewModel.getTwokArrayList().observe(
                getViewLifecycleOwner(),
                twokArrayList -> {
                    if (firstTime && twokArrayList.size() > 0) {
                        binding.spinningWheel.setVisibility(View.GONE);
                        twokViewAdapter.setTwokArrayList(twokArrayList);
                        viewPager.setAdapter(twokViewAdapter);
                        firstTime = false;
                    }
                    if (twokArrayList.size() > 0 && twokArrayList.size() < bufferSize) {
                        userBoardViewModel.addTwok(uid);
                    }
                    twokViewAdapter.notifyDataSetChanged();
                }
        );

    }


}