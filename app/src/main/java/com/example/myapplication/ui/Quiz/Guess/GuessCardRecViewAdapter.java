package com.example.myapplication.ui.Quiz.Guess;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.remote.model.QuizModel;
import com.example.myapplication.remote.model.WordModel;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class GuessCardRecViewAdapter extends RecyclerView.Adapter<GuessCardRecViewAdapter.GuessCardViewHolder> {
    private Context context;
    private NavController nav;
    private List<String> wordIds;
    private List<QuizModel> quizzes = new ArrayList<>();
    private List<WordModel> words;

    public GuessCardRecViewAdapter(Context context, NavController navController) {
        this.context = context;
        this.nav = nav;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setWordId(List<String> wordIds) {
        this.wordIds = wordIds;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GuessCardRecViewAdapter.GuessCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull GuessCardRecViewAdapter.GuessCardViewHolder holder, int position) {
//        WordModel item = words.get(position);
//        holder.hint.setText(item.hint);

        QuizModel item = quizzes.get(position);
        holder.hint.setText(item.wordList.toString());

        holder.card.setOnClickListener(v->{
            Toast.makeText(context, item.wordList.toString(),Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class GuessCardViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout card;
        private TextView hint;
        public GuessCardViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card_guess);
            hint = itemView.findViewById(R.id.txt_hint);

        }
    }
}
