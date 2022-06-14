package com.app.jlp_layouts.presenter;/*
 * Created by Sandeep(Techno Learning) on 10,June,2022
 */

import android.text.TextUtils;

import com.app.jlp_layouts.R;
import com.app.jlp_layouts.utils.Constants;
import com.app.jlp_layouts.utils.Utils;
import com.app.jlp_layouts.view.ChangesPasswordView;
import com.app.jlp_layouts.view.LoginView;

public class ChangePasswordPresenter extends BasePresenter<ChangesPasswordView> {

    private final String data;

    public ChangePasswordPresenter(ChangesPasswordView view, String data) {
        super(view);
        this.data = data;
    }

    public void onAttach() {
        // init work
    }

    public void changePassword(String username, String oldPassword, String newPassword, String confirmPassword) {
        view.showProgress();
        if (validate(username, oldPassword, newPassword, confirmPassword)) {
            doLogin(username, oldPassword);
        }
    }

    // TODO: Old password match remaining
    public boolean validate(String username, String oldPassword, String newPassword, String confirmPassword) {
        if(TextUtils.isEmpty(oldPassword)){
            view.showErrorMessage(R.string.please_enter_old_password);
            return false;
        }if(TextUtils.isEmpty(newPassword) && TextUtils.isEmpty(confirmPassword)){
            view.showErrorMessage(R.string.please_enter_new_password_and_confirm);
            return false;
        }else if(newPassword.length() < Constants.MIN_PASSWORD_LENGTH || newPassword.length() > Constants.MAX_PASSWORD_LENGTH){
            view.showErrorMessage(R.string.new_password_should_be);
            return false;
        }else if(Utils.isValidPassword(newPassword)){
            view.showErrorMessage(R.string.at_least_one_alpha_one_num_req);
            return false;
        }else if(!newPassword.equals(confirmPassword)){
            view.showErrorMessage(R.string.new_password_and_confirm_password_mismatch);
            return false;
        }else {
            view.hideProgress();
            view.navigateToLogin();
            return true;
        }
    }

    private void doLogin(String username, String password) {
        view.navigateToLogin();
    }
}