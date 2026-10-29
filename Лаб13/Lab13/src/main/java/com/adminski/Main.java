package com.adminski;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Hotel> hotels = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("=== Создание отелей ===\n");
        tryCreateHotel("Спутник",   "Минск",    5,  100);
        tryCreateHotel("Виктория",  "Брест",    4,  200);
        tryCreateHotel("Беларусь",  "Минск",    3,  200);
        tryCreateHotel("Полонез",   "Минск",    2,  7);

        tryCreateHotel("Проверка1",     "Минск",    911,  100);
        tryCreateHotel("Проверка2",     "Брест",    3,  0);
        tryCreateHotel("Проверка3",     "Минск",    3,  100);


        System.out.println("\n=== Бронирование ===\n");
        tryBookRoom("Спутник");
        tryBookRoom("Беларусь");
        tryBookRoom("Беларусь");
        tryBookRoom("Полонез");





        System.out.println("\n=== Выселение ===\n");
        tryCheckOut("Беларусь");


        System.out.println("\n=== Бронирование до отказа (Полонез) ===\n");
        for (int i = 0; i < 9; i++) {
            tryBookRoom("Полонез");
        }


        System.out.println("\n=== Поиск по звёздам ===\n");
        searchByStars();


        System.out.println("\n=== Состояние системы ===\n");
        for (Hotel h : hotels) {
            System.out.println(h.displayInfo());
        }
    }

    static void tryCreateHotel(String name, String city, int stars, int rooms) {
        try {
            Hotel h = new Hotel(name, city, stars, rooms);
            hotels.add(h);
            System.out.println("[+] Добавлен отель: " + h.getName());
        }
        catch (InvalidHotelDataException e) {
            System.out.println(e.getMessage());
        }
    }

    static void tryBookRoom(String hotelName) {
        try {
            Hotel h = findHotel(hotelName);
            h.bookRoom();
            System.out.println("[+] Комната в \"" + h.getName() + "\" забронирована. Свободно: " + h.getAvailableRooms());
        }
        catch (HotelNotFoundException | RoomNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }

    static void tryCheckOut(String hotelName) {
        try {
            Hotel h = findHotel(hotelName);
            h.checkOut();
            System.out.println("[+] Из \"" + h.getName() + "\" всех высадили. Свободно: " + h.getAvailableRooms());
        }
        catch (HotelNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    static void searchByStars() {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print("Введите кол-во звёзд поиска: ");
            try {
                int stars = Integer.parseInt(s.nextLine());
                if (stars >= 1 && stars <= 5) {
                    printByStars(stars);
                    break;
                }
                else throw new IllegalArgumentException();
            }
            catch (NumberFormatException e) {
                System.err.println(ErrorMessage.show(0));
            }
            catch (IllegalArgumentException e) {
                System.err.println(ErrorMessage.show(1));
            }
        }
    }

    static void printByStars(int stars) {
        boolean chk = false;
        for (Hotel h : hotels) {
            if (h.getStars() == stars) {
                chk = true;
                System.out.println(h.getName() + " | " + h.getCity() + " | свободно комнат: " + h.getAvailableRooms());
            }
        }
        if (chk == false) {
            System.out.println("[!] Отели с " + stars + " звёздами отсутствуют");
        }
    }

    static Hotel findHotel(String name) throws HotelNotFoundException {
        for (Hotel h : hotels) {
            if (h.getName().equals(name)) {
                return h;
            }
        }
        throw new HotelNotFoundException("[?] Отель \"" + name + "\" не найден", name);
    }
}