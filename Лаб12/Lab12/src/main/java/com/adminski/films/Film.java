package com.adminski.films;

public class Film {
    private String title;
    private String id;
    private int duration;

    public Film(String title, String id, int duration) {
        this.title = title;
        this.id = id;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public String displayInfo() {
        return title + " | " + id + " | " + duration + " мин";
    }
}