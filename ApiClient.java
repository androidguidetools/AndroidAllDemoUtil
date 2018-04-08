package com.retrofitdemo.retrofitlearnigtopics.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by KP on 4/8/2018.
 */

public class ApiClient {

    public static final String BASE_URL = "https://samarthshah2866.000webhostapp.com/lovevideostatus/";
    public static Retrofit retrofit;

    public static Retrofit getApiClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
