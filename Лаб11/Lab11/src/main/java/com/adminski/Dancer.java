package com.adminski;

public class Dancer extends Actor {
    private String style;
    private int awards;

    public Dancer(String name, int age, String style, int awards) {
        super(name, age, "Танец");
        this.style = style;
        this.awards = awards;
    }

    public String getStyle() {
        return style;
    }

    public int getAwardsCount() {
        return awards;
    }

    @Override
    public String getAwards() {
        return awards + " награды";
    }
}