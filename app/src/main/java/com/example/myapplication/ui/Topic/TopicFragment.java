package com.example.myapplication.ui.Topic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
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
        setupRecyclerView(binding);

        topicRepo.getTopic().observe(getViewLifecycleOwner(), new Observer<List<TopicModel>>() {
            @Override
            public void onChanged(List<TopicModel> topics) {
                topicCardAdapter.setTopics(topics);
            }
        });


        return binding.getRoot();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void initiate(TopicFragmentBinding binding) {
        topicRepo = new TopicRepo();
        topicCardAdapter = new TopicCardRecViewAdapter(getContext());
    }
    private void setupRecyclerView(TopicFragmentBinding binding) {
        RecyclerView rec = binding.topicRecView;
        rec.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        rec.setAdapter(topicCardAdapter);

        rec.setHasFixedSize(true);
    }
}