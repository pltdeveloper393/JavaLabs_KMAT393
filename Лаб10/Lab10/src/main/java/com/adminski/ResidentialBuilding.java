package com.adminski;

public class ResidentialBuilding implements Buildable, Habitable {
    private String address;
    private int floors;
    private int apartments;

    public ResidentialBuilding(String address, int floors, int apartments) {
        this.address = address;
        this.floors = floors;
        this.apartments = apartments;
    }

    public String getAddress() {
        return address;
    }

    public int getApartments() {
        return apartments;
    }

    @Override
    public void build() {
        System.out.println("Построен жилое здание: " + address + " (" + floors + " этажей)");
    }

    @Override
    public int getFloors() {
        return floors;
    }

    @Override
    public void live() {
        System.out.println("Жилое здание " + address + " заселено");
    }

    @Override
    public int getCapacity() {
        return apartments * 3;
    }

    public void displayInfo() {
        System.out.println("Жилой дом | " + address + " | " + floors + " этажей | " +
                apartments + " квартир | вместимость: " + getCapacity() + " чел.");
    }
}