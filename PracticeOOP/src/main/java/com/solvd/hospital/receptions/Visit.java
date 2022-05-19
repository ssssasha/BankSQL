package com.solvd.hospital.receptions;



import com.solvd.hospital.enums.Day;
import com.solvd.hospital.persons.Doctor;
import com.solvd.hospital.persons.Patient;

import java.time.LocalTime;
import java.util.Objects;

public class Visit {

    private Day day;
    private LocalTime time;
    private Doctor doctor;
    private Patient patient;

    public Visit() {
    }

    public Visit(Day day, LocalTime time, Doctor doctor, Patient patient) {
        this.day = day;
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Day getDay() {
        return this.day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public LocalTime getTime() {
        return this.time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Visit: " + " " + day + " " + time + "\n " + doctor + "\n " + patient;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Visit visit = (Visit) obj;
        return  (Objects.equals(day, visit.day))
                && (Objects.equals(doctor, visit.doctor));
        //return Objects.equals(super.getName(), patient.getName());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((day == null) ? 0 : day.hashCode());
        result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
        return result;
    }
}
