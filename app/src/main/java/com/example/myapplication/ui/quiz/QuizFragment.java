package com.example.myapplication.ui.quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.example.myapplication.databinding.QuizFragmentBinding;
import com.example.myapplication.remote.model.QuizModel;
import com.example.myapplication.remote.repo.QuizRepo;

import java.util.List;

public class QuizFragment extends Fragment {
    private QuizFragmentBinding binding;

    private QuizRepo quizRepo;
    private TextView quizs;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = QuizFragmentBinding.inflate(inflater, container, false);
        initiate(binding);

        // GET ALL QUIZ
        quizRepo.getQuizById("662390c2055571708f9dfd61").observe(getViewLifecycleOwner(), new Observer<QuizModel>() {
            @Override
            public void onChanged(QuizModel quizModels) {
                quizs.setText(quizModels.toString());
                //Toast.makeText(getActivity().getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
            }
        });


        // GET QUIZ BY ID

        return binding.getRoot();
    }
    private void initiate(QuizFragmentBinding binding) {
        quizs = binding.textDashboard;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}