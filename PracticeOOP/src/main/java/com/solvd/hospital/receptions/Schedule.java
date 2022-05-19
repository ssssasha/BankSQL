package com.solvd.hospital.receptions;

import java.time.LocalTime;

public class Schedule {
    private String day;
    private LocalTime startOfReception;
    private LocalTime endOfReception;
    private int officeNumber;

    public Schedule() {
    }

    public Schedule(String day, LocalTime startOfReception, LocalTime endOfReception, int officeNumber) {
        this.day = day;
        this.startOfReception = startOfReception;
        this.endOfReception = endOfReception;
        this.officeNumber = officeNumber;
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public LocalTime getStartOfReception() {
        return this.startOfReception;
    }

    public void setStartOfReception(LocalTime startOfReception) {
        this.startOfReception = startOfReception;
    }

    public LocalTime getEndOfReception() {
        return this.endOfReception;
    }

    public void setEndOfReception(LocalTime endOfReception) {
        this.endOfReception = endOfReception;
    }

    public int getOffice() {
        return this.officeNumber;
    }

    public void setOffice(int office) {
        this.officeNumber = office;
    }

    @Override
    public String toString() {
        return "Schedule: " + " " + day + " " + startOfReception + " " + endOfReception;
    }
}
