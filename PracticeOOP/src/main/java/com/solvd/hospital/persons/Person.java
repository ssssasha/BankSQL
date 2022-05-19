package com.solvd.hospital.persons;

import com.solvd.hospital.interfaces.IDisplayInfo;


public abstract class Person implements IDisplayInfo {
    private String name;
    private String surname;
    private int age;
    private String phone;

    public Person() {
    }

    public Person(String name, String surname, int age, String phone) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 110)
            this.age = age;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public void display(){
//        System.out.println("Name:" + " " + name + "  " + "Surname:" + surname);
//    };
}
