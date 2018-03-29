package com.example.jinny.quizgame;

import java.util.List;

public class MagicWordQuestionModel {
    public int id;
    public String origin;
    public String explanation;
    public String image;
    public List<String> word;
    public int right;

    public MagicWordQuestionModel(int id, String origin, String explanation, String image, List<String> word, int right) {
        this.id = id;
        this.origin = origin;
        this.explanation = explanation;
        this.image = image;
        this.word = word;
        this.right = right;
    }
} 