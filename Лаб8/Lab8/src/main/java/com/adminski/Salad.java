package com.adminski;

public class Salad extends Food {
    private String dressing;

    public Salad(String name, int calories, int cookingTime, String dressing) {
        super(name, calories, cookingTime);
        this.dressing = dressing;
    }

    public String getDressing()                 { return dressing; }
    public void setDressing(String dressing)    { this.dressing = dressing; }



    @Override
    public void cook() {
        System.out.println("> Салатик готовится !");
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Заправка: " + dressing);
    }
    public void addDressing(String newDressing) {
        dressing = newDressing;
        System.out.println("Заправка изменена на: " + newDressing);
    }
}