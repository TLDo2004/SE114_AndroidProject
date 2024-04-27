package com.example.myapplication.ui.Quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.QuizFragmentBinding;

import com.example.myapplication.remote.model.QuizModel;

import com.example.myapplication.remote.repo.QuizRepo;

import java.util.List;

public class QuizFragment extends Fragment {
    private QuizFragmentBinding binding;
    private QuizRepo quizRepo;
    private QuizCardRecViewAdapter quizCardAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = QuizFragmentBinding.inflate(inflater, container, false);
        initiate(binding);
        setupRecyclerView(binding);

        quizRepo.getQuiz().observe(getViewLifecycleOwner(), new Observer<List<QuizModel>>() {
            @Override
            public void onChanged(List<QuizModel> quizs) {
                quizCardAdapter.setQuizs(quizs);
            }
        });

        return binding.getRoot();
    }
    private void initiate(QuizFragmentBinding binding) {
        quizRepo = new QuizRepo();
        quizCardAdapter = new QuizCardRecViewAdapter(getContext());
    }
    private void setupRecyclerView(QuizFragmentBinding binding) {
        RecyclerView rec = binding.quizRecView;
        rec.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        rec.setAdapter(quizCardAdapter);

        rec.setHasFixedSize(true);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}