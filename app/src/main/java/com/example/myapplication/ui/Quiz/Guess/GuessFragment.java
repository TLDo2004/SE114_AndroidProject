package com.example.myapplication.ui.Quiz.Guess;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.GuessFragmentBinding;

public class GuessFragment extends Fragment {
    private GuessFragmentBinding binding;
    private TextView mock;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = GuessFragmentBinding.inflate(inflater, container, false);
        initiate(binding);



        return binding.getRoot();
    }

    private void initiate(GuessFragmentBinding binding) {
        mock = binding.mockId;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
