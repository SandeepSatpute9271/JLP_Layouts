package com.app.jlp_layouts.data.models.response.login;/*
 * Created by Sandeep(Techno Learning) on 15,June,2022
 */

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@Root(name = "soap12:Envelope")
@NamespaceList({
        @Namespace( prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace( prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema"),
        @Namespace( prefix = "soap12", reference = "http://www.w3.org/2003/05/soap-envelope")
})
public class LoginResponseEnvelope {

    @Element(name = "Body", required = false)
    private LoginResponseBody body;

    public LoginResponseBody getBody() {
        return body;
    }

    public void setBody(LoginResponseBody body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "BrailleTextResponseEnvelope{" +
                "body=" + body +
                '}';
    }
}
