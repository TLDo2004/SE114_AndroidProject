package com.example.myapplication.remote.model;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class RevisionModel {
    @SerializedName("_id")
    public String id;
    @SerializedName("cre_dt")
    public LocalDateTime cre_dt;
    @SerializedName("alarm_dt")
    public LocalDateTime alarm_dt;
    @SerializedName("interval")
    public int interval;
}
