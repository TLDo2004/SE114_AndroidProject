package com.example.myapplication.remote.repo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.remote.client.ApiClient;
import com.example.myapplication.remote.model.TopicModel;
import com.example.myapplication.remote.service.TopicService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopicRepo {
    private TopicService service;
    public TopicRepo() {
        service = ApiClient.getClient().create(TopicService.class);
    }
    public LiveData<TopicModel> createTopic(TopicModel topic) {
        MutableLiveData<TopicModel> data = new MutableLiveData<>();
        service.createTopic(topic).enqueue(new Callback<TopicModel>() {
            @Override
            public void onResponse(Call<TopicModel> call, Response<TopicModel> response) {
                if (response.isSuccessful()) {data.setValue(response.body());}
                else  {
                    Log.e("API", "Failed: " + response.code());}
            }
            @Override
            public void onFailure(Call<TopicModel> call, Throwable t) {
                Log.e("API", "Failed: " +  t.getMessage());
            }
        });
        return data;
    }
    public LiveData<List<TopicModel>> getTopic() {
        MutableLiveData<List<TopicModel>> result = new MutableLiveData<>();
        service.getTopic().enqueue(new Callback<List<TopicModel>>() {
            @Override
            public void onResponse(Call<List<TopicModel>> call, Response<List<TopicModel>> response) {
                if (response.isSuccessful()) {result.setValue(response.body());}
                else  {Log.e("API", "Failed: " + response.code());}
            }
            @Override
            public void onFailure(Call<List<TopicModel>> call, Throwable t) {
                Log.e("API", "Failed: " +  t.getMessage());
            }
        });
        return result;
    }
    public LiveData<TopicModel> getTopicById(String id) {
        MutableLiveData<TopicModel> result = new MutableLiveData<>();
        service.getTopicById(id).enqueue(new Callback<TopicModel>() {
            @Override
            public void onResponse(Call<TopicModel> call, Response<TopicModel> response) {
                if (response.isSuccessful()) {result.setValue(response.body());}
                else  {Log.e("API", "Failed: " + response.code());}
            }
            @Override
            public void onFailure(Call<TopicModel> call, Throwable t) {
                Log.e("API", "Failed: " +  t.getMessage());
            }
        });
        return result;
    }
    //public LiveData<TopicModel> updateTopic(String id, TopicModel topic) {}
    //public LiveData<TopicModel> deleteTopic(String id) {}
}
