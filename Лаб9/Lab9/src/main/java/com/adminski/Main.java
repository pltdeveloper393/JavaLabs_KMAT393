package com.adminski;

public class Main {
    public static void main(String[] args) {
        Professional[] professionals = {
            new Doctor("Табленосец", 15, 2, "Терапевт"),
            new Doctor("Премыч", 8, 3, "Хирург"),
            new Doctor("Эксилион", 1, 4, "Диагност"),
            new Engineer("Одинэсус", 10, 4, "Расчёт накоплений"),
            new Engineer("Сальдо Проводыч", 5, 4.2, "Проведение документов")
        };

        System.out.println("========== Специалисты ==============================");
        for (Professional p : professionals) {
            p.displayInfo();
            p.work();
            System.out.println("Обязанности: " + p.getResponsibilities());
            System.out.println();
        }

        System.out.println("========== Уникальные поля ==============================");
        for (Professional p : professionals) {
            if (p instanceof Doctor) {
                System.out.println(p.getName() + " — специализация: " + ((Doctor) p).getSpecialization());
            }
            else if (p instanceof Engineer) {
                System.out.println(p.getName() + " — проект: " + ((Engineer) p).getProject());
            }
        }


    }
}