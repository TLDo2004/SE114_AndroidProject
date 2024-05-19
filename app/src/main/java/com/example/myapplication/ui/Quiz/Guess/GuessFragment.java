package com.example.myapplication.ui.Quiz.Guess;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.myapplication.R;
import com.example.myapplication.databinding.GuessFragmentBinding;

public class GuessFragment extends Fragment {
    private GuessFragmentBinding binding;
    private LinearLayout btnBack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = GuessFragmentBinding.inflate(inflater, container, false);
        initiate(binding);

        NavController navController = Navigation.findNavController(container);
        btnBack.setOnClickListener(v -> {
            navController.navigate(R.id.action_guess_to_quiz, null);
        });

        return binding.getRoot();
    }

    private void initiate(GuessFragmentBinding binding) {
        btnBack = binding.btnBack;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
