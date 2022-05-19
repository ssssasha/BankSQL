package com.solvd.hospital.persons;

import com.solvd.hospital.enums.Doctors;
import com.solvd.hospital.enums.StaffTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Doctor extends Staff {

    private final static Logger LOGGER = LogManager.getLogger(Doctor.class);
    private Doctors speciality;

    public Doctor() {
    }

    public Doctor(String name, String surname, int age, StaffTypes staffType, Doctors speciality, int experience, String phone) {
        super(name, surname, age, staffType, experience, phone);
        this.speciality = speciality;
    }

    public Doctors getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(Doctors speciality) {
        this.speciality = speciality;
    }

    public void displayInfo() {
        LOGGER.info(super.getName() + " " + super.getSurname() + " " + super.getAge() + " " + speciality);
    }

    @Override
    public String toString() {
        return "Doctor: " + " " + super.getName() + " " + super.getSurname() + " " + speciality;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Doctor doctor = (Doctor) obj;
        return (super.getName() == doctor.getName()
                || (super.getName() != null && super.getName().equals(doctor.getName())))
                && (super.getSurname() == doctor.getSurname()
                || (super.getSurname() != null && super.getSurname().equals(doctor.getSurname())));
        //return Objects.equals(super.getName(), patient.getName());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((super.getName() == null) ? 0 : super.getName().hashCode());
        result = prime * result + ((super.getSurname() == null) ? 0 : super.getSurname().hashCode());
        return result;
    }
}
