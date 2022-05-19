package com.solvd.hospital.departments;

import com.solvd.hospital.exceptions.FreeBedsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TraumaDepartment extends Department {

    private final static Logger LOGGER = LogManager.getLogger(TraumaDepartment.class);
    private int numberOfBeds;

    public TraumaDepartment() {
    }

    public TraumaDepartment(int numberOfStaff, int numberOfPatients, int numberOfBeds) {
        super(numberOfStaff, numberOfBeds);
        this.numberOfBeds = numberOfBeds;
    }

    public int getNumberOfBeds() {
        return this.numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    @Override
    public String toString() {
        return "TraumaDepartment " + " " + super.getNumberOfStaff() + " " + super.getNumberOfPatients() + " " + numberOfBeds;
    }

    public void setInfo() {
        setNumberOfBeds(28);
        setNumberOfPatients(7);
        setNumberOfStaff(14);
    }

    public void check() {
        LOGGER.info("Checking available beds");
        if (getNumberOfBeds() < getNumberOfPatients()) {
            throw new FreeBedsException("Not enough beds");
        }
        LOGGER.info("There are available beds");
    }

}
