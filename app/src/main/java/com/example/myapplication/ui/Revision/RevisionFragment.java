package com.example.myapplication.ui.Revision;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.RevisionFragmentBinding;
import com.example.myapplication.remote.repo.RevisionRepo;

public class RevisionFragment extends Fragment {
    private RevisionFragmentBinding binding;
    private RevisionRepo revisionRepo;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = RevisionFragmentBinding.inflate(inflater, container, false);
        initiate(binding);



        return binding.getRoot();
    }

    private void initiate(RevisionFragmentBinding binding) {
        revisionRepo = new RevisionRepo();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}