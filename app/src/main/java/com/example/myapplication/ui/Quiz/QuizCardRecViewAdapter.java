package com.example.myapplication.ui.Quiz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.remote.model.QuizModel;
import com.example.myapplication.ui.Quiz.Guess.GuessFragment;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuizCardRecViewAdapter extends RecyclerView.Adapter<QuizCardRecViewAdapter.QuizCardViewHolder> {
    private Context context;
    private List<QuizModel> quizzes = new ArrayList<>();
    private NavController nav;

    public QuizCardRecViewAdapter(Context context, NavController nav){
        this.context = context;
        this.nav = nav;
    };

    @NonNull
    @Override
    public QuizCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_card_fragment, parent,false);
        return new QuizCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizCardViewHolder holder, int position) {
        QuizModel item = quizzes.get(position);

        holder.name.setText(item.name);
        holder.card.setOnClickListener(v -> {
            GuessFragment guessFragment = new GuessFragment();
            Bundle bundle = new Bundle();
            bundle.putString("quizId", item.id);
            guessFragment.setArguments(bundle);
            Toast.makeText(context, item.id,Toast.LENGTH_SHORT).show();
            nav.navigate(R.id.action_quiz_to_guess, bundle);
        });

    }


    @SuppressLint("NotifyDataSetChanged")
    public void setQuizzes(List<QuizModel> quizzes) {
        this.quizzes = quizzes;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return quizzes.size();
    }

    public static class QuizCardViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout card;
        private TextView name;
        public QuizCardViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card_quiz);
            name = itemView.findViewById(R.id.txt_name);
        }
    }
}
