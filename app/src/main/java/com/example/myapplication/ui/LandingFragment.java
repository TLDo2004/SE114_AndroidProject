package com.example.myapplication.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.LandingFragmentBinding;
import com.example.myapplication.ui.Login.LoginFragment;
import com.example.myapplication.ui.Register.RegisterFragment;

public class LandingFragment extends Fragment {
    private LandingFragmentBinding binding;
    private Button landingLoginBtn;
    private LinearLayout landingRegisterTxtBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = LandingFragmentBinding.inflate(inflater, container, false);
        initiate(binding);

        landingLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment loginFragment = new LoginFragment();
                replaceFragment(loginFragment);

            }
        });

//        landingRegisterTxtBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment registerFragment = new RegisterFragment();
//                replaceFragment(registerFragment);
//            }
//        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void initiate(LandingFragmentBinding binding) {
        landingLoginBtn = binding.btnLandingLogin;
//        landingRegisterTxtBtn = binding.txtBtnLandingRegister;
    }

    public void replaceFragment(Fragment fragment) {
        getParentFragmentManager().beginTransaction()
                .replace(R.id.landing_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
