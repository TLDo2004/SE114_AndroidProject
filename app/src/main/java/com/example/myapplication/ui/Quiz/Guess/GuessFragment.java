package com.example.myapplication.ui.Quiz.Guess;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.AlertDialog;
import android.widget.Toast;

import com.google.android.material.progressindicator.CircularProgressIndicator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.myapplication.R;
import com.example.myapplication.databinding.GuessFragmentBinding;
import com.example.myapplication.remote.model.WordModel;
import com.example.myapplication.remote.repo.QuizRepo;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GuessFragment extends Fragment {
    private GuessFragmentBinding binding;
    private QuizRepo quizRepo;
    private NavController navController;
    private TextView txtTopic;
    private LinearLayout btnBack, btnNext, btnOptA, btnOptB, btnOptC, btnOptD;
    private TextView txtQuizContent, txtOptA, txtOptB, txtOptC, txtOptD;
    private List<WordModel> quizContent = new ArrayList<>();
    private int currentQuizIndex = 0;
    private int correctCounter = 0;
    private String quizType = null;
    private ImageButton btnPlay;

    // Finish dialog
    private TextView txtResTitle, txtResProg, txtCorrect, txtOverall;
    private CircularProgressIndicator indicatorResProg;
    private MediaPlayer mediaPlayer;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = GuessFragmentBinding.inflate(inflater, container, false);
        initiate(binding);

        Bundle args = getArguments();
        String quizId = null;
        if (args != null) {
            quizId = args.getString("quizId");
        }
        quizRepo.getQuizById(quizId).observe(getViewLifecycleOwner(), quiz -> {
            txtTopic.setText(quiz.name);
            quizType = quiz.type;
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
                showFinishQuizDialog(navController);
            }
        });

        return binding.getRoot();
    }

    private void initiate(GuessFragmentBinding binding) {
        quizRepo = new QuizRepo();
        txtTopic = binding.txtTopic;
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
        btnPlay = binding.btnPlay;
    }

    private void showNextQuiz() {
        switch (quizType){
            case "guess":
                txtQuizContent.setText(quizContent.get(currentQuizIndex).def);
                break;
            case "fill":
                txtQuizContent.setText(quizContent.get(currentQuizIndex).blankSen);
                break;
            case "compound":
                txtQuizContent.setText(quizContent.get(currentQuizIndex).def);
                break;
            case "sound":
                txtQuizContent.setVisibility(View.GONE);
                btnPlay.setVisibility(View.VISIBLE);
                playAudio(quizContent.get(currentQuizIndex).audio);
                break;
            default:
                txtQuizContent.setText(quizContent.get(currentQuizIndex).def);
                break;
        }
        List<String> opts = new ArrayList<>();
        opts.add(quizContent.get(currentQuizIndex).word);

        List<String> dummyOpts = handleDummyOpt();
        opts.addAll(dummyOpts);

        handleOpt(opts);

    }

    private void playAudio(String url) {
     btnPlay.setOnClickListener(v -> {});
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
                correctCounter++;
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


    private void showFinishQuizDialog(NavController navController) {
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

         txtResTitle = dialogView.findViewById(R.id.txt_result_title);
         txtResProg = dialogView.findViewById(R.id.txt_result_progress);
         txtCorrect = dialogView.findViewById(R.id.txt_correct);
         txtOverall = dialogView.findViewById(R.id.txt_overrall);
         indicatorResProg = dialogView.findViewById(R.id.indicator_result_progress);

         //Setup result
         int overall = quizContent.size();
         int percentage = (int) (((float) correctCounter / (float) overall) * 100);

        txtCorrect.setText(String.valueOf(correctCounter));
        txtResProg.setText(String.valueOf(percentage) + "%");
        indicatorResProg.setProgress(percentage);

         if( percentage > 50 ) {
             txtResTitle.setText("Congrats! You have passed!");
             txtCorrect.setTextColor(ContextCompat.getColor(requireContext(), R.color.correct));
             txtOverall.setTextColor(ContextCompat.getColor(requireContext(), R.color.correct));
             indicatorResProg.setIndicatorColor(ContextCompat.getColor(requireContext(), R.color.correct));
         }  else  {
             txtResTitle.setText("Oops! You have failed");
             txtCorrect.setTextColor(ContextCompat.getColor(requireContext(), R.color.wrong));
             txtOverall.setTextColor(ContextCompat.getColor(requireContext(), R.color.wrong));
             indicatorResProg.setIndicatorColor(ContextCompat.getColor(requireContext(), R.color.wrong));
         }




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
