package com.example.myapplication.ui.Quiz.Guess;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import com.google.android.material.progressindicator.CircularProgressIndicator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.myapplication.R;
import com.example.myapplication.databinding.GuessFragmentBinding;
import com.example.myapplication.remote.model.WordModel;
import com.example.myapplication.remote.repo.QuizRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GuessFragment extends Fragment {
    private GuessFragmentBinding binding;
    private QuizRepo quizRepo;
    private LinearLayout btnBack, btnNext, btnOptA, btnOptB, btnOptC, btnOptD;
    private TextView txtQuizContent, txtOptA, txtOptB, txtOptC, txtOptD;
    private List<WordModel> quizContent = new ArrayList<>();
    private int currentQuizIndex = 0;
    private NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = GuessFragmentBinding.inflate(inflater, container, false);
        initiate(binding);

        quizRepo.getQuizById("6625e7201b9f1c8699f737f5").observe(getViewLifecycleOwner(), quiz -> {
            quizContent.addAll(quiz.wordList);
            if (!quizContent.isEmpty()) {
                showNextQuiz();
            }

        });

        navController = Navigation.findNavController(container);
        btnBack.setOnClickListener(v -> {
            navController.navigate(R.id.action_guess_to_quiz, null);
        });

        btnNext.setOnClickListener(v -> {
            currentQuizIndex++;
            if (currentQuizIndex < quizContent.size()) {
                showNextQuiz();
                resetBtn();
                btnNext.setVisibility(View.INVISIBLE);
            } else {
                finishQuiz(navController);
            }
        });

        return binding.getRoot();
    }

    private void initiate(GuessFragmentBinding binding) {
        quizRepo = new QuizRepo();
        btnBack = binding.btnBack;
        btnNext = binding.btnNext;
        btnOptA = binding.btnOptA;
        btnOptB = binding.btnOptB;
        btnOptC = binding.btnOptC;
        btnOptD = binding.btnOptD;
        txtQuizContent = binding.txtQuizContent;
        txtOptA = binding.txtOptA;
        txtOptB = binding.txtOptB;
        txtOptC = binding.txtOptC;
        txtOptD = binding.txtOptD;
    }

    private void showNextQuiz() {
        txtQuizContent.setText(quizContent.get(currentQuizIndex).def);

        List<String> opts = new ArrayList<>();
        opts.add(quizContent.get(currentQuizIndex).word);

        List<String> dummyOpts = handleDummyOpt();
        opts.addAll(dummyOpts);

        handleOpt(opts);

    }

    private void handleOpt(List<String> opts) {
        Collections.shuffle(opts);
        txtOptA.setText(opts.get(0));
        txtOptB.setText(opts.get(1));
        txtOptC.setText(opts.get(2));
        txtOptD.setText(opts.get(3));

        String currentAns = quizContent.get(currentQuizIndex).word;

        setButtonListener(btnOptA, txtOptA, currentAns);
        setButtonListener(btnOptB, txtOptB, currentAns);
        setButtonListener(btnOptC, txtOptC, currentAns);
        setButtonListener(btnOptD, txtOptD, currentAns);
    }

    private void setButtonListener(LinearLayout btnOpt, TextView txtOpt, String correctAnswer) {
        btnOpt.setOnClickListener(v -> {
            if (txtOpt.getText().toString().equals(correctAnswer)) {
                btnOpt.setBackgroundResource(R.drawable.custom_shape_correct);
            } else {
                btnOpt.setBackgroundResource(R.drawable.custom_shape_wrong);
            }
            disableAllBtn();
        });
    }
    private void resetBtn() {
        btnOptA.setEnabled(true);
        btnOptB.setEnabled(true);
        btnOptC.setEnabled(true);
        btnOptD.setEnabled(true);
        btnOptA.setBackgroundResource(R.drawable.custom_shape4);
        btnOptB.setBackgroundResource(R.drawable.custom_shape4);
        btnOptC.setBackgroundResource(R.drawable.custom_shape4);
        btnOptD.setBackgroundResource(R.drawable.custom_shape4);
    }
    private void disableAllBtn() {
        btnOptA.setEnabled(false);
        btnOptB.setEnabled(false);
        btnOptC.setEnabled(false);
        btnOptD.setEnabled(false);
        btnNext.setVisibility(View.VISIBLE);
    }

    private void finishQuiz(NavController navController) {
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.quiz_finish_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(dialogView).setCancelable(false);
        AlertDialog alertDialog = builder.create();

        Button btnFinish = dialogView.findViewById(R.id.btn_finish);
        btnFinish.setOnClickListener(v -> {
            navController.navigate(R.id.action_guess_to_quiz, null);
            alertDialog.dismiss();
        });

        TextView scoreTitle = dialogView.findViewById(R.id.score_title);
        TextView scoreProgressText = dialogView.findViewById(R.id.score_progress_text);
        CircularProgressIndicator progressIndicator = dialogView.findViewById(R.id.score_progress_indicator);

        scoreTitle.setText("Congrats! You have passed");
        scoreProgressText.setText("50%");
        progressIndicator.setProgress(50);

        alertDialog.show();
    }

    private List<String> handleDummyOpt() {
        String[] words = {
                "serendipity",
                "ephemeral",
                "mellifluous",
                "luminous",
                "euphoria",
                "ineffable",
                "tranquility",
                "resilience",
                "epiphany",
                "synthesize",
                "altruism",
                "ethereal",
                "paradox",
                "enigma",
                "effervescent"
        };

        List<String> dummyOpt = Arrays.asList(words);
        Collections.shuffle(dummyOpt);

        return dummyOpt.subList(0, 3);
    }
}
