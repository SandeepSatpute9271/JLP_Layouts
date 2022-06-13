package com.app.jlp_layouts.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.app.jlp_layouts.databinding.ActivityLoginBinding;
import com.app.jlp_layouts.presenter.LoginPresenter;
import com.app.jlp_layouts.ui.activities.BaseActivity;
import com.app.jlp_layouts.view.LoginView;
import androidx.annotation.NonNull;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    private @NonNull ActivityLoginBinding binding;
    protected final String TAG = getClass().getSimpleName();
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter.onAttach();

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.login(binding.layoutUsername.inputUsername.getText().toString(), binding.layoutPassword.inputPassword.getText().toString());
            }
        });
    }


    @NonNull
    @Override
    protected LoginPresenter createPresenter() {
        String data = "Data";
        return new LoginPresenter(this, data);
    }

    @Override
    public void showErrorMessage(String message) {
        if (message == null || message.isEmpty()) return;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress() {
        if (mDialog != null && mDialog.isShowing()) {
            return;
        }
        mDialog = new ProgressDialog(this);
        mDialog.setMessage("Loading...");
        mDialog.setCancelable(false);
        mDialog.show();
    }

    @Override
    public void hideProgress() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(this, ChangePasswordActivity.class);
        startActivity(intent);
        //finish();

        //  startActivity(new Intent(this,ChangePasswordActivity.class));
        //        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        //
    }
}