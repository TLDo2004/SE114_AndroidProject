package com.example.myapplication.ui.Topic.Swipe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.myapplication.R;
import com.example.myapplication.databinding.SwipeFragmentBinding;
import com.example.myapplication.remote.model.WordModel;
import com.example.myapplication.remote.repo.TopicRepo;
import com.wenchao.cardstack.CardStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SwipeFragment extends Fragment {
    private SwipeFragmentBinding binding;
    private TopicRepo topicRepo;
    private CardStack cardStack;
    private LinearLayout btnBack;
    private TextView txtTopic;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = SwipeFragmentBinding.inflate(inflater, container, false);
        initiate(binding);

        NavController navController = Navigation.findNavController(container);
        btnBack.setOnClickListener(v -> {
            navController.navigate(R.id.action_swipe_to_topic, null);
        });

        Bundle args = getArguments();
        String topicId = null;
        if (args != null) {
            topicId = args.getString("topicId");
        }
        SwipeCardFragment swipeCard = new SwipeCardFragment(getContext());
        topicRepo.getTopicById(topicId).observe(getViewLifecycleOwner(), topic -> {
            txtTopic.setText(topic.name);
            swipeCard.addAll(topic.wordList);
        });

        cardStack.setContentResource(R.layout.swipe_card_fragment);
        cardStack.setAdapter(swipeCard);

        return binding.getRoot();
    }

    private void initiate(SwipeFragmentBinding binding) {
        topicRepo = new TopicRepo();
        cardStack = binding.cardStack;
        btnBack = binding.btnBack;
        txtTopic = binding.txtTopic;
    }

}
