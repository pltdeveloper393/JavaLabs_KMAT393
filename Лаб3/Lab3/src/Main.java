import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nЛР №3 — Вариант 12");
            System.out.println("Задание 1: startsWith");
            System.out.println("Задание 2: Телефон РБ");
            System.out.println("Задание 3: Employee + Report");
            System.out.println("Задание 4: Regex \\d{1,3}");
            System.out.println("0: Выход");
            System.out.print("Выберите номер: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
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
                case 4:
                    t4();
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
        System.out.println("\n> Задание 1: startsWith\n");
        System.out.print("Введите строку: ");
        String str = scanner.nextLine();

        boolean result = str.startsWith("Привет");
        System.out.println("\nНачинается ли строка с \"Привет\": " + result);
    }

    private static void t2(Scanner scanner) {
        System.out.println("\n> Задание 2: телефон РБ\n");
        System.out.print("Введите номер телефона: ");
        String phone = scanner.nextLine();

        boolean result = phone.matches("^(\\+375|8)(29|25|17|44|33)\\d{7}$");
        System.out.println("\nКорректный номер РБ: " + result);
    }

    private static void t3() {
        System.out.println("\n> Задание 3: Employee + Report\n");
        Employee[] employees = {
            new Employee("Иванов Иван", 1000.00),
            new Employee("Петров Пётр", 999.00),
            new Employee("Иванков Иванец", 100.10),
            new Employee("Иванин Иваныч", 1111.11),
            new Employee("Иванюк Юван", 99999999.99)
        };

        Report.generateReport(employees);
    }

    private static void t4() {
        System.out.println("\n> Задание 4: Regex a\\d{1,3}a\n");

        String text = "a1a a22a a333a a4444a a55555a";
        System.out.println("Строка: " + text);

        Pattern pattern = Pattern.compile("a\\d{1,3}a");
        Matcher matcher = pattern.matcher(text);

        System.out.println("Совпадения (от 1 до 3 цифр между a и a):");
        while (matcher.find()) {
            System.out.println("  " + matcher.group());
        }
    }

    static class Employee {
        String fullname;
        double salary;

        Employee(String fullname, double salary) {
            this.fullname = fullname;
            this.salary = salary;
        }
    }

    static class Report {
        static void generateReport(Employee[] employees) {
            System.out.printf("-%15s %10s%n", "ФИО", "Зарплата");
            System.out.println("---------------------------");
            double total = 0;
            for (Employee emp : employees) {
                System.out.printf("-%15s %10.2f%n", emp.fullname, emp.salary);
                total += emp.salary;
            }
            System.out.println("---------------------------");
            System.out.printf("-%15s %10.2f%n", "ИТОГО", total);
        }
    }
}