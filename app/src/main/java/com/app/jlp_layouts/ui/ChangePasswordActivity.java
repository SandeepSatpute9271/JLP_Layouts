package com.app.jlp_layouts.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.app.jlp_layouts.R;
import com.app.jlp_layouts.databinding.ActivityChangePasswordBinding;
import com.app.jlp_layouts.databinding.ActivityLoginBinding;

public class ChangePasswordActivity extends AppCompatActivity {

    private @NonNull
    ActivityChangePasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangePasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
    }
}