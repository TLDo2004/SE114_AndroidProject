package com.example.myapplication.ui.Login;

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
import com.example.myapplication.ui.Register.RegisterFragment;

public class LoginFragment extends Fragment {
    private LoginFragmentBinding binding;
    private Intent navToMain;
    private Button btnLogin, btnRegister;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = LoginFragmentBinding.inflate(inflater, container, false);
        init(binding);

//        btnLog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(navToMain);
//            }
//        });
//
//        btn_reg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment registerFragment = new RegisterFragment();
//                replaceFragment(registerFragment);
//            }
//        });
        btnLogin.setOnClickListener(v -> startActivity(navToMain));

        btnRegister.setOnClickListener(v -> {
            Fragment registerFragment = new RegisterFragment();
            replaceFragment(registerFragment);
        });

        return binding.getRoot();
    }

    void init(LoginFragmentBinding binding) {
        navToMain = new Intent(getActivity(), MainActivity.class);
        btnLogin = binding.btnLog;
        btnRegister = binding.btnRegister;

    }

    public void replaceFragment(Fragment fragment) {
        getParentFragmentManager().beginTransaction()
                .replace(R.id.landing_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
