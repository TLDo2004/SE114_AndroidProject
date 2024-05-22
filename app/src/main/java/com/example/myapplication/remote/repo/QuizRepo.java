package com.example.myapplication.remote.repo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.remote.client.ApiClient;
import com.example.myapplication.remote.model.QuizModel;
import com.example.myapplication.remote.model.WordModel;
import com.example.myapplication.remote.service.QuizService;
import com.example.myapplication.remote.service.WordService;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizRepo {
    private QuizService service;
    public QuizRepo() {
        service = ApiClient.getClient().create(QuizService.class);
    }
//    public LiveData<QuizModel> createQuiz(QuizModel quiz) {
//        MutableLiveData<QuizModel> data = new MutableLiveData<>();
//        service.createQuiz(quiz).enqueue(new Callback<QuizModel>() {
//            @Override
//            public void onResponse(Call<QuizModel> call, Response<QuizModel> response) {
//                if (response.isSuccessful()) {data.setValue(response.body());}
//                else  {
//                    Log.e("API", "Failed: " + response.code());}
//            }
//            @Override
//            public void onFailure(Call<QuizModel> call, Throwable t) {
//                Log.e("API", "Failed: " +  t.getMessage());
//            }
//        });
//        return data;
//    }
    public LiveData<List<QuizModel>> getQuiz() {
        MutableLiveData<List<QuizModel>> result = new MutableLiveData<>();
        service.getQuiz().enqueue(new Callback<List<QuizModel>>() {
            @Override
            public void onResponse(Call<List<QuizModel>> call, Response<List<QuizModel>> response) {
                if (response.isSuccessful()) {result.postValue(response.body());}
                else  {Log.e("API", "Failed: " + response.code());}
            }
            @Override
            public void onFailure(Call<List<QuizModel>> call, Throwable t) {
                Log.e("API", "Failed: " +  t.getMessage());
            }
        });
        return result;
    }
    public LiveData<QuizModel> getQuizById(String id) {
        MutableLiveData<QuizModel> result = new MutableLiveData<>();
        service.getQuizById(id).enqueue(new Callback<QuizModel>() {
            @Override
            public void onResponse(Call<QuizModel> call, Response<QuizModel> response) {
                if (response.isSuccessful()) {result.setValue(response.body());}
                else  {Log.e("API", "Failed: " + response.code());}
            }
            @Override
            public void onFailure(Call<QuizModel> call, Throwable t) {
                Log.e("API", "Failed: " +  t.getMessage());
            }
        });
        return result;
    }
//    public LiveData<QuizModel> updateQuiz( String id, QuizModel quiz ) {
//        MutableLiveData<QuizModel> data = new MutableLiveData<>();
//        service.updateQuiz(id, quiz).enqueue(new Callback<QuizModel>() {
//            @Override
//            public void onResponse(Call<QuizModel> call, Response<QuizModel> response) {
//                if (response.isSuccessful()) {data.setValue(response.body());}
//                else  {Log.e("API CALL", "Failed: " + response.code());}
//            }
//            @Override
//            public void onFailure(Call<QuizModel> call, Throwable t) {
//                Log.e("API CALL", "Failed: " +  t.getMessage());
//            }
//        });
//        return data;
//    }

//    public LiveData<QuizModel> deleteQuiz(String id) {
//        MutableLiveData<QuizModel> data = new MutableLiveData<>();
//        service.deleteQuiz(id).enqueue(new Callback<QuizModel>() {
//            @Override
//            public void onResponse(Call<QuizModel> call, Response<QuizModel> response) {
//                if (response.isSuccessful()) {data.setValue(response.body());}
//                else  {Log.e("API CALL", "Failed: " + response.code());}
//            }
//            @Override
//            public void onFailure(Call<QuizModel> call, Throwable t) {
//                Log.e("API CALL", "Failed: " +  t.getMessage());
//            }
//        });
//        return data;
//    }

}
