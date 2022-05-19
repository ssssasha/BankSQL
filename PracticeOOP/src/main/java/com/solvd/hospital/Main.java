package com.solvd.hospital;

import com.solvd.hospital.enums.Doctors;
import com.solvd.hospital.exceptions.NumberException;
import com.solvd.hospital.fuctionalInterfaces.ISearch;
import com.solvd.hospital.persons.Doctor;
import com.solvd.hospital.persons.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger(Main.class);
    private static final List<Doctor> doctorList = Hospital.generateDoctors();

    public static void main(String[] args) {

        List<Patient> patientList = Hospital.generatePatients();
        Patient ourPatient = null;
        Scanner scanner = new Scanner(System.in);
        //LOGGER.info("All patients:" + patientList);
        LOGGER.info("Good day. You applied to the regional hospital number 2. Please, enter your surname:");
        String secondName = scanner.nextLine();
        ISearch p = (s) -> s.equals(secondName);
        for (Patient patient : patientList) {
            if (p.find(patient.getSurname())) {
                ourPatient = patient;
            }
        }
        if (ourPatient == null) {
            LOGGER.info("You are not in our database. Please, enter your details to add you to the patient database");
            ourPatient = new Patient();
            LOGGER.info("Please, enter your name:");
            ourPatient.setName(scanner.nextLine());
            ourPatient.setSurname(secondName);
            LOGGER.info("Please, enter your age:");
            ourPatient.setAge(scanner.nextInt());
            scanner.nextLine();
            LOGGER.info("Please, enter your address:");
            ourPatient.setAddress(scanner.nextLine());
            LOGGER.info("Please, enter your phone:");
            ourPatient.setPhone(scanner.nextLine());
        }
        ourPatient.displayInfo();
        LOGGER.info("choose the doctor you would like to make an appointment with");
        LOGGER.info("\n" +
                "Enter 1 if pediatrician \n" +
                "Enter 2 if therapist \n" +
                "Enter 3 if dentist \n" +
                "Enter 4 if cardiologist \n" +
                "Enter 5 if surgeon \n" +
                "Enter 6 if traumatologist");
        int number = scanner.nextInt();
        switch (number) {
            case 1:
                Hospital.generateVisit(Doctors.PEDIATRICIAN, ourPatient);
                Hospital.visitResult(Hospital.generatePediatricReceipt());
                break;
            case 2:
                Hospital.generateVisit(Doctors.THERAPIST, ourPatient);
                Hospital.visitResult(Hospital.generateTherapeuticReceipt());
                break;
            case 3:
                Hospital.generateVisit(Doctors.DENTIST, ourPatient);
                Hospital.visitResult(Hospital.generateDentalReceipt());
                break;
            case 4:
                Hospital.generateVisit(Doctors.CARDIOLOGIST, ourPatient);
                Hospital.visitResult(Hospital.generateCardiologyReceipt());
                break;
            case 5:
                Hospital.generateVisit(Doctors.SURGEON, ourPatient);
                Hospital.visitResult(Hospital.generateSurgeryReceipt());
                break;
            case 6:
                Hospital.generateVisit(Doctors.TRAUMATOLOGIST, ourPatient);
                Hospital.visitResult(Hospital.generateTraumaReceipt());
                break;
            default:
                throw new NumberException("It looks like you entered an incorrect number. Please, try again");
        }

//        doctorList.stream()
//                .filter(e -> e.getExperience() > 5)
//                .peek(e -> LOGGER.info("Filtered value: " + e))
//                .collect(Collectors.toList());


//        ISupplier<CardiologyDepartment> cd = ()->{
//            return new CardiologyDepartment(10, 20,28);
//        };
//        CardiologyDepartment cardiologyDepartment = cd.get();
//        LOGGER.info(cardiologyDepartment);
//        List<Visit> visitList = Hospital.generateVisits();
//        System.out.println(doctor1.equals(doctor2));
//        System.out.println(visit1.equals(visit2));
//        Speciality speciality = new Speciality("стоматолог");
//        System.out.println(speciality.hashCode());


//        CardiologyDepartment cardiologyDepartment = new CardiologyDepartment();
//        cardiologyDepartment.setInfo();
//        cardiologyDepartment.check();
//        ChildbirthDepartment childbirthDepartment = new ChildbirthDepartment();
//        childbirthDepartment.setInfo();
//        childbirthDepartment.check();
//        DentalDepartment.CheckQueue();
//

    }
}
