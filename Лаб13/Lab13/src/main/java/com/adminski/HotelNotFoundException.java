package com.adminski;

public class HotelNotFoundException extends Exception {
    private String hotelName;

    public HotelNotFoundException(String message, String hotelName) {
        super(message);
        this.hotelName = hotelName;
    }

    public String getHotelName() {
        return hotelName;
    }
}