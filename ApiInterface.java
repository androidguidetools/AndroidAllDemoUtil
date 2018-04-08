package com.retrofitdemo.retrofitlearnigtopics.rest;

import com.retrofitdemo.retrofitlearnigtopics.model.AppList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by KP on 4/8/2018.
 */

public interface ApiInterface {

    @POST("moreapp.json")
    Call<List<AppList>> getAppList();
}
