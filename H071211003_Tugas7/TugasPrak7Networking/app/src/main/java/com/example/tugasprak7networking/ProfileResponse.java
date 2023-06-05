package com.example.tugasprak7networking;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.annotations.SerializedName;

public class ProfileResponse {
    @SerializedName("data")
    private UserResponse user;

    public UserResponse getUser() {
        return user;
    }

}
