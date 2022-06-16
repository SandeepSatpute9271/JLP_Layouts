package com.app.jlp_layouts.data.models.request.login;/*
 * Created by Sandeep(Techno Learning) on 15,June,2022
 */

import com.app.jlp_layouts.utils.ApiConstants;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

//TODO: Check bellow reference while implementing the actual api
@Root(name = "AuthenticateUserRequest", strict = false)
@Namespace(reference = ApiConstants.NAMESPACE)
public class LoginRequestData {

    @Element(name = "userId", required = false)
    private String userId;
    @Element(name = "password", required = false)
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
