package com.example.myapplication.ui.Quiz.Guess;

import android.os.Bundle;
import android.util.Log;
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

import com.example.myapplication.databinding.GuessFragmentBinding;
import com.example.myapplication.remote.repo.QuizRepo;
import com.example.myapplication.remote.repo.WordRepo;
import com.example.myapplication.ui.Quiz.QuizCardRecViewAdapter;

import java.util.List;

public class GuessFragment extends Fragment {
    private GuessFragmentBinding binding;
    private RecyclerView guessRecyclerView;
    private QuizRepo quizRepo;
    private GuessCardRecViewAdapter guessCardAdapter;
    private String quizId;
    private WordRepo wordRepo;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = GuessFragmentBinding.inflate(inflater, container, false);

        Bundle arguments = getArguments();
        if (arguments != null){
            quizId = arguments.getString("quizId");
            Log.d("test", "Quiz ID received: " + quizId);
        }

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);
        initiate(binding, navController);
        setupRecyclerView(binding);
        quizRepo.getQuizById(quizId).observe(getViewLifecycleOwner(), wordIds -> guessCardAdapter.setWordId((List<String>) wordIds));
    }

    private void initiate(GuessFragmentBinding binding, NavController navController) {
        guessRecyclerView = binding.guessRecView;
        quizRepo = new QuizRepo();
        wordRepo = new WordRepo();
        guessCardAdapter = new GuessCardRecViewAdapter(getContext(), navController);
    }

    private void setupRecyclerView(GuessFragmentBinding binding) {
        RecyclerView rec = binding.guessRecView;
        rec.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        rec.setAdapter(guessCardAdapter);
        rec.setHasFixedSize(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
