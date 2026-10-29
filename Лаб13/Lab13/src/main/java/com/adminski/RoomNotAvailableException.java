package com.adminski;

public class RoomNotAvailableException extends Exception {
    private String hotelName;
    private int availableRooms;

    public RoomNotAvailableException(String message, String hotelName, int availableRooms) {
        super(message);
        this.hotelName = hotelName;
        this.availableRooms = availableRooms;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }
}
