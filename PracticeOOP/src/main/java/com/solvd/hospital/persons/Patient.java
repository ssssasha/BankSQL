package com.solvd.hospital.persons;


import com.solvd.hospital.exceptions.DisplayInfoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Patient extends Person {

    private final static Logger LOGGER = LogManager.getLogger(Patient.class);
    private String address;

    public Patient() {
    }

    public Patient(String name, String surname, int age, String address, String phone) {
        super(name, surname, age, phone);
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void displayInfo() {
        if (super.getName() == null || super.getSurname() == null || super.getAge() == 0) {
            throw new DisplayInfoException("Data not provided");
        }
        LOGGER.info(super.getName() + " " + super.getSurname() + " " + super.getAge() + " " + address);
    }

    @Override
    public String toString() {
        return "Patient: " + " " + super.getName() + " " + super.getSurname();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((super.getName() == null) ? 0 : super.getName().hashCode());
        LOGGER.info(result);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Patient patient = (Patient) obj;
        return Objects.equals(super.getName(), patient.getName());
    }
}
