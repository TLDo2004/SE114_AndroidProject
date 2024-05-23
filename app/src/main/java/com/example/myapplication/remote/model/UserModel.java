package com.example.myapplication.remote.model;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.List;

public class UserModel {
    @SerializedName("_id")
    public String id;
    @SerializedName("name")
    public String name;
    @SerializedName("email")
    public String email;
    @SerializedName("pass")
    public String pass;
/*    @SerializedName("bio")
    public String bio;
    @SerializedName("avatar")
    public String avatar;
    @SerializedName("birth")
    public LocalDateTime birth;
    @SerializedName("words")
    public List<WordModel> wordList;
    @SerializedName("topics")
    public List<TopicModel> topicList;
    @SerializedName("quizs")
    public List<QuizModel> quizList;
    @SerializedName("revisions")
    public List<RevisionModel> revisionList;*/
}
