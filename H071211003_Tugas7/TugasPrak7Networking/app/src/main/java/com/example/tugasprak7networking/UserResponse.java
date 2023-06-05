package com.example.tugasprak7networking;

import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("first_name")
    private String first_name;

    @SerializedName("last_name")
    private String last_name;
    @SerializedName("id")
    private int id;
    @SerializedName("email")
    private String email;

    @SerializedName("avatar")
    private String avatarImage;

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatarImg() {
        return avatarImage;
    }

}
