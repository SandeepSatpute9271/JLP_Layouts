package com.app.jlp_layouts.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.app.jlp_layouts.R;
import com.app.jlp_layouts.databinding.ActivityLoginBinding;
import com.app.jlp_layouts.presenter.LoginPresenter;
import com.app.jlp_layouts.ui.activities.BaseActivity;
import com.app.jlp_layouts.utils.Utils;
import com.app.jlp_layouts.view.LoginView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    private @NonNull ActivityLoginBinding binding;
    protected final String TAG = getClass().getSimpleName();
    private ProgressDialog mProgressDialog;

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
    public void showErrorMessage(int messageId) {
        showToast(getResources().getString(messageId));
    }

    @Override
    public void clearViews() {
        binding.layoutUsername.inputUsername.setText("");
        binding.layoutPassword.inputPassword.setText("");
    }

    @Override
    public void showProgress() {
        hideProgress();
        mProgressDialog = Utils.showLoadingDialog(this);
    }

    @Override
    public void hideProgress() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(this, ChangePasswordActivity.class);
        startActivity(intent);
        finish();
    }

//    private void showSnackBar(String message) {
//        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
//                message, Snackbar.LENGTH_SHORT);
//        View sbView = snackbar.getView();
//        TextView textView = (TextView) sbView
//                .findViewById(android.support.design.R.id.snackbar_text);
//        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
//        snackbar.show();
//    }
}