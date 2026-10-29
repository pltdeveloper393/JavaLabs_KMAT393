import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //генерация
        System.out.println("Генерация числа от 1 до 10");
        int secretNumber = random.nextInt(10) + 1;

        System.out.print("Введите число: ");
        int userGuess = scanner.nextInt();

        if (userGuess == secretNumber) {
            System.out.println("Введённое число совпало с сгенерированным = " + secretNumber);
        } else if (userGuess > secretNumber) {
            System.out.println("Введённое число больше сгенерированного = " + secretNumber);
        } else {
            System.out.println("Введённое число меньше сгенерированного = " + secretNumber);
        }

        System.out.println("\nThe end");
        scanner.close();
    }
}