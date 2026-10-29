package com.adminski.films;

import java.util.Map;
import java.util.HashMap;

public class FilmsDemo {
    public static void run() {
        Map<String, Film> films = new HashMap<>();

        films.put("Матрица", new Action("Матрица", "A001", 136, 15));
        films.put("Джон Уик", new Action("Джон Уик", "A002", 101, 22));
        films.put("", new Action("Падение Орла", "A003", 145, 10));

        films.put("Волк с Уолстрит", new Comedy("Волк с Уолстрит", "C001", 97, 8));
        films.put("Доктор Хаус", new Comedy("Доктор Хаус", "C002", 110, 7));
        films.put("5 Элемент", new Comedy("5 Элемент", "C003", 105, 9));

        films.put("Беги лес", new Drama("Беги лес", "D001", 142, 6));
        films.put("Крёстный отец", new Drama("Крёстный отец", "D002", 175, 3));

        System.out.println("=== Map<String, Film> — все фильмы ===");
        for (Map.Entry<String, Film> entry : films.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue().displayInfo());
        }

        System.out.println("\nВсего фильмов: " + films.size());
    }
}