package com.adminski.films;

public class Drama extends Film {
    private int oscars;

    public Drama(String title, String id, int duration, int oscars) {
        super(title, id, duration);
        this.oscars = oscars;
    }

    public int getOscars() {
        return oscars;
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + " | слезинок: " + oscars;
    }
}