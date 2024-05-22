package com.example.myapplication.remote.service;

import com.example.myapplication.remote.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {
    @FormUrlEncoded
    @POST("api/users")
    Call<UserModel> createUser(
            @Field("name") String name,
            @Field("email") String email,
            @Field("pass") String pass
    );
    @GET("api/users")
    Call<List<UserModel>> getUser();
    @GET("api/users/{name}")
    Call<UserModel> getUserById(@Path("name") String name);
}
