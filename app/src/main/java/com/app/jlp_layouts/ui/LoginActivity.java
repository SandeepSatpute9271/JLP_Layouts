package com.app.jlp_layouts.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.app.jlp_layouts.databinding.ActivityLoginBinding;
import com.app.jlp_layouts.presenter.LoginPresenter;
import com.app.jlp_layouts.ui.activities.BaseActivity;
import com.app.jlp_layouts.view.LoginView;
import androidx.annotation.NonNull;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    private @NonNull ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loginClicked(LoginActivity.this);
            }
        });

        presenter.onAttach();
    }


    @NonNull
    @Override
    protected LoginPresenter createPresenter() {
        String data = "Data";
        return new LoginPresenter(this, data);
    }

    @Override
    public void showData(String data) {

    }

    @Override
    public void showErrorMessage() {

    }

    @Override
    public void performLogin(Context context) {
        Intent intent = new Intent(context, ChangePasswordActivity.class);
        context.startActivity(intent);
    }
}