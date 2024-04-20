package com.example.myapplication.remote.repo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.remote.client.ApiClient;
import com.example.myapplication.remote.model.WordModel;
import com.example.myapplication.remote.service.WordService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class WordRepo {
    private WordService service;
    public WordRepo() {
        service = ApiClient.getClient().create(WordService.class);
    }
    public LiveData<WordModel> createWord(WordModel word) {
        MutableLiveData<WordModel> data = new MutableLiveData<>();
        service.createWord(word).enqueue(new Callback<WordModel>() {
            @Override
            public void onResponse(Call<WordModel> call, Response<WordModel> response) {
                if (response.isSuccessful()) {data.setValue(response.body());}
                else  {Log.e("API", "Failed: " + response.code());}
            }
            @Override
            public void onFailure(Call<WordModel> call, Throwable t) {
                Log.e("API", "Failed: " +  t.getMessage());
            }
        });
        return data;
    }
    public LiveData<List<WordModel>> getWord() {
        MutableLiveData<List<WordModel>> result = new MutableLiveData<>();
        service.getWord().enqueue(new Callback<List<WordModel>>() {
            @Override
            public void onResponse(Call<List<WordModel>> call, Response<List<WordModel>> response) {
                if (response.isSuccessful()) {result.setValue(response.body());}
                else  {Log.e("API", "Failed: " + response.code());}
            }
            @Override
            public void onFailure(Call<List<WordModel>> call, Throwable t) {
                Log.e("API", "Failed: " +  t.getMessage());
            }
        });
        return result;
    }
    public LiveData<WordModel> getWordById(String id) {
        MutableLiveData<WordModel> result = new MutableLiveData<>();
        service.getWordById(id).enqueue(new Callback<WordModel>() {
            @Override
            public void onResponse(Call<WordModel> call, Response<WordModel> response) {
                if (response.isSuccessful()) {result.setValue(response.body());}
                else  {Log.e("API", "Failed: " + response.code());}
            }
            @Override
            public void onFailure(Call<WordModel> call, Throwable t) {
                Log.e("API", "Failed: " +  t.getMessage());
            }
        });
        return result;
    }
    public LiveData<WordModel> updateWord(
            String id,
            WordModel word
            //String word//,
//            String pos,
//            String def,
//            String img,
//            String audio,
//            String pronun,
//            String hint
    ) {
        MutableLiveData<WordModel> data = new MutableLiveData<>();
        service.updateWord(id, word).enqueue(new Callback<WordModel>() {
            @Override
            public void onResponse(Call<WordModel> call, Response<WordModel> response) {
                if (response.isSuccessful()) {data.setValue(response.body());}
                else  {Log.e("API CALL", "Failed: " + response.code());}
            }
            @Override
            public void onFailure(Call<WordModel> call, Throwable t) {
                Log.e("API CALL", "Failed: " +  t.getMessage());
            }
        });
        return data;
    }
    public LiveData<WordModel> deleteWord(String id) {
        MutableLiveData<WordModel> data = new MutableLiveData<>();
        service.deleteWord(id).enqueue(new Callback<WordModel>() {
            @Override
            public void onResponse(Call<WordModel> call, Response<WordModel> response) {
                if (response.isSuccessful()) {data.setValue(response.body());}
                else  {Log.e("API CALL", "Failed: " + response.code());}
            }
            @Override
            public void onFailure(Call<WordModel> call, Throwable t) {
                Log.e("API CALL", "Failed: " +  t.getMessage());
            }
        });
        return data;
    }
}
