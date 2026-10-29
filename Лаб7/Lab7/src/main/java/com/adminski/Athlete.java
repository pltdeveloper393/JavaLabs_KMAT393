package com.adminski;

public class Athlete {
    private String name;
    private String sport;
    private int medals;
    private static int totalAthletes = 0;
    private static int totalMedals = 0;

    public Athlete(String name, String sport, int medals) {
        this.name = name;
        this.sport = sport;
        this.medals = medals;
        totalAthletes++;
        totalMedals += medals;
    }

    public String getName() {
        return name;
    }
    public String getSport() {
        return sport;
    }
    public int getMedals() {
        return medals;
    }

    public static int getTotalAthletes() {
        return totalAthletes;
    }
    public static int getTotalMedals() {
        return totalMedals;
    }
    public static double getAverageMedals() {
        if (totalAthletes == 0) return 0;
        return (double) totalMedals / totalAthletes;
    }
    public void displayInfo() {
        System.out.println(name + " | " + sport + " | медалей: " + medals);
    }
}