package com.adminski;

public class Doctor extends Professional {
    private String specialization;

    public Doctor(String name, int experience, double rating, String specialization) {
        super(name, experience, rating);
        this.specialization = specialization;
    }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    @Override
    public void work() {
        System.out.println("Работает на минстерство здраваохранения");
    }
    @Override
    public String getResponsibilities() {
        return "Клятва Гиппократа";
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Специализация: " + specialization);
    }
}