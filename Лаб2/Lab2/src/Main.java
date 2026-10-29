import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nЛР №2 — Вариант 12");
            System.out.println("1. Задание 1: Сумма четных позиций");
            System.out.println("2. Задание 2: Диагональ в квадрат");
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
                    testFunction(scanner);
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
        System.out.println("\n> Задание 1: Сумма четных позиций\n");

        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = scanner.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < n; i += 2) {
            sum += arr[i];
        }

        System.out.print("\nМассив arr: [");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Сумма чётных позиций массива: " + sum);
    }

    private static void t2(Scanner scanner) {
        System.out.println("\n> Задание 2: Диагональ в квадрат\n");

        System.out.print("Введите размер матрицы NxN: ");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("matrix[" + i + "][" + j + "] = ");
                int r = (int)(Math.random() + (10 - 1) + 1);
                //matrix[i][j] = scanner.nextInt();
                matrix[i][j] = r;
            }
        }

        System.out.println("\nИсходная матрица:");
        printMatrix(matrix, n);

        for (int i = 0; i < n; i++) {
            matrix[i][i] = (int) Math.pow(matrix[i][i], 2);
        }

        System.out.println("\nПосле возведения диагонали в квадрат:");
        printMatrix(matrix, n);
    }

    private static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%6d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void testFunction(Scanner scanner) {
        String[] country = new String[2];
        System.out.print("Введите название страны: ");
        country[0] = scanner.next();
        System.out.print("Введите столицу страны: ");
        country[1] = scanner.next();

        for(String x: country) {
            System.out.print(x + " ");
        }
    }







    /*
        int[] newArr = {1, 2, 1};
        int n2 = 10;
        int[] newArr2 = new int[n2];

        int j = n - 1 - i;
        int r = (int)(Math.random() * ((10 - 1) + 1));
     */

}

