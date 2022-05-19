package com.solvd.hospital.departments;

import com.solvd.hospital.exceptions.QueueException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DentalDepartment extends Department {

    private final static Logger LOGGER = LogManager.getLogger(DentalDepartment.class);
    static int dentalChairs;
    static int numOfClients;

    public DentalDepartment() {
    }

    public DentalDepartment(int numberOfStaff, int numberOfPatients) {
        super(numberOfStaff, numberOfPatients);
    }

    public static void CheckQueue() {
        LOGGER.info("Check for queue");
        dentalChairs = 4;
        numOfClients = 5;
        if (numOfClients > dentalChairs) {
            throw new QueueException("Queue is formed");
        }
        LOGGER.info("There is no queue");
    }

    public void setInfo() {
        setNumberOfPatients(3);
        setNumberOfStaff(10);
    }

    @Override
    public String toString() {
        return "DentalDepartment: " + " " + super.getNumberOfStaff() + " " + super.getNumberOfPatients();
    }
}
