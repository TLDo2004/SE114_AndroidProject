package com.example.myapplication.remote.model;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.List;

public class RevisionModel {
    @SerializedName("_id")
    public String id;
    @SerializedName("cre_dt")
    public String cre_dt;
    @SerializedName("alarm_dt")
    public String alarm_dt;
    @SerializedName("interval")
    public int interval;
    @SerializedName("words")
    public List<WordModel> wordList;
}
