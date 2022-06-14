package com.app.jlp_layouts.view;/*
 * Created by Sandeep(Techno Learning) on 10,June,2022
 */

public interface ChangesPasswordView extends BaseView {

    void navigateToLogin();

    void showErrorMessage(int messageId);

    void clearViews();

    void showProgress();

    void hideProgress();
}
