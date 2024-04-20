package com.example.myapplication.remote.service;

import com.example.myapplication.remote.model.WordModel;

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

public interface WordService {
    @POST("api/words")
    Call<WordModel> createWord(@Body WordModel word);
    @GET("api/words")
    Call<List<WordModel>> getWord();
    @GET("api/words/{id}")
    Call<WordModel> getWordById(@Path("id") String id);
    @FormUrlEncoded
    @PATCH("api/words/{id}")
    Call<WordModel> updateWord(
            @Path("id") String id,
            @Body WordModel word
            //@Field("word") String word //,
//            @Field("pos") String pos,
//            @Field("def") String def,
//            @Field("img") String img,
//            @Field("audio") String audio,
//            @Field("pronun") String pronun,
//            @Field("hint") String hint
    );
    @DELETE("api/words/{id}")
    Call<WordModel> deleteWord(@Path("id") String id);
}
