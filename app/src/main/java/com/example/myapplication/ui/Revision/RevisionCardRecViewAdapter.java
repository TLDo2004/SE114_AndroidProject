package com.example.myapplication.ui.Revision;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.remote.model.RevisionModel;
import com.example.myapplication.remote.model.TopicModel;
import com.example.myapplication.remote.model.WordModel;
import com.example.myapplication.ui.Topic.TopicCardRecViewAdapter;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RevisionCardRecViewAdapter extends RecyclerView.Adapter<RevisionCardRecViewAdapter.RevisionCardViewHolder>{
    private Context context;
    private List<RevisionModel> revisions = new ArrayList<>();
    public RevisionCardRecViewAdapter(Context context) {this.context = context;}

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
/*
        List<String> list = new ArrayList<>();
        for (WordModel w : item.wordList) {
            list.add(w.word);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String i : list) {
            stringBuilder.append(i).append("\n");
        }
   //     holder.words.setText(stringBuilder);
*/
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
