package com.example.myapplication.remote.model;

import com.google.gson.annotations.SerializedName;

public class WordModel {

    @SerializedName("_id")
    public String id;
    @SerializedName("word")
    public String word;
    @SerializedName("pos")
    public String pos;
    @SerializedName("def")
    public String def;
    @SerializedName("img")
    public String img;
    @SerializedName("audio")
    public String audio;
    @SerializedName("pronoun")
    public String pronoun;
    @SerializedName("hint")
    public String hint;
    @SerializedName("blankSen")
    public String blankSen;

}
