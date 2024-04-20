package com.example.myapplication.remote.service;

import com.example.myapplication.remote.model.RevisionModel;
import com.example.myapplication.remote.model.WordModel;

import java.time.LocalDateTime;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RevisionService {
    @POST("api/revisions")
    Call<RevisionModel> createRevision(@Body RevisionModel revision);
    @GET("api/revisions")
    Call<List<RevisionModel>> getRevision();
    @GET("api/revisions/{id}")
    Call<RevisionModel> getRevisionById(@Path("id") String id);
    @FormUrlEncoded
    @PATCH("api/revisions/{id}")
    Call<RevisionModel> updateRevision(
            @Path("id") String id,
            @Body RevisionModel revision
//            @Field LocalDateTime cre_dt ,
//            @Field LocalDateTime alarm_dt,
//            @Field int interval
    );
    @DELETE("api/revisions/{id}")
    Call<RevisionModel> deleteRevision(@Path("id") String id);
}
