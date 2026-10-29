package com.adminski;

public class Hotel {
    private String name;
    private String city;
    private int stars;
    private int rooms;
    private int availableRooms;

    public Hotel(String name, String city, int stars, int rooms) throws InvalidHotelDataException {
        setName(name);
        setCity(city);
        setStart(stars);
        setRooms(rooms);
        setAvailableRooms(rooms);
    }


    public String getName() {
        return name;
    }
    public String getCity() {
        return city;
    }
    public int getStars() {
        return stars;
    }
    public int getRooms() {
        return rooms;
    }
    public int getAvailableRooms() {
        return availableRooms;
    }



    public void setName(String n) throws InvalidHotelDataException  {
        if (n == null || n.isEmpty()) {
            throw new InvalidHotelDataException("[!] Название отеля не может быть пустым");
        }
        this.name = n;
    }
    public void setCity(String c) throws InvalidHotelDataException {
        this.city = c;
    }
    public void setStart(int s) throws InvalidHotelDataException {
        if (s < 1 || s > 5) {
            throw new InvalidHotelDataException("[!] Звёзд должно быть от 1 до 5, недопустимо значение" + stars);
        }
        this.stars = s;
    }
    public void setRooms(int r) throws InvalidHotelDataException {
        if (r <= 0) {
            throw new InvalidHotelDataException("[!] Комнат должно быть больше нуля, недопустимо значение" + rooms);
        }
        this.rooms = r;
    }
    public void setAvailableRooms(int a) {
        this.availableRooms = a;
    }



    public void bookRoom() throws RoomNotAvailableException {
        if (availableRooms <= 0) {
            throw new RoomNotAvailableException("[!] В \"" + name + "\" мест больше нет", name, availableRooms);
        }
        availableRooms--;
    }

    public void checkOut() {
        if (availableRooms < rooms) {
            availableRooms++;
        }
    }

    public String displayInfo() {
        return name + " | " + city + " | " + stars + " звёзд | комнат: " + rooms + " | свободно: " + availableRooms;
    }
}