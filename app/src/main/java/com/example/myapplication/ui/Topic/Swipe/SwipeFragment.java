package com.example.myapplication.ui.Topic.Swipe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.SwipeFragmentBinding;

public class SwipeFragment extends Fragment {
    private SwipeFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = SwipeFragmentBinding.inflate(inflater, container, false);



        return binding.getRoot();
    }

    private void initiate(SwipeFragmentBinding binding) {

    }

}