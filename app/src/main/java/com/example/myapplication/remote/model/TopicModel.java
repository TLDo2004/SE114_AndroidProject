package com.example.myapplication.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopicModel {
    @SerializedName("_id")
    public String id;
    @SerializedName("name")
    public String name;
    @SerializedName("des")
    public String des;
    @SerializedName("prog")
    public int prog;
    @SerializedName("words")
    public List<WordModel> wordList;
}
