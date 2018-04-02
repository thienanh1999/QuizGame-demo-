package com.example.jinny.quizgame;

/**
 * Created by Trung's PC on 3/31/2018.
 */

public class Country {
    private int ID;
    private String name;
    private String url;

    public Country(int ID, String name, String url) {
        this.ID = ID;
        this.name = name;
        this.url = url;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
