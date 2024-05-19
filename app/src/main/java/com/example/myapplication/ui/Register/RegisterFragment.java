package com.example.myapplication.ui.Register;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.databinding.LoginFragmentBinding;
import com.example.myapplication.databinding.RegisterFragmentBinding;
import com.example.myapplication.ui.Login.LoginFragment;

public class RegisterFragment extends Fragment {
    private RegisterFragmentBinding binding;
    private Intent navToMain;
    private Button btnRegister, btnLogin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = RegisterFragmentBinding.inflate(inflater, container, false);
        init(binding);

        btnRegister.setOnClickListener(v -> startActivity(navToMain));

        btnLogin.setOnClickListener(v -> {
            Fragment loginFragment = new LoginFragment();
            replaceFragment(loginFragment);
        });

        return binding.getRoot();
    }

    void init(RegisterFragmentBinding binding) {
        navToMain = new Intent(getActivity(), MainActivity.class);
        btnLogin = binding.btnLogin;
        btnRegister = binding.btnRegister;

    }

    public void replaceFragment(Fragment fragment) {
        getParentFragmentManager().beginTransaction()
                .replace(R.id.landing_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
