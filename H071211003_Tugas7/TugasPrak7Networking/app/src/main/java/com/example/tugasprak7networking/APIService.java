package com.example.tugasprak7networking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    @GET("api/users/{id}")
    Call<ProfileResponse> getUserById (@Path("id") String id);
    @GET("api/users")
    Call<UsersResponse> getUsers(@Query("per_page") String per_page);

}
