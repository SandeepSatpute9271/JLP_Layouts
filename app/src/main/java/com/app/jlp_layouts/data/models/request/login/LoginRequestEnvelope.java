package com.app.jlp_layouts.data.models.request.login;/*
 * Created by Sandeep(Techno Learning) on 15,June,2022
 */

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;


//TODO: Check bellow reference while implementing the actual api
@Root(name = "soapenv:Envelope")
@NamespaceList({
        @Namespace( prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace( prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema"),
        @Namespace( prefix = "soap12", reference = "http://www.w3.org/2003/05/soap-envelope")
})
public
class LoginRequestEnvelope {

    @Element(name = "soapenv:Body", required = false)
    private LoginRequestBody body;

    public LoginRequestBody getBody() {
        return body;
    }

    public void setBody(LoginRequestBody body) {
        this.body = body;
    }
}
