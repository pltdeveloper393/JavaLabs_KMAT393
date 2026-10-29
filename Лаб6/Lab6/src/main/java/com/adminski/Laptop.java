package com.adminski;

public class Laptop {
    private String brand;
    private int ram;
    private int storage;
    private double price;
    private String gpu;

    public String getGpu() { return this.gpu; }
    public void setGpu(String g) { this.gpu = g; }

    Laptop(String b, int r, int s, double p, String g) {
        this(b, r, s, p);
        this.gpu = g;
    }















    Laptop(String brand, int ram, int storage, double price) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void applyDiscount(double discount) {
        price -= price * discount / 100;
    }

    public void displayInfo() {
        System.out.println("Бренд: " + brand);
        System.out.println("ОЗУ: " + ram + " ГБ");
        System.out.println("Накопитель: " + storage + " ГБ");
        System.out.println("Цена: " + price + " руб.");
    }
}