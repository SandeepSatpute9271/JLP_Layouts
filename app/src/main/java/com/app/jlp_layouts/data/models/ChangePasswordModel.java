package com.app.jlp_layouts.data.models;/*
 * Created by Sandeep(Techno Learning) on 13,June,2022
 */

public class ChangePasswordModel {

    private String userName;
    private String password;
    private String newPassword;
    private String confirmPassword;

    public ChangePasswordModel(String userName, String password, String newPassword, String confirmPassword) {
        this.userName = userName;
        this.password = password;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
