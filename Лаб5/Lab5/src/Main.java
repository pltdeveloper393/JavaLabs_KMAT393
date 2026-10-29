import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nЛР №5 — Красновский Матвей — Вариант 12");
            System.out.println("1. Задание 1: Класс телефонов");
            System.out.println("2. Задание 2: Класс отелей через массив");
            System.out.println("3. Задание 3: Перечисление жанров и класс книг");
            System.out.println("0. Выход");
            System.out.print("Выберите номер: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    t1(scanner);
                    break;
                case 2:
                    t2();
                    break;
                case 3:
                    t3();
                    break;
                case 0:
                    running = false;
                    System.out.println("Выход.");
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
        scanner.close();
    }

    private static void t1(Scanner scanner) {
        System.out.println("\n> Задание 1: Класс Phone\n");

        System.out.print("Введите бренд: ");
        String brand = scanner.nextLine();
        System.out.print("Введите модель: ");
        String model = scanner.nextLine();
        System.out.print("Введите цену: ");
        double price = scanner.nextDouble();

        Phone phone = new Phone(brand, model, price);
        System.out.println("\nДо скидки:");
        phone.displayInfo();

        phone.applyDiscount(15);
        System.out.println("\nПосле скидки 15%:");
        phone.displayInfo();
    }

    private static void t2() {
        System.out.println("\n> Задание 2: Класс Hotel (массив)\n");

        Hotel[] hotels = {
                new Hotel("Беларусь", 5, 250.0),
                new Hotel("Минск", 4, 180.0),
                new Hotel("Вокзальная", 3, 120.0),
                new Hotel("Беларусь2", 5, 300.0),
                new Hotel("Спутнiк", 2, 80.0),
                new Hotel("Рыга", 4, 200.0)
        };

        System.out.println("Отели:");
        for (Hotel h : hotels) {
            h.displayInfo();
        }

        Hotel maxStars = hotels[0];
        Hotel maxPrice = hotels[0];
        for (Hotel h : hotels) {
            if (h.stars > maxStars.stars) maxStars = h;
            if (h.pricePerNight > maxPrice.pricePerNight) maxPrice = h;
        }

        System.out.println("\nМаксимум звёзд: " + maxStars.name + " (" + maxStars.stars + "*)");
        System.out.println("Самый дорогой: " + maxPrice.name + " (" + maxPrice.pricePerNight + " руб.)");
    }

    private static void t3() {
        System.out.println("\n> Задание 3: Enum Genre + класс Book\n");

        Book[] books = {
                new Book("Java документация", Genre.DOCUMENTATION),
                new Book("TownyPlugins Documentation", Genre.DOCUMENTATION),
                new Book("First Steps for Minecraf Servers", Genre.DOCUMENTATION),
                new Book("Достоевский - Преступление и наказхание", Genre.HISTORY),
                new Book("Толстый - Война и мир", Genre.HISTORY),
                new Book("Гарри Потер - Филосовский камень 1", Genre.FANTASY)
        };

        System.out.println("Все книжки:");
        for (Book b : books) {
            b.displayInfo();
        }

        System.out.println("\nКниги жанра FANTASY:");
        for (Book b : books) {
            if (b.genre == Genre.FANTASY) {
                b.displayInfo();
            }
        }
    }

    static class Phone {
        String brand;
        String model;
        double price;

        Phone(String brand, String model, double price) {
            this.brand = brand;
            this.model = model;
            this.price = price;
        }

        void applyDiscount(double discount) {
            this.price -= this.price * discount / 100;
        }

        void displayInfo() {
            System.out.println("  " + brand + " " + model + " — " + price + " руб.");
        }
    }

    static class Hotel {
        String name;
        int stars;
        double pricePerNight;

        Hotel(String name, int stars, double pricePerNight) {
            this.name = name;
            this.stars = stars;
            this.pricePerNight = pricePerNight;
        }

        void displayInfo() {
            System.out.println("  " + name + " | " + stars + "* | " + pricePerNight + " руб./ночь");
        }
    }

    enum Genre {
        FICTION,
        NON_FICTION,
        SCIENCE,
        HISTORY,
        FANTASY,
        DOCUMENTATION
    }

    static class Book {
        String title;
        Genre genre;

        Book(String title, Genre genre) {
            this.title = title;
            this.genre = genre;
        }

        void displayInfo() {
            System.out.println("  " + title + " [" + genre + "]");
        }
    }
}