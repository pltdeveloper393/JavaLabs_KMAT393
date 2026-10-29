package com.adminski;

public class Food {
    private String name;
    private int calories;
    private int cookingTime;

    public Food(String name, int calories, int cookingTime) {
        this.name = name;
        this.calories = calories;
        this.cookingTime = cookingTime;
    }

    public String getName()                     { return name; }
    public void setName(String name)            { this.name = name; }

    public int getCalories()                    { return calories; }
    public void setCalories(int calories)       { this.calories = calories; }

    public int getCookingTime()                 { return cookingTime; }
    public void setCookingTime(int cookingTime) { this.cookingTime = cookingTime; }



    public void cook() {
        System.out.println("> Позиция блюда готовится !");
    }
    public void displayInfo() {
        System.out.println(name + " | " + calories + " ккал | " + cookingTime + " мин");
    }
}