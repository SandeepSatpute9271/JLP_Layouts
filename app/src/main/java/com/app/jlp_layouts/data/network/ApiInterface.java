package com.app.jlp_layouts.data.network;/*
 * Created by Sandeep(Techno Learning) on 15,June,2022
 */

import com.app.jlp_layouts.data.models.request.login.LoginRequestEnvelope;
import com.app.jlp_layouts.data.models.response.login.LoginResponseEnvelope;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @Headers({
            "Content-Type: text/xml",
            "Accept-Charset: utf-8"
    })
    @POST("/braille.asmx")
    Call<LoginResponseEnvelope> login(@Body LoginRequestEnvelope body);
}
