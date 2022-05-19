package com.solvd.hospital.enums;

public enum Doctors {
    PEDIATRICIAN("pediatrician"),
    THERAPIST("therapist"),
    DENTIST("dentist"),
    CARDIOLOGIST("cardiologist"),
    SURGEON("surgeon"),
    TRAUMATOLOGIST("traumatologist");

    private final String title;

    Doctors(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}