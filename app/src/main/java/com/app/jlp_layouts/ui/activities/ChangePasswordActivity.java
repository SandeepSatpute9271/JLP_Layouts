package com.app.jlp_layouts.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.app.jlp_layouts.R;
import com.app.jlp_layouts.databinding.ActivityChangePasswordBinding;
import com.app.jlp_layouts.databinding.ActivityLoginBinding;
import com.app.jlp_layouts.presenter.ChangePasswordPresenter;
import com.app.jlp_layouts.presenter.LoginPresenter;
import com.app.jlp_layouts.utils.Utils;
import com.app.jlp_layouts.view.ChangesPasswordView;
import com.app.jlp_layouts.view.LoginView;

public class ChangePasswordActivity extends BaseActivity<ChangePasswordPresenter> implements ChangesPasswordView {

    private @NonNull
    ActivityChangePasswordBinding binding;
    protected final String TAG = getClass().getSimpleName();
    private ProgressDialog mProgressDialog;

    @NonNull
    @Override
    protected ChangePasswordPresenter createPresenter() {
        String data = "Data";
        return new ChangePasswordPresenter(this, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangePasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if(getSupportActionBar()!=null)getSupportActionBar().hide();

        presenter.onAttach();

        binding.btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.changePassword(binding.inputUsername.getText().toString(),
                        binding.inputOldPassword.getText().toString(),
                        binding.inputNewPassword.getText().toString(),
                        binding.inputConfirmPassword.getText().toString());
            }
        });
    }

    @Override
    public void navigateToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showErrorMessage(int messageId) {
        showToast(getResources().getString(messageId));
    }

    @Override
    public void clearViews() {
        //binding.inputUsername.setText("");
        binding.inputOldPassword.setText("");
        binding.inputNewPassword.setText("");
        binding.inputConfirmPassword.setText("");
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
}