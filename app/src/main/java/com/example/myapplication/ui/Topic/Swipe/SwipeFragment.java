package com.example.myapplication.ui.Topic.Swipe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.myapplication.R;
import com.example.myapplication.databinding.SwipeFragmentBinding;

public class SwipeFragment extends Fragment {
    private SwipeFragmentBinding binding;
    private LinearLayout btnBack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = SwipeFragmentBinding.inflate(inflater, container, false);
        initiate(binding);

        NavController navController = Navigation.findNavController(container);

        btnBack.setOnClickListener(v -> {
            navController.navigate(R.id.action_swipe_to_topic, null);
        });

        return binding.getRoot();
    }

    private void initiate(SwipeFragmentBinding binding) {
        btnBack = binding.btnBack;
    }

}
