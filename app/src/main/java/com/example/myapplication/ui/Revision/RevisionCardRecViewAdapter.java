package com.example.myapplication.ui.Revision;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.remote.model.RevisionModel;
import com.example.myapplication.remote.model.TopicModel;
import com.example.myapplication.remote.model.WordModel;
import com.example.myapplication.remote.repo.WordRepo;
import com.example.myapplication.ui.Topic.TopicCardRecViewAdapter;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RevisionCardRecViewAdapter extends RecyclerView.Adapter<RevisionCardRecViewAdapter.RevisionCardViewHolder>{
    private Context context;
    private List<RevisionModel> revisions = new ArrayList<>();
    private WordRepo wordRepo;
    private LifecycleOwner lifecycleOwner;
    public RevisionCardRecViewAdapter(Context context) {this.context = context;}
    public RevisionCardRecViewAdapter(Context context, LifecycleOwner lifecycleOwner) {
        this.context = context;
        this.lifecycleOwner = lifecycleOwner;
    }

    @NonNull
    @Override
    public RevisionCardRecViewAdapter.RevisionCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.revision_card_fragment, parent,false);
        return new RevisionCardRecViewAdapter.RevisionCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RevisionCardRecViewAdapter.RevisionCardViewHolder holder, int position) {
        RevisionModel item = revisions.get(position);
        holder.cre_dt.setText(item.cre_dt);
        holder.alarm_dt.setText(item.alarm_dt);
        holder.interval.setText(String.valueOf(item.interval));

        wordRepo = new WordRepo();
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < item.wordIdList.size(); i++) {
            wordRepo.getWordById(item.wordIdList.get(i)).observe(lifecycleOwner, new Observer<WordModel>() {
                @Override
                public void onChanged(WordModel wordData) {
                    wordList.add(wordData.word);
                    if (wordList.size() == item.wordIdList.size()) {
                        String combinedWords = TextUtils.join("\n", wordList);
                        holder.words.setText(combinedWords);
                    }
                }
            });
        }

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Push to another Fragmnent (SCREEN)
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setRevisions(List<RevisionModel> revisions) {
        this.revisions = revisions;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return revisions.size();
    }

    public static class RevisionCardViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout card;
        private TextView cre_dt, alarm_dt, interval, words;
        public RevisionCardViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card_revision);
            cre_dt = itemView.findViewById(R.id.txt_cre_dt);
            alarm_dt = itemView.findViewById(R.id.txt_alarm_dt);
            interval = itemView.findViewById(R.id.txt_interval);
            words = itemView.findViewById(R.id.txt_words);
        }
    }
}
