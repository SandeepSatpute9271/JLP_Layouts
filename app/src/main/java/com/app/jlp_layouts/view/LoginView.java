package com.app.jlp_layouts.view;/*
 * Created by Sandeep(Techno Learning) on 10,June,2022
 */

import android.content.Context;

public interface LoginView extends BaseView {

    void navigateToHome();

    void showErrorMessage(String message);
}
