package com.example.myapplication.remote.model;

import com.google.gson.annotations.SerializedName;

public class QuizModel {
    @SerializedName("_id")
    public String id;
    @SerializedName("point")
    public int point;
    @SerializedName("timer")
    public int timer;
}
