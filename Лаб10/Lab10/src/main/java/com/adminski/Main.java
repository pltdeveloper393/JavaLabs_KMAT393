package com.adminski;

public class Main {
    public static void main(String[] args) {
        Buildable[] buildings = {
            new ResidentialBuilding("ул. Новая, 10", 5, 5),
            new ResidentialBuilding("пр. Независимости, 10", 8, 8),
            new ResidentialBuilding("пр. Мира, 30", 22, 22),
            new OfficeBuilding("ул. Колесникова, 3", 5, 5),
            new OfficeBuilding("бульвар Тараса бульбы, 21", 2, 2)
        };

        System.out.println("=== Строительство (Buildable) ===");
        for (Buildable b : buildings) {
            b.build();
        }

        System.out.println("\n=== Этажи ===");
        for (Buildable b : buildings) {
            System.out.println("Этажей: " + b.getFloors());
        }

        Habitable[] habitable = {
            new ResidentialBuilding("ул. Новая, 10", 5, 40),
            new ResidentialBuilding("пр. Независимости, 10", 9, 90),
            new ResidentialBuilding("пр. Мира, 30", 3, 24),
            new OfficeBuilding("ул. Колесникова, 3", 7, 5),
            new OfficeBuilding("бульвар Тараса бульбы, 21", 12, 8)
        };

        System.out.println("\n=== Заселенность ===");
        for (Habitable h : habitable) {
            h.live();
            System.out.println("  Вместимость: " + h.getCapacity() + " чел.");
        }

        System.out.println("\n=== Инфа о зданиях ===");
        for (Buildable b : buildings) {
            if (b instanceof ResidentialBuilding) {
                ((ResidentialBuilding) b).displayInfo();
            }
            else if (b instanceof OfficeBuilding) {
                ((OfficeBuilding) b).displayInfo();
            }
        }
    }
}