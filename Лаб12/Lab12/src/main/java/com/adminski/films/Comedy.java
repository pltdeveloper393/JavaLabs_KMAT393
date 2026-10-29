package com.adminski.films;

public class Comedy extends Film {
    private int funnyRating;

    public Comedy(String title, String id, int duration, int funnyRating) {
        super(title, id, duration);
        this.funnyRating = funnyRating;
    }

    public int getFunnyRating() {
        return funnyRating;
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + " | закадровых смехов: " + funnyRating + "/10";
    }
}