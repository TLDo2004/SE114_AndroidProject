package com.example.myapplication.ui.Quiz.Guess;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.remote.model.QuizModel;
import com.example.myapplication.remote.model.WordModel;
import com.example.myapplication.ui.Quiz.QuizCardRecViewAdapter;

import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GuessCardRecViewAdapter extends RecyclerView.Adapter<GuessCardRecViewAdapter.GuessCardViewHolder> {

    private Context context;
    private List<WordModel> words;
    public GuessCardRecViewAdapter(Context context){this.context = context;};
    @NonNull
    @Override
    public GuessCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.guess_basic_fragment, parent, false);
        return new GuessCardViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull GuessCardRecViewAdapter.GuessCardViewHolder holder, @SuppressLint("RecyclerView") int position) {
        WordModel word = words.get(position); // Lấy từng từ từ danh sách
        holder.def.setText(word.getDef()); // Đặt định nghĩa của từ vào TextView
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class GuessCardViewHolder extends RecyclerView.ViewHolder {
        // Your view holder implementation
        RelativeLayout card;
        private  TextView def;
        public GuessCardViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize your view holder components
            card = itemView.findViewById(R.id.card_guess);
            def = itemView.findViewById(R.id.txt_def);
        }
    }
}
