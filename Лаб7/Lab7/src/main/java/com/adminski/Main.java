package com.adminski;

public class Main {
    public static void main(String[] args) {
        Athlete[] athletes = {
            new Athlete("Иванов Иван", "Танкист", 1),
            new Athlete("Иваненко Иван", "Спортик", 2),
            new Athlete("Иванюк Иваныч", "Шашкист", 3),
            new Athlete("Иванность Ива", "Лежание на диване", 4),
            new Athlete("Иваньчук Иваныч", "Станочник", 5)
        };

        System.out.println("Спортсменусы:");
        for (Athlete a : athletes) {
            a.displayInfo();
        }
        System.out.println();
        System.out.println("Всего: " + Athlete.getTotalAthletes());
        System.out.println("Медалей: " + Athlete.getTotalMedals());
        System.out.println("AVG медалей: " + Athlete.getAverageMedals());
    }
}