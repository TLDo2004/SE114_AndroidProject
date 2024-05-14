package com.example.myapplication.ui.Quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.QuizFragmentBinding;
import com.example.myapplication.remote.repo.QuizRepo;

public class QuizFragment extends Fragment {
    private QuizFragmentBinding binding;
    private QuizRepo quizRepo;
    private QuizCardRecViewAdapter quizCardAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = QuizFragmentBinding.inflate(inflater, container, false);


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);
        initiate(binding, navController);
        setupRecyclerView(binding);
        quizRepo.getQuiz().observe(getViewLifecycleOwner(), quizzes -> quizCardAdapter.setQuizzes(quizzes));

    }

    private void initiate(QuizFragmentBinding binding, NavController navController) {
        quizRepo = new QuizRepo();
        quizCardAdapter = new QuizCardRecViewAdapter(getContext(), navController);
    }

    private void setupRecyclerView(QuizFragmentBinding binding) {
        RecyclerView rec = binding.quizRecView;
        rec.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        rec.setAdapter(quizCardAdapter);
        rec.setHasFixedSize(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}