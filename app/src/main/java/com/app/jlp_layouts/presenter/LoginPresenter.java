package com.app.jlp_layouts.presenter;/*
 * Created by Sandeep(Techno Learning) on 10,June,2022
 */

import android.text.TextUtils;
import android.util.Log;

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
        Log.e("LoginACT", "login: "+username);
        Log.e("LoginACT", "login: "+password);
        if (validate(username, password)) {
            //view.showProgress();
            doLogin(username, password);
        }
    }

    public boolean validate(String username, String password) {
        if(TextUtils.isEmpty(username) && TextUtils.isEmpty(password)){
            view.showErrorMessage("");
            return false;
        }if(TextUtils.isEmpty(username)){
            view.showErrorMessage("Please enter User ID.");
            return false;
        }else if(TextUtils.isEmpty(password)){
            view.showErrorMessage("Please enter password");
            return false;
        }else if(password.length() < 5 || password.length() > 9){
            view.showErrorMessage("Password should be 6-8 characters long");
            return false;
        }else {
            view.hideProgress();
            doLogin(username, password);
            return true;
        }
    }

    private void doLogin(String username, String password) {
        view.navigateToHome();
    }
}