package com.app.jlp_layouts.presenter;/*
 * Created by Sandeep(Techno Learning) on 10,June,2022
 */

import android.content.Context;

import com.app.jlp_layouts.view.LoginView;

public class LoginPresenter extends BasePresenter<LoginView> {

    private final String data;

    public LoginPresenter(LoginView view, String data) {
        super(view);
        this.data = data;
    }

    public void onAttach() {
        showData();
    }

    private void showData() {
        if (data != null) {
            view.showData(data);
        }
    }

    public void loginClicked(Context context) {
        view.performLogin(context);
    }
}