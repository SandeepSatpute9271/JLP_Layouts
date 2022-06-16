package com.app.jlp_layouts.presenter;/*
 * Created by Sandeep(Techno Learning) on 10,June,2022
 */

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;

import com.app.jlp_layouts.R;
import com.app.jlp_layouts.data.models.request.login.LoginRequestBody;
import com.app.jlp_layouts.data.models.request.login.LoginRequestData;
import com.app.jlp_layouts.data.models.request.login.LoginRequestEnvelope;
import com.app.jlp_layouts.data.models.response.login.LoginResponseData;
import com.app.jlp_layouts.data.models.response.login.LoginResponseEnvelope;
import com.app.jlp_layouts.data.network.ApiClient;
import com.app.jlp_layouts.utils.Constants;
import com.app.jlp_layouts.utils.StringUtils;
import com.app.jlp_layouts.view.LoginView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter extends BasePresenter<LoginView> {

    private final String data;
    private static final String TAG = LoginPresenter.class.getSimpleName();

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

    private void doLogin(String userId, String password) {
        view.showProgress();

        // Creating envelope for the request
        LoginRequestEnvelope envelope = new LoginRequestEnvelope();
        LoginRequestBody body = new LoginRequestBody();
        LoginRequestData data = new LoginRequestData();
        data.setUserId(userId);
        data.setPassword(password);
        body.setLoginRequestData(data);
        envelope.setBody(body);

        Call<LoginResponseEnvelope> responseEnvelopeCall
                = ApiClient.getApi().login(envelope);
        responseEnvelopeCall.enqueue(new Callback<LoginResponseEnvelope>() {
            @Override
            public void onResponse(Call<LoginResponseEnvelope> call, Response<LoginResponseEnvelope> response) {
                if (response!=null) {
                    Log.i(TAG, "API call completed");
                    view.hideProgress();

                    Log.i(TAG, response.toString()+" ---- "+response.body().toString());

                    LoginResponseData data = ((LoginResponseEnvelope)response.body())
                            .getBody().getLoginResponseData();
                    if (StringUtils.hasValue(data.getUserName())) {
                        // Login success
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponseEnvelope> call, Throwable t) {
                view.hideProgress();
                t.printStackTrace();
            }
        });
    }
}