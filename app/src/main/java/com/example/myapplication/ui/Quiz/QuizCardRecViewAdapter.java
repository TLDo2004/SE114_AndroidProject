package com.example.myapplication.ui.Quiz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.remote.model.QuizModel;
import com.example.myapplication.ui.Quiz.Guess.GuessBasicFragment;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuizCardRecViewAdapter extends RecyclerView.Adapter<QuizCardRecViewAdapter.QuizCardViewHolder> {

    private Context context;
    private List<QuizModel> quizs = new ArrayList<>();
    public QuizCardRecViewAdapter(Context context){this.context = context;};

    @NonNull
    @Override
    public QuizCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_card_fragment, parent,false);
        return new QuizCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizCardRecViewAdapter.QuizCardViewHolder holder, @SuppressLint("RecyclerView") int position) {
        QuizModel item =  quizs.get(position); // get position
        holder.name.setText(item.name);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           GuessBasicFragment guessFragment = new GuessBasicFragment();
               Bundle bundle = new Bundle();
               bundle.putString("quizId", item.id);
               guessFragment.setArguments(bundle);
               Navigation.createNavigateOnClickListener(R.id.navigation_guess, bundle).onClick(holder.itemView);
               Toast.makeText(context, item.id, Toast.LENGTH_SHORT).show();
            }
        });
    }
    @SuppressLint("NotifyDataSetChanged")
    public void setQuizs(List<QuizModel> quizs) {
        this.quizs = quizs;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return quizs.size();
    }

    public static class QuizCardViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout card;
        private TextView type, point, timer, name;
        public QuizCardViewHolder(@Nullable View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card_quiz);
            name = itemView.findViewById(R.id.txt_name);
            type = itemView.findViewById(R.id.txt_type);
            point = itemView.findViewById(R.id.txt_point);
            timer = itemView.findViewById(R.id.txt_timer);
        }
    }
}
