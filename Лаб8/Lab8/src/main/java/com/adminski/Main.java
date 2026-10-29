package com.adminski;

public class Main {
    public static void main(String[] args) {
        Food[] foods = {
            new Pizza("Сытная", 100, 10, "сыр, томаты, курица, грудинка"),
            new Pizza("4 Сына", 200, 20, "сыр, пепперони, сын"),
            new Pizza("Гавайская", 200, 30, "сыр, курица, ананасычи"),
            new Salad("Оливьешка", 200, 10, "майонез, французская горчинка"),
            new Salad("Огуречный", 200, 10, "оливковая заправка с огурцами"),
            new Food("Фастфуд", 400, 10)
        };

        System.out.println("========= Все ПОЗИЦИИ =============================================");
        for (Food food : foods) {
            food.displayInfo();
            food.cook();
            System.out.println();
        }

        System.out.println("========= Уникальные методы =============================================");
        for (Food food : foods) {
            if (food instanceof Pizza) {
                ((Pizza) food).addTopping("Барбекю соус");
            }
            else if (food instanceof Salad) {
                ((Salad) food).addDressing("сметана 5 литров");
            }
        }

        Pizza pizza=new Pizza("Сытная", 100, 10, "сыр, томаты, курица, грудинка");
        Food foodd=new Pizza("Сытная", 100, 10, "сыр, томаты, курица, грудинка");
        

    }
}