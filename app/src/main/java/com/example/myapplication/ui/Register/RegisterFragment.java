package com.example.myapplication.ui.Register;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.databinding.LoginFragmentBinding;
import com.example.myapplication.databinding.RegisterFragmentBinding;
import com.example.myapplication.remote.model.UserModel;
import com.example.myapplication.remote.repo.UserRepo;
import com.example.myapplication.ui.Login.LoginFragment;

public class RegisterFragment extends Fragment {
    private RegisterFragmentBinding binding;
    private Intent navToMain;
    private Button btnRegister, btnLogin;
    private EditText userName, email, password, confirmPassword;
    private TextView confirm;
    private UserRepo userRepo;
    private String u = null, e = null, p = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = RegisterFragmentBinding.inflate(inflater, container, false);
        init(binding);

        u = userName.getText().toString();
        e = email.getText().toString();
        p = password.getText().toString();

        btnRegister.setOnClickListener(v -> {
            if (password.getText().toString().equals(confirmPassword.getText().toString())) {
                confirm.setText("");
                userRepo.createUser(u, e, p).observe(getViewLifecycleOwner(), new Observer<UserModel>() {
                    @Override
                    public void onChanged(UserModel userModel) {
                        Log.d("API", "User created: " + userModel.name);
                    }
                });
                Toast.makeText(getContext(), "Register successfully!", Toast.LENGTH_SHORT).show();
                Fragment loginFragment = new LoginFragment();
                replaceFragment(loginFragment);
            }
            else {
                confirm.setText("Password didn't match!");
            }
        });

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
        userName = binding.editRegisterUsername;
        email = binding.editRegisterEmail;
        password = binding.editRegisterPassword;
        confirmPassword = binding.editRegisterConfirm;
        confirm = binding.textRegisterConfirm;
        userRepo = new UserRepo();
    }

    public void replaceFragment(Fragment fragment) {
        getParentFragmentManager().beginTransaction()
                .replace(R.id.landing_container, fragment)
                .addToBackStack(null)
                .commit();
    }

}
