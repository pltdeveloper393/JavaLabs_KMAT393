package com.adminski;

public class Pizza extends Food {
    private String toppings;

    public Pizza(String name, int calories, int cookingTime, String toppings) {
        super(name, calories, cookingTime);
        this.toppings = toppings;
    }

    public String getToppings()                 { return toppings; }
    public void setToppings(String toppings)    { this.toppings = toppings; }



    @Override
    public void cook() {
        System.out.println("> Пицца готовится !");
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Начинки: " + toppings);
    }
    public void addTopping(String topping) {
        toppings += ", " + topping;
        System.out.println("Добавлена начинка: " + topping);
    }
}