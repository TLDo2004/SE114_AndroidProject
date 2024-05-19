package com.example.myapplication.ui.Topic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.TopicNavHostFragmentBinding;


public class TopicNavHostFragment extends Fragment {
    private TopicNavHostFragmentBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = TopicNavHostFragmentBinding.inflate(getLayoutInflater());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = TopicNavHostFragmentBinding.inflate(inflater, container, false);
        NavHostFragment navHost = (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.topic_nav_host_fragment);
        NavController nestedNavController = navHost.getNavController();

        return binding.getRoot();
    }
}
