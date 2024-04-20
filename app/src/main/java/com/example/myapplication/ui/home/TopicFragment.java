package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.example.myapplication.databinding.TopicFragmentBinding;
import com.example.myapplication.remote.model.WordModel;
import com.example.myapplication.remote.repo.WordRepo;

import java.util.List;

public class TopicFragment extends Fragment {

    private TopicFragmentBinding binding;
    private WordRepo wordRepo;
    private TextView home;
    private EditText editText;
    private Button btn;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = TopicFragmentBinding.inflate(inflater, container, false);
        initiate(binding);

        wordRepo.getWordById("660e26f1a795211f39fced0f").observe(getViewLifecycleOwner(), new Observer<WordModel>() {
            @Override
            public void onChanged(WordModel word) {
                home.setText(word.word);

            }
        });
        String word = "SECOND";
        WordModel wordModel = new WordModel(word);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                wordRepo.updateWord("660e26f1a795211f39fced0f", wordModel).observe(getViewLifecycleOwner(), new Observer<WordModel>() {
                    @Override
                    public void onChanged(WordModel word) {
                        home.setText(word.word);

                    }
                });
            }
        });


        return binding.getRoot();
    }



    private void initiate(TopicFragmentBinding binding) {
        wordRepo = new WordRepo();
        home = binding.textHome;
        editText = binding.editText;
        btn = binding.btnSend;

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}