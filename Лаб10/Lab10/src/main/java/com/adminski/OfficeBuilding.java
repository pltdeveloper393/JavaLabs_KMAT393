package com.adminski;

public class OfficeBuilding implements Buildable, Habitable {
    private String address;
    private int floors;
    private int companies;

    public OfficeBuilding(String address, int floors, int companies) {
        this.address = address;
        this.floors = floors;
        this.companies = companies;
    }

    public String getAddress() { return address; }
    public int getCompanies() { return companies; }

    @Override
    public void build() {
        System.out.println("Построено офисное здание: " + address + " (" + floors + " этажей)");
    }

    @Override
    public int getFloors() {
        return floors;
    }

    @Override
    public void live() {
        System.out.println("Офисное здание " + address + " заселено компаниями");
    }

    @Override
    public int getCapacity() {
        return companies * 25;
    }

    public void displayInfo() {
        System.out.println("Офисное здание | " + address + " | " + floors + " этажей | " +
                companies + " компаний | вместимость: " + getCapacity() + " чел.");
    }
}