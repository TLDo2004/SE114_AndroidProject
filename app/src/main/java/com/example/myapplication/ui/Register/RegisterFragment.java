package com.example.myapplication.ui.Register;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.LoginFragmentBinding;
import com.example.myapplication.databinding.RegisterFragmentBinding;

public class RegisterFragment extends Fragment {
    private RegisterFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = RegisterFragmentBinding.inflate(inflater, container, false);
        init(binding);


        return binding.getRoot();
    }

    void init(RegisterFragmentBinding binding) {


    }
}
