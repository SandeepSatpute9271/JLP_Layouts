package com.app.jlp_layouts.presenter;/*
 * Created by Sandeep(Techno Learning) on 10,June,2022
 */

import android.text.TextUtils;
import android.util.Log;

import com.app.jlp_layouts.R;
import com.app.jlp_layouts.utils.Constants;
import com.app.jlp_layouts.view.LoginView;

public class LoginPresenter extends BasePresenter<LoginView> {

    private final String data;

    public LoginPresenter(LoginView view, String data) {
        super(view);
        this.data = data;
    }

    public void onAttach() {
        // init work
    }

    public void login(String username, String password) {
        view.showProgress();
        if (validate(username, password)) {
            doLogin(username, password);
        }
    }

    public boolean validate(String username, String password) {
        if(TextUtils.isEmpty(username) && TextUtils.isEmpty(password)){
            view.showErrorMessage(R.string.please_enter_user_id_and_password);
            return false;
        }if(TextUtils.isEmpty(username)){
            view.showErrorMessage(R.string.please_enter_user_id);
            return false;
        }else if(TextUtils.isEmpty(password)){
            view.showErrorMessage(R.string.please_enter_password);
            return false;
        }else if(password.length() < Constants.MIN_PASSWORD_LENGTH || password.length() > Constants.MAX_PASSWORD_LENGTH){
            view.showErrorMessage(R.string.password_should_be);
            return false;
        }else {
            view.hideProgress();
            view.clearViews();
            return true;
        }
    }

    private void doLogin(String username, String password) {
        view.navigateToHome();
    }
}