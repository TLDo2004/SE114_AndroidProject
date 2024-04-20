package com.example.myapplication.ui.revision;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.RevisionFragmentBinding;

public class RevisionFragment extends Fragment {
    private RevisionFragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = RevisionFragmentBinding.inflate(inflater, container, false);
        initiate(binding);

        // GET ALL REVISION

        // GET REVISION BY ID

        return binding.getRoot();
    }

    private void initiate(RevisionFragmentBinding binding) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}