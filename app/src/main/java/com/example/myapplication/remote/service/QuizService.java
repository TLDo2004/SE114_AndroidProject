package com.example.myapplication.remote.service;

import com.example.myapplication.remote.model.QuizModel;
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

public interface QuizService {
//    @POST("api/quizzes")
//    Call<QuizModel> createQuiz(@Body QuizModel quiz);
    @GET("api/quizzes")
    Call<List<QuizModel>> getQuiz();
    @GET("api/quizzes/{id}")
    Call<QuizModel> getQuizById(@Path("id") String id);

//    @FormUrlEncoded
//    @PATCH("api/quizzes/{id}")
//    Call<QuizModel> updateQuiz(
//            @Path("id") String id,
//            @Body QuizModel quiz
//    );
//    @DELETE("api/words/{id}")
//    Call<QuizModel> deleteQuiz(@Path("id") String id);
}
