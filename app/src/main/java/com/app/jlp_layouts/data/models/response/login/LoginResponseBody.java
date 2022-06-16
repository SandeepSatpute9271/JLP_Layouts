package com.app.jlp_layouts.data.models.response.login;/*
 * Created by Sandeep(Techno Learning) on 15,June,2022
 */

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Body", strict = false)
public class LoginResponseBody {

    @Element(name = "LoginResponse",required = false)
    private LoginResponseData loginResponseData;

    public LoginResponseData getLoginResponseData() {
        return loginResponseData;
    }

    public void setBrailleTextResponseData(LoginResponseData loginResponseData) {
        this.loginResponseData = loginResponseData;
    }

    @Override
    public String toString() {
        return "BrailleTextResponseBody{" +
                "brailleTextResponseData=" + loginResponseData +
                '}';
    }
}
