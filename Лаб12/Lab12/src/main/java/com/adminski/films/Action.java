package com.adminski.films;

public class Action extends Film {
    private int explosions;

    public Action(String title, String id, int duration, int explosions) {
        super(title, id, duration);
        this.explosions = explosions;
    }

    public int getExplosions() {
        return explosions;
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + " | экшен сцен: " + explosions;
    }
}