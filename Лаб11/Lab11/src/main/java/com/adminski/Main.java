package com.adminski;

public class Main {
    public static void main(String[] args) {
        Actor[] actors = {
            new Singer("Иванов Иван", 35, "Рок", 5),
            new Singer("Иванюк Иван", 28, "Шансон", 3),
            new Singer("Иванов Иваныч", 42, "Шансон", 7),
            new Dancer("Иванович Ива", 25, "Харддрайв", 3),
            new Dancer("иван Иван", 30, "Кантри", 2)
        };

        System.out.println("=== Перегрузка perform() ===");
        for (Actor a : actors) {
            a.perform();
            a.perform("главную роль");
            a.perform(5);
            System.out.println();
        }

        System.out.println("=== Переопределение getAwards() ===");
        for (Actor a : actors) {
            System.out.println(a.getName() + " → " + a.getAwards());
        }

        System.out.println("\n=== Инфа ===");
        for (Actor a : actors) {
            a.displayInfo();
        }




        System.out.println("\n=== Статический/динамический полиморфизм ===");
        Actor actor = new Singer("Тест Тест", 20, "тестовое", 1);



        actor.perform("роль");
        System.out.println("getAwards(): " + actor.getAwards());  // вызовется версия Singer
    }
}