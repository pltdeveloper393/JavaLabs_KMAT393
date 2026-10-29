package com.adminski.artists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;
import com.adminski.ErrorMessage;




public class ArtistsDemo {
    public static void run() {
        List<Artist> artists = new ArrayList<>();
        artists.add(new Artist("A001", "Иванов А", "Шансон", 1,     List.of(5, 5, 5, 5, 5)));
        artists.add(new Artist("A002", "Иванов 2", "Шансон", 2,     List.of(1, 1, 1, 3, 4)));
        artists.add(new Artist("A003", "Иванов В", "Дублёр", 3,     List.of(5, 5, 5, 5, 5)));
        artists.add(new Artist("A004", "Иванов 4", "Дублёр", 1,     List.of(2, 2, 2, 2, 2)));
        artists.add(new Artist("A005", "Иванов 5", "Музыкант", 2,   List.of(1, 3)));
        artists.add(new Artist("A006", "Иванов 6", "Музыкант", 3,   List.of(3, 1)));
        artists.add(new Artist("A007", "Иванов Б", "Актёр кино", 1, List.of(5, 5, 5, 5, 5)));
        artists.add(new Artist("A008", "Иванов 8", "Актёр кино", 2, List.of(3, 4, 3)));

        // если рейтинг < 3
        System.out.println("=== 1. Удаление (ср. рейтинг < 3) ===");
        Iterator<Artist> it = artists.iterator();
        while (it.hasNext()) {
            Artist a = it.next();
            if (a.getAverageRating() < 3) {
                System.out.println("Удалён: " + a.getName() + " (avg: " + a.getAverageRating() + ")");
                it.remove();
            }
        }

        // Повысить с avg рейтингом >= 4
        System.out.println("\n=== 2. Повышение ранга (ср. ранг >= 4) ===");
        for (Artist a : artists) {
            if (a.getAverageRating() >= 4) {
                int old = a.getRank();
                a.setRank(old + 1);
                System.out.println(a.getName() + ": ранг " + old + " → " + a.getRank());
            }
        }

        System.out.println("\n=== 3. Вывод объектов с рангом n ===");
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print("\nВведите ранг поиска: ");
            try {
                int n = Integer.parseInt(s.nextLine());
                if (n >= 0 && n <= 5) {
                    printArtists(artists, n);
                    break;
                }
                else throw new IllegalArgumentException();
            }
            catch (NumberFormatException e) {
                System.out.println(ErrorMessage.show(0));
            }
            catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.show(1));
            }
        }




        // Сорт по убыв. avg рейтинга, если одинаковый, то по имени
        System.out.println("\n=== 4. Сортировка по убыванию среднего рейтинга ===");
        artists.sort(Comparator
            .comparingDouble(Artist::getAverageRating)
            .thenComparing(Artist::getName).reversed());

        for (Artist a : artists) {
            System.out.println(a.getId() + " | " + a.getName() + " | avg: " + a.getAverageRating());
        }
    }

    public static void printArtists(List<Artist> artists, int rank) {
        boolean chk = false;
        for (Artist a : artists) {
            if (a.getRank() == rank) {
                chk = true;
                System.out.println(a.getId() + " | " + a.getName() + " | " + a.getGenre() + " | ранг: " + a.getRank());
            }
        }
        if (chk == false) {
            System.out.println("[!] Артисты с рангом _" + rank + "_ отсутствуют");
        }
    }
}