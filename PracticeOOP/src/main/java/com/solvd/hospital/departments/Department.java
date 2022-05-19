package com.solvd.hospital.departments;

import com.solvd.hospital.interfaces.ISetInfo;

public abstract class Department implements ISetInfo {
    private int numberOfStaff;
    private int numberOfPatients;

    public Department() {
    }

    public Department(int numberOfStaff, int numberOfPatients) {
        this.numberOfStaff = numberOfStaff;
        this.numberOfPatients = numberOfPatients;
    }

    public int getNumberOfStaff() {
        return this.numberOfStaff;
    }

    public void setNumberOfStaff(int numberOfStaff) {
        this.numberOfStaff = numberOfStaff;
    }

    public int getNumberOfPatients() {
        return this.numberOfPatients;
    }

    public void setNumberOfPatients(int numberOfPatients) {
        this.numberOfPatients = numberOfPatients;
    }

}
