package com.app.jlp_layouts.data.models.request.login;/*
 * Created by Sandeep(Techno Learning) on 15,June,2022
 */

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Need to check AuthenticationDetails attr
@Root(name = "soapenv:Body", strict = false)
public class LoginRequestBody {

    @Element(name = "AuthenticationDetails",required = false)
    private LoginRequestData loginRequestData;

    public LoginRequestData getBrailleTextRequestData() {
        return loginRequestData;
    }

    public void setLoginRequestData(LoginRequestData loginRequestData) {
        this.loginRequestData = loginRequestData;
    }
}
