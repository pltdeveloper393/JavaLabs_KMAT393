package com.adminski.test;

public class KKR {
    public static void main(String[] args) {

    }
}

abstract class Figure {
    private String name;

    Figure() {
        this.name = "Default Name";
    }
    Figure(String n) {
        this.name = n;
    }

    public abstract double s();

    public String getName() { return this.name; }
    public void setName(String n) { this.name = n; }
}

class Squar extends Figure {
    private double side;

    Squar(String n, double s) {
        super(n);
        this.side = s;
    }



    @Override
    public double s() {
        return this.side * 2.0;
    }
}
