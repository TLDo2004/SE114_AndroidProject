package com.example.myapplication.ui.Topic.FlashCard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.TopicExampleBinding;

public class FlashCard extends Fragment {
    private TopicExampleBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = TopicExampleBinding.inflate(inflater, container, false);



        return binding.getRoot();
    }
}
