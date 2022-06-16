package com.app.jlp_layouts.data.network;/*
 * Created by Sandeep(Techno Learning) on 15,June,2022
 */

import androidx.annotation.NonNull;

import com.app.jlp_layouts.utils.ApiConstants;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Ganesha on 12/12/2016.
 */

public class ApiClient {

    public static ApiInterface getApi() {
        return getRetrofit().create( ApiInterface.class );
    }

    @NonNull
    protected static Retrofit getRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Strategy strategy = new AnnotationStrategy();

        Serializer serializer = new Persister(strategy);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(ApiConstants.CONNECT_TIME_OUT_IN_MIN, TimeUnit.MINUTES)
                .writeTimeout(ApiConstants.WRITE_TIME_OUT_IN_MIN, TimeUnit.MINUTES)
                .readTimeout(ApiConstants.READ_TIME_OUT_IN_MIN, TimeUnit.MINUTES)
                .build();

        return new Retrofit.Builder()
                .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                .baseUrl(ApiConstants.API_BASE_URL)
                .client(okHttpClient)
                .build();
    }
}
