package com.example.myapplication.remote.repo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.remote.client.ApiClient;
import com.example.myapplication.remote.model.RevisionModel;
import com.example.myapplication.remote.model.WordModel;
import com.example.myapplication.remote.service.RevisionService;
import com.example.myapplication.remote.service.WordService;

import java.time.LocalDateTime;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RevisionRepo {
    private RevisionService service;
    public RevisionRepo() {
        service = ApiClient.getClient().create(RevisionService.class);
    }
    public LiveData<RevisionModel> createRevision(RevisionModel revision) {
        MutableLiveData<RevisionModel> data = new MutableLiveData<>();
        service.createRevision(revision).enqueue(new Callback<RevisionModel>() {
            @Override
            public void onResponse(Call<RevisionModel> call, Response<RevisionModel> response) {
                if (response.isSuccessful()) {data.setValue(response.body());}
                else  {
                    Log.e("API", "Failed: " + response.code());}
            }
            @Override
            public void onFailure(Call<RevisionModel> call, Throwable t) {
                Log.e("API", "Failed: " +  t.getMessage());
            }
        });
        return data;
    }
    public LiveData<List<RevisionModel>> getRevision() {
        MutableLiveData<List<RevisionModel>> result = new MutableLiveData<>();
        service.getRevision().enqueue(new Callback<List<RevisionModel>>() {
            @Override
            public void onResponse(Call<List<RevisionModel>> call, Response<List<RevisionModel>> response) {
                if (response.isSuccessful()) {result.setValue(response.body());}
                else  {Log.e("API", "Failed: " + response.code());}
            }
            @Override
            public void onFailure(Call<List<RevisionModel>> call, Throwable t) {
                Log.e("API", "Failed: " +  t.getMessage());
            }
        });
        return result;
    }
    public LiveData<RevisionModel> getRevisionById(String id) {
        MutableLiveData<RevisionModel> result = new MutableLiveData<>();
        service.getRevisionById(id).enqueue(new Callback<RevisionModel>() {
            @Override
            public void onResponse(Call<RevisionModel> call, Response<RevisionModel> response) {
                if (response.isSuccessful()) {result.setValue(response.body());}
                else  {Log.e("API", "Failed: " + response.code());}
            }
            @Override
            public void onFailure(Call<RevisionModel> call, Throwable t) {
                Log.e("API", "Failed: " +  t.getMessage());
            }
        });
        return result;
    }
    public LiveData<RevisionModel> updateRevision(
            String id,
            RevisionModel revision
//            LocalDateTime cre_dt,
//            LocalDateTime alarm_dt,
//            int interval
    ) {
        MutableLiveData<RevisionModel> data = new MutableLiveData<>();
        service.updateRevision(id, revision).enqueue(new Callback<RevisionModel>() {
            @Override
            public void onResponse(Call<RevisionModel> call, Response<RevisionModel> response) {
                if (response.isSuccessful()) {data.setValue(response.body());}
                else  {Log.e("API CALL", "Failed: " + response.code());}
            }
            @Override
            public void onFailure(Call<RevisionModel> call, Throwable t) {
                Log.e("API CALL", "Failed: " +  t.getMessage());
            }
        });
        return data;
    }
    public LiveData<RevisionModel> deleteRevision(String id) {
        MutableLiveData<RevisionModel> data = new MutableLiveData<>();
        service.deleteRevision(id).enqueue(new Callback<RevisionModel>() {
            @Override
            public void onResponse(Call<RevisionModel> call, Response<RevisionModel> response) {
                if (response.isSuccessful()) {data.setValue(response.body());}
                else  {Log.e("API CALL", "Failed: " + response.code());}
            }
            @Override
            public void onFailure(Call<RevisionModel> call, Throwable t) {
                Log.e("API CALL", "Failed: " +  t.getMessage());
            }
        });
        return data;
    }
}
