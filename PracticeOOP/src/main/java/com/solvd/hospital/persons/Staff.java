package com.solvd.hospital.persons;

import com.solvd.hospital.enums.StaffTypes;

public abstract class Staff extends Person {

    private StaffTypes staffType;
    private int experience;

    public Staff() {
    }

    public Staff(String name, String surname, int age, StaffTypes staffType, int experience, String phone) {
        super(name, surname, age, phone);
        this.staffType = staffType;
        this.experience = experience;
    }

    public StaffTypes getStaffType() {
        return this.staffType;
    }

    public void setStaffType(StaffTypes position) {
        this.staffType = position;
    }

    public int getExperience() {
        return this.experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {

        return super.getName() + " " + super.getSurname() + " " + staffType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Staff staff = (Staff) obj;
        return experience == staff.experience && (super.getName() == staff.getName()
                || (super.getName() != null && super.getName().equals(staff.getName())))
                && (super.getSurname() == staff.getSurname()
                || (super.getSurname() != null && super.getSurname().equals(staff.getSurname())));
        //return Objects.equals(super.getName(), patient.getName());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((super.getName() == null) ? 0 : super.getName().hashCode());
        result = prime * result + experience;
        result = prime * result + ((super.getSurname() == null) ? 0 : super.getSurname().hashCode());
        return result;
    }

}
