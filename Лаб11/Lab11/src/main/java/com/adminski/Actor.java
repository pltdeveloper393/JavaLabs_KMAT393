package com.adminski;

public class Actor {
    private String name;
    private int age;
    private String genre;

    public Actor(String name, int age, String genre) {
        this.name = name;
        this.age = age;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGenre() {
        return genre;
    }



    public void perform() {
        System.out.println(name + " выступает");
    }
    public void perform(String role) {
        System.out.println(name + " играет роль " + role);
    }
    public void perform(int scenes) {
        System.out.println(name + " играет в " + scenes + " сценах");
    }



    public String getAwards() {
        return "Нет наград";
    }

    public void displayInfo() {
        System.out.println(name + " | " + age + " лет | " + genre + " | " + getAwards());
    }
}