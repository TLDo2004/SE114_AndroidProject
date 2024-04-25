package com.example.myapplication.ui.Quiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.remote.model.QuizModel;
import com.example.myapplication.remote.model.QuizModel;
import com.example.myapplication.remote.model.WordModel;
import com.example.myapplication.ui.Quiz.QuizCardRecViewAdapter;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GuessCardRecViewAdapter extends RecyclerView.Adapter<GuessCardRecViewAdapter.GuessCardViewHolder> {

    private List<QuizModel> quizList;

    public GuessCardRecViewAdapter(List<QuizModel> quizList) {
        this.quizList = quizList;
    }

    @NonNull
    @Override
    public GuessCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.guess_card_fragment, parent, false);
        return new GuessCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuessCardViewHolder holder, int position) {
        QuizModel quiz = quizList.get(position);
        List<WordModel> wordList = getWordsByQuizId(Integer.parseInt(quiz.getId()));
        // Use the wordList to populate your view holder
    }

    @Override
    public int getItemCount() {
        return quizList.size();
    }

    private List<WordModel> getWordsByQuizId(int quizId) {
        // Implement your logic to fetch words from WordModel based on quizId
        // For example, you can use a database query or API call
        // Return the list of words
        return new ArrayList<>(); // Placeholder return statement
    }

    public static class GuessCardViewHolder extends RecyclerView.ViewHolder {
        // Your view holder implementation
        RelativeLayout card;
        public GuessCardViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize your view holder components
            card = itemView.findViewById(R.id.card_guess);
//            name = itemView.findViewById(R.id.txt_name);
//            type = itemView.findViewById(R.id.txt_type);
//            point = itemView.findViewById(R.id.txt_point);
//            timer = itemView.findViewById(R.id.txt_timer);
        }
    }
}
