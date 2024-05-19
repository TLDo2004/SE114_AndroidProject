package com.example.myapplication.ui.Topic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.remote.model.TopicModel;

import java.util.ArrayList;
import java.util.List;

public class TopicCardRecViewAdapter extends RecyclerView.Adapter<TopicCardRecViewAdapter.TopicCardViewHolder>{
    private Context context;
    private List<TopicModel> topics = new ArrayList<>();
    private NavController nav;
    public TopicCardRecViewAdapter(Context context,NavController nav) {
        this.context = context;
        this.nav = nav;
    }

    @NonNull
    @Override
    public TopicCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_card_fragment, parent,false);
        return new TopicCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicCardViewHolder holder, int position) {
        TopicModel item =  topics.get(position);
        holder.name.setText(item.name);
        holder.des.setText(item.des);
        //holder.prog.setText(item.prog);

        holder.card.setOnClickListener(v -> {
            nav.navigate(R.id.action_topic_to_swipe, null);
        });

    }

    @SuppressLint("NotifyDataSetChanged")
    public void setTopics(List<TopicModel> topics) {
        this.topics = topics;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return topics.size();
    }

    public static class TopicCardViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout card;
        private TextView name, des, prog;
        public TopicCardViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card_topic);
            name = itemView.findViewById(R.id.txt_name);
            des = itemView.findViewById(R.id.txt_des);
            prog = itemView.findViewById(R.id.txt_prog);
        }
    }
}
