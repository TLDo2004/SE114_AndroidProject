package com.example.myapplication.ui.revision;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.example.myapplication.databinding.RevisionFragmentBinding;
import com.example.myapplication.remote.repo.RevisionRepo;
import com.example.myapplication.remote.model.RevisionModel;

import java.util.List;

public class RevisionFragment extends Fragment {
    private RevisionFragmentBinding binding;
    private RevisionRepo revisionRepo;
    private TextView review;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = RevisionFragmentBinding.inflate(inflater, container, false);
        initiate(binding);

        // GET ALL REVISION
        revisionRepo = new RevisionRepo();
        revisionRepo.getRevision().observe(getViewLifecycleOwner(), new Observer<List<RevisionModel>>() {
            @Override
            public void onChanged(List<RevisionModel> revisionModels) {
                Toast.makeText(getActivity().getApplicationContext(), "Hello", Toast.LENGTH_SHORT).show();
            }
        });
        // GET REVISION BY ID
        /*
        revisionRepo.getRevisionById("").observe(getViewLifecycleOwner(), new Observer<RevisionModel>() {
            @Override
            public void onChanged(RevisionModel revisionModel) {
                review.setText(revisionModel.cre_dt.toString());
            }
        });

         */
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