package com.example.myapplication.ui.Quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.QuizFragmentBinding;
import com.example.myapplication.remote.repo.QuizRepo;

public class QuizFragment extends Fragment {
    private QuizFragmentBinding binding;
    private QuizRepo quizRepo;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = QuizFragmentBinding.inflate(inflater, container, false);
        initiate(binding);



        return binding.getRoot();
    }
    private void initiate(QuizFragmentBinding binding) {
        quizRepo = new QuizRepo();


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}