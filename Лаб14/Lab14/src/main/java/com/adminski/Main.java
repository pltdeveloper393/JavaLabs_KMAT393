package com.adminski;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== 1. Инфа об игре ===\n");
        gameInfoFile();


        System.out.println("\n=== 2. 10 int чисел в файл ===\n");
        System.out.println("Выбериет режим ввода:\n1 - ручной\n2 - автоматический");
        int f2 = Integer.parseInt(sc.nextLine().trim());
        tenIntegers(f2);


        System.out.println("\n=== 3. Разделение чисел на 2 файла ===\n");
        splitByTen();


        System.out.println("\n=== 4. AVG время из 15 знач. ===\n");
        System.out.println("Выбериет режим ввода:\n1 - ручной\n2 - автоматический");
        int f4 = Integer.parseInt(sc.nextLine().trim());
        averageTime(f4);


        System.out.println("\n=== 5. Кол-во чисел меньше -10 ===\n");
        belowMinusTen();
    }



    // 1: об игре, св-ва файла, содержимое
    static void gameInfoFile() {
        List<String> info = List.of(
                "Название: Satisfactory",
                "Разработчик: Coffee Stain Studios",
                "Издатель: Coffee Stain Publishing",
                "Early Access: 15.03.2019",
                "Версия 1.2.3.1: 24.06.2026",
                "Жанр: симулятор строительства фабрики",
                "Платформа: PC (Steam, Epic Games Store)",
                "Движок: Unreal Engine 5",
                "Вид: от первого лица",
                "Описание: игрок строит автоматизированные фабрики на чужой",
                "планете, добывая ресурсы и исследуя технологии производства."
        );

        writeLines("satisfactory.txt", info);
        System.out.println("Файл записан успешно: satisfactory.txt\n");

        File f = new File("satisfactory.txt");
        fileInfo(f);

        System.out.println("\nСодержимое:");
        readWithStreams(f);
    }



    // 2: 10 int числе записываем, сумма отриц.
    static void tenIntegers(int f) {
        Random rnd = new Random();
        List<String> numbers = new ArrayList<>();
        if (f == 1) {
            for (int i = 1; i <= 10; i++) {
                numbers.add(String.valueOf(askInt("Число №" + i + ": ")));
            }
        }
        else {
            for (int i = 1; i <= 10; i++) {
                numbers.add(String.valueOf(rnd.nextInt(-100, 101)));
            }
        }
        writeLines("f2.txt", numbers);

        int sum = 0;
        System.out.print("Из файла: ");
        for (String s : readLines("f2.txt")) {
            int value = Integer.parseInt(s);
            System.out.print(value + " ");
            if (value < 0) {
                sum += value;
            }
        }
        System.out.println("\nСумма отриц. чисел: " + sum);
    }







    // 3: рандомные числа, кратные 10 в файл g, иначе в h
    static void splitByTen() {
        Random rnd = new Random();
        List<String> source = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            source.add(String.valueOf(rnd.nextInt(-100, 101)));
        }
        writeLines("f3.txt", source);

        List<String> byTen = new ArrayList<>();
        List<String> others = new ArrayList<>();
        for (String s : readLines("f3.txt")) {
            int value = Integer.parseInt(s);
            if (value % 10 == 0) {
                byTen.add(s);
            }
            else {
                others.add(s);
            }
        }
        writeLines("f3g.txt", byTen);
        writeLines("f3h.txt", others);

        System.out.println("Кратные 10  =>  f3g.txt (" + byTen.size() + "): " + String.join(" ", byTen));
        System.out.println("Другие      =>  f3h.txt (" + others.size() + "): " + String.join(" ", others));
    }




    // 4: 15 вещ в виде секунд, ср знач
    static void averageTime(int flag4) {
        Random rnd = new Random();
        List<String> times = new ArrayList<>();
        if (flag4 == 1) {
            for (int i = 1; i <= 5; i++) {
                times.add(String.valueOf(askDouble("№" + i + " (сек): ")));
            }
        }
        else if (flag4 == 0) {
            for (int i = 1; i <= 5; i++) {
                double temp = rnd.nextDouble() * (101 - (-101));
                temp = Math.round(temp * 100.0) / 100.0;
                times.add(String.valueOf(temp));
                System.out.print(temp + " ");
            }
        }

        writeLines("f4.txt", times);

        double sum = 0;
        for (String s : readLines("f4.txt")) {
            sum += Double.parseDouble(s);
        }
        File fn = new File("f4.txt");
        int count = readLines("f4.txt").size();
        double average = sum / count;
        System.out.println("Среднее время: " + average + " сек при " + count);

    }



    // 5: 10 рандомных, берём числа < −10
    static void belowMinusTen() {
        Random rnd = new Random();
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(String.valueOf(rnd.nextInt(-40, 41)));
        }
        writeLines("f5.txt", numbers);

        int count = 0;
        for (String s : readLines("f5.txt")) {
            if (Integer.parseInt(s) < -10) {
                count++;
            }
        }
        System.out.println("Числа: " + String.join(" ", numbers));
        System.out.println("Меньше −10: " + count);
    }


    static void writeLines(String path, List<String> lines) {
        try (BufferedWriter w = Files.newBufferedWriter(Path.of(path), StandardCharsets.UTF_8)) {
            for (String line : lines) {
                w.write(line);
                w.newLine();
            }
        }
        catch (IOException e) {
            System.out.println("Не удалось записать " + path + ": " + e.getMessage());
        }
    }

    static List<String> readLines(String path) {
        try {
            return Files.readAllLines(Path.of(path), StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            System.out.println("Не удалось прочитать " + path + ": " + e.getMessage());
            return new ArrayList<>();
        }
    }





    // байтовый потока отражаем символамиим
    static void readWithStreams(File f) {
        try (BufferedReader r = new BufferedReader(
                new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8))) {
            String line;
            while ((line = r.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println("[!] Ошибка чтения: " + e.getMessage());
        }
    }

    // прочие методики
    static void fileInfo(File f) {
        System.out.println("Имя файла: " + f.getName());
        System.out.println("Размер: " + f.length() + " байт");
        System.out.println("Путь: ");
        System.out.println("- Относительный: " + f.getPath());
        System.out.println("- Абсолютный: " + f.getAbsolutePath());
        System.out.println("Родитель: " + new File(f.getAbsolutePath()).getParent());
        System.out.println("Изменён: " + new Date(f.lastModified()));
        System.out.println("В наличии: " + (f.exists() ? "да" : "нет"));
        System.out.println("Чтение: " + (f.canRead() ? "да" : "нет"));
        System.out.println("Запись: " + (f.canWrite() ? "да" : "нет"));
        System.out.println("Файл: " + (f.isFile() ? "да" : "нет"));
        System.out.println("Явл каталогом: " + (f.isDirectory() ? "да" : "нет"));
    }

    static int askInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            }
            catch (NumberFormatException e) {
                System.out.print(ErrorMessage.show(0));
            }
        }
    }

    static double askDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String s = sc.nextLine().trim();
                if (Double.parseDouble(s) < 0) {
                    throw new IllegalArgumentException(ErrorMessage.show(2));
                }
                return Double.parseDouble(s);
            }
            catch (NumberFormatException e) {
                System.out.print(ErrorMessage.show(1));
            }
            catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
        }
    }
}