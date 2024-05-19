package com.example.myapplication.ui.Topic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.TopicFragmentBinding;
import com.example.myapplication.remote.model.TopicModel;
import com.example.myapplication.remote.model.WordModel;
import com.example.myapplication.remote.repo.TopicRepo;
import com.example.myapplication.remote.repo.WordRepo;

import java.util.List;

public class TopicFragment extends Fragment {

    private TopicFragmentBinding binding;
    private TopicRepo topicRepo;
    private TopicCardRecViewAdapter topicCardAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = TopicFragmentBinding.inflate(inflater, container, false);
        initiate(binding);

        NavController navController = Navigation.findNavController(container);

        topicCardAdapter = new TopicCardRecViewAdapter(getContext(), navController);
        topicRepo.getTopic().observe(getViewLifecycleOwner(), topics -> topicCardAdapter.setTopics(topics));

        setupRecyclerView(binding);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //TopicRepo topicRepo = new TopicRepo();
        //topicRepo.getTopic().observe(getViewLifecycleOwner(), topics -> topicCardAdapter.setTopics(topics));

    }

    private void initiate(TopicFragmentBinding binding) {
        topicRepo = new TopicRepo();
    }

    private void setupRecyclerView(TopicFragmentBinding binding) {
        RecyclerView rec = binding.topicRecView;
        rec.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        rec.setAdapter(topicCardAdapter);
        rec.setHasFixedSize(true);
    }
}