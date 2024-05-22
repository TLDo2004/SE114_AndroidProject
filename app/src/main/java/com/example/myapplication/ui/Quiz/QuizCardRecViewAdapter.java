package com.example.myapplication.ui.Quiz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
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

import android.content.Context;
import android.widget.ImageView;
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

        Bundle bundle = new Bundle();
        bundle.putString("quizId", item.id);

        holder.name.setText(item.name);
        holder.des.setText(item.des);
        holder.ponit.setText(String.valueOf(item.point));
        switch (item.type) {
            case "guess":
                holder.imgTitle.setBackgroundResource(R.drawable.png_guess);
                break;
            case "fill":
                holder.imgTitle.setBackgroundResource(R.drawable.png_fill);
                break;
            case "compound":
                holder.imgTitle.setBackgroundResource(R.drawable.png_compound);
                break;
            case "sound":
                holder.imgTitle.setBackgroundResource(R.drawable.png_listen);
                break;
            default:
                holder.imgTitle.setBackgroundResource(R.color.background);
                break;
        }
        holder.card.setOnClickListener(v -> {
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
        private ImageView imgTitle;
        private TextView name, des, ponit;
        public QuizCardViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card_quiz);
            imgTitle = itemView.findViewById(R.id.img_title);
            name = itemView.findViewById(R.id.txt_name);
            des = itemView.findViewById(R.id.txt_des);
            ponit = itemView.findViewById(R.id.txt_point);
        }
    }
}
