package com.example.jinny.quizgame;

public class WordModel {
    public int id;
    public String orgin;
    public String explanation;
    public String type;
    public String pronounciation;
    public String image;
    public String example;
    public String example_trans;
    public int topic_id;
    public int level;

    public WordModel(int id, String orgin, String explanation, String type, String pronounciation, String image, String example, String example_trans, int topic_id, int level) {
        this.id = id;
        this.orgin = orgin;
        this.explanation = explanation;
        this.type = type;
        this.pronounciation = pronounciation;
        this.image = image;
        this.example = example;
        this.example_trans = example_trans;
        this.topic_id = topic_id;
        this.level = level;
    }
}