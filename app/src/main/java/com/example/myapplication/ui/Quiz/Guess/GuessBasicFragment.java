package com.example.myapplication.ui.Quiz.Guess;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.GuessBasicFragmentBinding;
import com.example.myapplication.remote.model.QuizModel;
import com.example.myapplication.remote.model.WordModel;
import com.example.myapplication.remote.repo.QuizRepo;

import java.util.List;

public class GuessBasicFragment extends Fragment {
    private String quizId;
    private GuessBasicFragmentBinding binding;
    private QuizRepo quizRepo;

    private GuessCardRecViewAdapter guessCardAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = GuessBasicFragmentBinding.inflate(inflater, container, false);
        initiate(binding);
        setupRecyclerView(binding);

        // get quizId from Bundle
        Bundle bundle = getArguments();
        if (bundle != null) {
            quizId = bundle.getString("quizId");
        }

        List<String> words = (List<String>) quizRepo.getQuizById(quizId);

        return binding.getRoot();
    }

    private void setupRecyclerView(GuessBasicFragmentBinding binding) {
        RecyclerView rec = binding.guessRecView;
        rec.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        rec.setAdapter(guessCardAdapter);
        rec.setHasFixedSize(true);
    }

    private void initiate(GuessBasicFragmentBinding binding) {
        quizRepo = new QuizRepo();
        guessCardAdapter = new GuessCardRecViewAdapter(getContext());
    }

    // callApi() {
    //
    //
    // getFromBundle => KEY- VALUE => ID
    // if(ID != NULL) {
    // quizId = ID
    // }
    //
    // getQuizById(quizId) => WORDS
    // SETLISTWORD(WORDS) => RECYLERVIEW
    //
    // }
}
