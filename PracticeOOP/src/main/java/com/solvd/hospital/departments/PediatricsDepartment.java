package com.solvd.hospital.departments;

import com.solvd.hospital.exceptions.FreeBedsException;
import com.solvd.hospital.interfaces.ICheckingPlaces;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PediatricsDepartment extends Department implements ICheckingPlaces {

    private final static Logger LOGGER = LogManager.getLogger(PediatricsDepartment.class);
    private int numberOfBeds;

    public PediatricsDepartment() {
    }

    public PediatricsDepartment(int numberOfStaff, int numberOfPatients, int numberOfBeds) {
        super(numberOfStaff, numberOfBeds);
        this.numberOfBeds = numberOfBeds;
    }

    public int getNumberOfBeds() {
        return this.numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public void setInfo() {
        setNumberOfBeds(42);
        setNumberOfPatients(20);
        setNumberOfStaff(22);
    }

    public void check() {
        LOGGER.info("Checking available beds");
        if(getNumberOfBeds() < getNumberOfPatients()){
            throw new FreeBedsException("Not enough beds");
        }
        LOGGER.info("There are available beds");
    }

    @Override
    public String toString() {
        return "PediatricsDepartment: " + " " + super.getNumberOfStaff() + " " + super.getNumberOfPatients() + " " + numberOfBeds;
    }
}
