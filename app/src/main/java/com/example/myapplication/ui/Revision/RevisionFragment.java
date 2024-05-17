package com.example.myapplication.ui.Revision;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.RevisionFragmentBinding;
import com.example.myapplication.remote.model.RevisionModel;
import com.example.myapplication.remote.model.WordModel;
import com.example.myapplication.remote.repo.RevisionRepo;
import com.example.myapplication.remote.repo.WordRepo;

import java.util.List;


import java.util.List;

public class RevisionFragment extends Fragment {
    private RevisionFragmentBinding binding;
    private RevisionRepo revisionRepo;
    private RevisionCardRecViewAdapter revisionCardAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = RevisionFragmentBinding.inflate(inflater, container, false);
        initiate(binding);
        setupRecyclerView(binding);

        revisionRepo.getRevision().observe(getViewLifecycleOwner(), new Observer<List<RevisionModel>>() {
            @Override
            public void onChanged(List<RevisionModel> revisions) {
                revisionCardAdapter.setRevisions(revisions);
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void initiate(RevisionFragmentBinding binding) {
        revisionRepo = new RevisionRepo();
        revisionCardAdapter = new RevisionCardRecViewAdapter(getContext());
    }

    private void setupRecyclerView(RevisionFragmentBinding binding) {
        RecyclerView rec = binding.revisionRecView;
        rec.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        rec.setAdapter(revisionCardAdapter);

        rec.setHasFixedSize(true);
    }
}