package com.app.jlp_layouts.data.models;/*
 * Created by Sandeep(Techno Learning) on 13,June,2022
 */

import com.app.jlp_layouts.presenter.LoginPresenter;

public class LoginModel {

    private static final String TAG = LoginModel.class.getSimpleName();
    private LoginPresenter presenter;

    public LoginModel(LoginPresenter presenter) {
        this.presenter = presenter;
    }

}
