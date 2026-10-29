import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nЛР №1 — Вариант 12");
            System.out.println("1. Задание 1: AVG 5-ти чисел");
            System.out.println("2. Задание 2: Калькулятор скидок");
            System.out.println("3. Задание 3: Лестница из звездочек");
            System.out.println("0. Выход");
            System.out.print("Выберите номер: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    t1(scanner);
                    break;
                case 2:
                    t2(scanner);
                    break;
                case 3:
                    t3();
                    break;
                case 0:
                    running = false;
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный выбор. Введите ещё раз.");
            }
        }
        scanner.close();
    }

    private static void t1(Scanner scanner) {
        System.out.println("\n> Задание 1: AVG 5-ти чисел\n");

        double sum = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.print("Введите число " + i + ": ");
            double number = scanner.nextDouble();
            sum += number;
        }
        double average = sum / 5;

        System.out.println("\nСумма: " + sum);
        System.out.println("Среднее арифметическое: " + average);
    }

    private static void t2(Scanner scanner) {
        System.out.println("\n> Задание 2: Калькулятор скидок\n");
        System.out.print("Введите сумму покупки: ");
        double sum = scanner.nextDouble();

        double discount = sum > 1000 ? 10 : 5;
        double discountAmount = sum * discount / 100;
        double finalSum = sum - discountAmount;

        System.out.println("\nСумма покупки: " + sum);
        System.out.println("Размер скидки: " + discount + "%");
        System.out.println("Скидка: " + discountAmount);
        System.out.println("Итоговая сумма: " + finalSum);
    }

    private static void t3() {
        System.out.println("\n> Задание 3: Лестница из звездочек\ns");

        int rows = 5;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}