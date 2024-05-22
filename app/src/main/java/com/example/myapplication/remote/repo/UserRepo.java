package com.example.myapplication.remote.repo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.remote.client.ApiClient;
import com.example.myapplication.remote.model.UserModel;
import com.example.myapplication.remote.service.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepo {
    private UserService service;
    public UserRepo() {
        service = ApiClient.getClient().create(UserService.class);
    }
    public LiveData<UserModel> createUser(String name, String email, String pass) {
        MutableLiveData<UserModel> data = new MutableLiveData<>();
        service.createUser(name, email, pass).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if (response.isSuccessful()) {data.setValue(response.body());}
                else  {
                    Log.e("API", "Failed: " + response.code());}
            }
            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Log.e("API", "Failed: " +  t.getMessage());
            }
        });
        return data;
    }
    public LiveData<List<UserModel>> getUser() {
        MutableLiveData<List<UserModel>> result = new MutableLiveData<>();
        service.getUser().enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                if (response.isSuccessful()) {result.setValue(response.body());}
                else  {Log.e("API", "Failed: " + response.code());}
            }
            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                Log.e("API", "Failed: " +  t.getMessage());
            }
        });
        return result;
    }
    public LiveData<UserModel> getUserByName(String name) {
        MutableLiveData<UserModel> result = new MutableLiveData<>();
        service.getUserById(name).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if (response.isSuccessful()) {result.setValue(response.body());}
                else  {Log.e("API", "Failed: " + response.code());}
            }
            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Log.e("API", "Failed: " +  t.getMessage());
            }
        });
        return result;
    }
    //public LiveData<TopicModel> updateTopic(String id, TopicModel topic) {}
    //public LiveData<TopicModel> deleteTopic(String id) {}
}

