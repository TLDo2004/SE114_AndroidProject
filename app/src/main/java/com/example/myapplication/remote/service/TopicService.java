package com.example.myapplication.remote.service;

import com.example.myapplication.remote.model.TopicModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TopicService {
    @POST("api/topics")
    Call<TopicModel> createTopic(@Body TopicModel topic);
    @GET("api/topics")
    Call<List<TopicModel>> getTopic();
    @GET("api/topics/{id}")
    Call<TopicModel> getTopicById(@Path("id") String id);
//    @FormUrlEncoded
//    @PATCH("api/topics/{id}")
//    Call<TopicModel> updateTopic();
//    @DELETE("api/topics/{id}")
//    Call<TopicModel> deleteTopic(@Path("id") String id);
}
