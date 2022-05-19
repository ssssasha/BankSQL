package com.solvd.hospital.departments;


import com.solvd.hospital.exceptions.FreeBedsException;
import com.solvd.hospital.interfaces.ICheckingPlaces;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SurgeryDepartment extends Department implements ICheckingPlaces {

    private final static Logger LOGGER = LogManager.getLogger(SurgeryDepartment.class);
    private int numberOfBeds;

    public SurgeryDepartment() {
    }

    public SurgeryDepartment(int numberOfStaff, int numberOfPatients, int numberOfBeds) {
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
        setNumberOfBeds(27);
        setNumberOfPatients(5);
        setNumberOfStaff(21);
    }

    public void check() {
        LOGGER.info("Checking available beds");
        if (getNumberOfBeds() < getNumberOfPatients()) {
            throw new FreeBedsException("Not enough beds");
        }
        LOGGER.info("There are available beds");
    }

    @Override
    public String toString() {
        return "SurgeryDepartment: " + " " + super.getNumberOfStaff() + " " + super.getNumberOfPatients() + " " + numberOfBeds;
    }

}
