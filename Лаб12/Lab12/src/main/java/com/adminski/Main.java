package com.adminski;

import com.adminski.films.FilmsDemo;
import com.adminski.artists.ArtistsDemo;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== ЗАДАНИЕ 1: ФИЛЬМЫ (Map<String, Film>) ==========\n");
        FilmsDemo.run();

        System.out.println("\n========== ЗАДАНИЕ 2: АРТИСТЫ (List<Artist>) ==========\n");
        ArtistsDemo.run();
    }
}
