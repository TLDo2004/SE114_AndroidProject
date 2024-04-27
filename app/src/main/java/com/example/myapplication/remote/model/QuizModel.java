package com.example.myapplication.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuizModel {
    @SerializedName("_id")
    public String id;

    @SerializedName("name")
    public String name;
    @SerializedName("type")
    public String type;
    @SerializedName("point")
    public int point;
    @SerializedName("timer")
    public int timer;

    @SerializedName("words")
    public List<String> wordList;

    public String getId(int position) {
        return id;
    }
}
