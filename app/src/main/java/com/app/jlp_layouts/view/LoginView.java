package com.app.jlp_layouts.view;/*
 * Created by Sandeep(Techno Learning) on 10,June,2022
 */

import android.content.Context;

public interface LoginView extends BaseView {
    void showData(String data);

    void showErrorMessage();

    void performLogin(Context context);
}