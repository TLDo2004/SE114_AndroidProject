package com.example.myapplication.remote.service;

import com.example.myapplication.remote.model.TopicModel;
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
    @POST("api/users")
    Call<UserModel> createUser(@Body UserModel user);
    @GET("api/users")
    Call<List<UserModel>> getUser();
    @GET("api/users/{name}")
    Call<UserModel> getUserByName(@Path("name") String name);
}
