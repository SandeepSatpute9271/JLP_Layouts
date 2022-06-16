package com.app.jlp_layouts.data.models.response.login;/*
 * Created by Sandeep(Techno Learning) on 15,June,2022
 */

import com.app.jlp_layouts.utils.ApiConstants;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "AuthenticateUserResponse", strict = false)
@Namespace(reference = ApiConstants.NAMESPACE)
public class LoginResponseData {

    @Element(name = "userId", required = false)
    private String userId;

    @Element(name = "userName", required = false)
    private String userName;

    @Element(name = "deliveryCentreId", required = false)
    private String deliveryCentreId;

    @Element(name = "deliveryCentreName", required = false)
    private String deliveryCentreName;

    @Element(name = "isHandoverAllowed", required = false)
    private boolean isHandoverAllowed;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeliveryCentreId() {
        return deliveryCentreId;
    }

    public void setDeliveryCentreId(String deliveryCentreId) {
        this.deliveryCentreId = deliveryCentreId;
    }

    public String getDeliveryCentreName() {
        return deliveryCentreName;
    }

    public void setDeliveryCentreName(String deliveryCentreName) {
        this.deliveryCentreName = deliveryCentreName;
    }

    public boolean isHandoverAllowed() {
        return isHandoverAllowed;
    }

    public void setHandoverAllowed(boolean handoverAllowed) {
        isHandoverAllowed = handoverAllowed;
    }

    @Override
    public String toString() {
        return "LoginResponseData{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", deliveryCentreId='" + deliveryCentreId + '\'' +
                ", deliveryCentreName='" + deliveryCentreName + '\'' +
                ", isHandoverAllowed=" + isHandoverAllowed +
                '}';
    }
}
