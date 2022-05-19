package com.solvd.hospital.fuctionalInterfaces;

import com.solvd.hospital.departments.CardiologyDepartment;

@FunctionalInterface
public interface ISupplier <T> {
    T get();
}

