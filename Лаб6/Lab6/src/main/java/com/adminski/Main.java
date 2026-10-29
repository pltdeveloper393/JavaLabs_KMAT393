package com.adminski;

public class Main {
    public static void main(String[] args) {
        Laptop laptop = new Laptop("Tunderobot", 16, 512, 2500.0);

        System.out.println("До скидки:");
        laptop.displayInfo();

        laptop.applyDiscount(15);

        System.out.println("\nПосле скидки  в 15%:");
        laptop.displayInfo();
    }
}