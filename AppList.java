package com.retrofitdemo.retrofitlearnigtopics.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by KP on 4/8/2018.
 */

public class AppList {

    @SerializedName("app_name")
    private String appName;

    @SerializedName("app_image_url")
    private String appImageUrl;

    @SerializedName("app_package")
    private String appPackage;


    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppImageUrl() {
        return appImageUrl;
    }

    public void setAppImageUrl(String appImageUrl) {
        this.appImageUrl = appImageUrl;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }
}
