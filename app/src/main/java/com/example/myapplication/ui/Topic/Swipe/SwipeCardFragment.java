package com.example.myapplication.ui.Topic.Swipe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

import com.example.myapplication.remote.model.TopicModel;
import com.example.myapplication.remote.model.WordModel;

import java.util.List;

public class SwipeCardFragment extends ArrayAdapter<WordModel> {
    public SwipeCardFragment(Context context) {
        super(context, R.layout.swipe_card_fragment);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        WordModel currentWord = getItem(position);

        TextView txtWord = convertView.findViewById(R.id.txt_word);
        TextView txtPos = convertView.findViewById(R.id.txt_pos);
        TextView txtPronoun = convertView.findViewById(R.id.txt_pronun);
        TextView txtHint = convertView.findViewById(R.id.txt_hint);

        txtWord.setText(currentWord.word);
        txtPos.setText(currentWord.pos);
        txtPronoun.setText(currentWord.pronoun);
        txtHint.setText(currentWord.def);

        return convertView;
    }


}
