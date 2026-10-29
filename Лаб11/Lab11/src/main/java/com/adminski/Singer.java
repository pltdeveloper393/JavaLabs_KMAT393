package com.adminski;

public class Singer extends Actor {
    private int awards;

    public Singer(String name, int age, String genre, int awards) {
        super(name, age, genre);
        this.awards = awards;
    }

    public int getAwardsCount() {
        return awards;
    }

    @Override
    public String getAwards() {
        return awards + " наград";
    }
}