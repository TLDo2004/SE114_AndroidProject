package com.example.myapplication.ui.Profile;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ProfileFragmentBinding;
import com.example.myapplication.ui.LandingActivity;

public class ProfileFragment extends Fragment {
    private ProfileFragmentBinding binding;
    private RelativeLayout btnLogout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ProfileFragmentBinding.inflate(inflater, container, false);
        initiate(binding);

        Intent intent = new Intent(getActivity(), LandingActivity.class);
        btnLogout.setOnClickListener(v -> {
            showLogoutDialog(getContext(),intent);
        });

        return binding.getRoot();
    }

    private void initiate(ProfileFragmentBinding binding) {
        btnLogout = binding.btnLogout;
    }

    private void showLogoutDialog(Context context, Intent intent) {
        View dialogView = LayoutInflater.from(context).inflate(R.layout.custom_dialog, null);

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context)
                .setTitle("Logout")
                .setView(dialogView)
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });
        AlertDialog dialog = alertDialog.create();

        dialog.getWindow().setBackgroundDrawableResource(R.drawable.custom_shape2);
        dialog.show();
        dialog.setCancelable(false);
    }
}
