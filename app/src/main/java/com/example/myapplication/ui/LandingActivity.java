package com.example.myapplication.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.databinding.LandingActivityBinding;
import com.example.myapplication.local.LocalStorage;

public class LandingActivity extends AppCompatActivity {
   private SharedPreferences sharedPreferences;
   private LandingActivityBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LandingActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = LocalStorage.getInstance(this);
        String accessToken = sharedPreferences.getString("access_token", null);

        Intent intent = new Intent(LandingActivity.this, MainActivity.class);
        if (accessToken != null) {
            startActivity(intent);
        } else {
            replaceFragment(new LandingFragment());
        }
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.landing_container, fragment)
                .addToBackStack(null)  // Optional: Add transaction to back stack
                .commit();
    }
}
