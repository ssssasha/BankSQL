package com.solvd.hospital;

import com.solvd.hospital.enums.Day;
import com.solvd.hospital.enums.Doctors;
import com.solvd.hospital.enums.StaffTypes;
import com.solvd.hospital.exceptions.NumberException;
import com.solvd.hospital.fuctionalInterfaces.IPrint;
import com.solvd.hospital.persons.Doctor;
import com.solvd.hospital.persons.Patient;
import com.solvd.hospital.receptions.Visit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Hospital {
    private final static Logger LOGGER = LogManager.getLogger(Hospital.class);
    private static final List<Doctor> doctorList = Hospital.generateDoctors();

    public static ArrayList<Patient> generatePatients() {
        ArrayList<Patient> patients = new ArrayList<Patient>();
        patients.add(new Patient("John", "Smith", 22, "Park Street", "+0983425467"));
        patients.add(new Patient("James", "Brown", 18, "Abbey Street", "+0983428888"));
        patients.add(new Patient("David", "Parker", 18, "Corn Street", "+0983428888"));
        patients.add(new Patient("Betty", "Wood", 18, "Bazely Street", "+0983428888"));
        patients.add(new Patient("Sandra", "Baker", 18, "Boston street", "+0983428888"));
        patients.add(new Patient("Mark", "Adams", 18, "Broad street", "+0983428888"));
        return patients;
    }

    public static ArrayList<Doctor> generateDoctors() {
        ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        doctors.add(new Doctor("Emma", "Miller", 32, StaffTypes.DOCTOR, Doctors.TRAUMATOLOGIST,
                8, "+0972316272"));
        doctors.add(new Doctor("Olivia", "Mitchell", 29, StaffTypes.DOCTOR, Doctors.CARDIOLOGIST,
                8, "+0972316272"));
        doctors.add(new Doctor("Margaret", "Wilson", 29, StaffTypes.DOCTOR, Doctors.DENTIST,
                5, "+0972316271"));
        doctors.add(new Doctor("Ella", "Collins", 29, StaffTypes.DOCTOR, Doctors.PEDIATRICIAN,
                5, "+0972316271"));
        doctors.add(new Doctor("Jacob", "Davis", 29, StaffTypes.DOCTOR, Doctors.SURGEON,
                5, "+0972316271"));
        doctors.add(new Doctor("Sarah", "Hayes", 29, StaffTypes.DOCTOR, Doctors.THERAPIST,
                5, "+0972316271"));
        return doctors;
    }

    public static void generateVisit(Doctors doctorType, Patient patient) {
        Visit visit = null;
        Scanner sc = new Scanner(System.in);
        visit = new Visit();
        LOGGER.info("Select the reception day");
        LOGGER.info("\n" +
                "Enter 1 if Monday \n" +
                "Enter 2 if Tuesday \n" +
                "Enter 3 if Wednesday \n" +
                "Enter 4 if Thursday \n" +
                "Enter 5 if Friday \n" +
                "Enter 6 if Saturday");
        int n = sc.nextInt();
        if (n == 1) {
            visit.setDay(Day.MONDAY);
        } else if (n == 2) {
            visit.setDay(Day.TUESDAY);
        } else if (n == 3) {
            visit.setDay(Day.WEDNESDAY);
        } else if (n == 4) {
            visit.setDay(Day.THURSDAY);
        } else if (n == 5) {
            visit.setDay(Day.FRIDAY);
        } else if (n == 6) {
            visit.setDay(Day.SATURDAY);
        } else {
            throw new NumberException("It looks like you entered an incorrect number. Please, try again");
        }
        LOGGER.info("Select the reception time");
        LOGGER.info("\n" +
                "Enter 1 if 8:00 \n" +
                "Enter 2 if 8:30 \n" +
                "Enter 3 if 9:00 \n" +
                "Enter 4 if 9:30 \n" +
                "Enter 5 if 10:00 \n" +
                "Enter 6 if 10:30 \n" +
                "Enter 7 if 11:00 \n" +
                "Enter 8 if 11:30 \n" +
                "Enter 9 if 12:00");
        int num = sc.nextInt();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("hh:mm");
        if (num == 1) {
            LocalTime time = LocalTime.of(8, 0);
            visit.setTime(time);
        } else if (num == 2) {
            LocalTime time = LocalTime.of(8, 30);
            visit.setTime(time);
        } else if (num == 3) {
            LocalTime time = LocalTime.of(9, 0);
            visit.setTime(time);
        } else if (num == 4) {
            LocalTime time = LocalTime.of(9, 30);
            visit.setTime(time);
        } else if (num == 5) {
            LocalTime time = LocalTime.of(10, 0);
            visit.setTime(time);
        } else if (num == 6) {
            LocalTime time = LocalTime.of(10, 30);
            visit.setTime(time);
        } else if (num == 7) {
            LocalTime time = LocalTime.of(11, 0);
            visit.setTime(time);
        } else if (num == 8) {
            LocalTime time = LocalTime.of(11, 30);
            visit.setTime(time);
        } else if (num == 9) {
            LocalTime time = LocalTime.of(12, 0);
            visit.setTime(time);
        } else {
            throw new NumberException("It looks like you entered an incorrect number. Please, try again");
        }
//        for(Doctor doctor : doctorList){
//            if(doctor.getSpeciality().equals(doctorType))
//                visit.setDoctor(doctor);
//        }
//        for (Doctor doctor: doctorList.stream().filter(doctor ->
//                doctor.getSpeciality().equals(doctorType)).collect(Collectors.toList())){
//            visit.setDoctor(doctor);
//        }
        Visit finalVisit = visit;
        doctorList.stream().filter(doctor -> doctor.getSpeciality().equals(doctorType))
                .peek(doctor -> finalVisit.setDoctor(doctor));
        visit.setPatient(patient);
        LOGGER.info("You have signed up for a visit");
        IPrint<Visit> iPrint = (v) -> LOGGER.info(v);
        iPrint.print(visit);
    }

    public static Map<String, String> generateDentalReceipt() {
        Map<String, String> dentalDiagnose = new HashMap<String, String>();
        dentalDiagnose.put("Toothache", "Rinse your mouth with warm water, floss to remove food caught between teeth, \n" +
                " and take an over-the-counter pain reliever");
        dentalDiagnose.put("Cracked tooth", "You need to set crowns for cracked teeth to prevent " +
                "the crack from worsening.");
        dentalDiagnose.put("Stained teeth", "There are three options for whitening your teeth. Your dentist can use a \n"
                + "whitening agent and a special light. Or you can bleach them at home with a plastic tray and gel from \n "
                + "your dentist or a store. The simplest choice, whitening toothpaste and whitening rinses, only remove \n"
                + "surface stains.");
        dentalDiagnose.put("Crooked teeth", "To correct orthodontics you need to put braces (metal or trays)");
        return dentalDiagnose;
    }

    public static Map<String, String> generateCardiologyReceipt() {
        Map<String, String> cardiologyDiagnose = new HashMap<String, String>();
        cardiologyDiagnose.put("Abnormal heart rhythms", "Treatment for heart arrhythmias may include medications, \n " +
                "therapies such as vagal maneuvers, cardioversion, catheter procedures or heart surgery.");
        cardiologyDiagnose.put("Aorta disease", "Treatment  includes medications to keep your blood pressure low to \n" +
                "reduce the strain on your aorta. Regular monitoring to check for damage progression is vital.");
        return cardiologyDiagnose;
    }

    public static Map<String, String> generatePediatricReceipt() {
        Map<String, String> pediatricsDiagnose = new HashMap<String, String>();
        pediatricsDiagnose.put("Upper respiratory infection ", "Nasal decongestants can improve breathing. \n" +
                "Steam inhalation and gargling with salt water are a safe way to get relief from URI symptoms.\n" +
                "Analgesics like acetaminophen and NSAIDs can help reduce fever, aches, and pains.");
        pediatricsDiagnose.put("Strep throat", "Strep throat is treated using antibiotics");
        pediatricsDiagnose.put("Runny Nose", "Rest. Drink plenty of fluids, especially water. Use a saline nasal spray \n"
                + " to help relieve symptoms. A cool-mist humidifier at your bedside can combat congestion worsened by"
                + " dry winter air.");
        return pediatricsDiagnose;
    }

    public static Map<String, String> generateSurgeryReceipt() {

        Map<String, String> surgeryDiagnose = new HashMap<String, String>();
        surgeryDiagnose.put("Appendicitis", "After surgery you need to void strenuous activities, such as bicycle \n" +
                "riding, jogging, weight lifting, or aerobic exercise, until your doctor says it is okay");
        surgeryDiagnose.put("Acute pancreatitis", "For acute pancreatitis caused by gallstones lodged in the common \n" +
                "bile duct, doctors may perform a procedure called endoscopic retrograde cholangiopancreatography to \n" +
                "remove the stones and prevent further inflammation in the pancreas.");
        return surgeryDiagnose;
    }

    public static Map<String, String> generateTherapeuticReceipt() {

        Map<String, String> therapeuticDiagnose = new HashMap<String, String>();
        therapeuticDiagnose.put("Upper respiratory infection ", "Nasal decongestants can improve breathing. \n" +
                "Steam inhalation and gargling with salt water are a safe way to get relief from URI symptoms.\n" +
                "Analgesics like acetaminophen and NSAIDs can help reduce fever, aches, and pains.");
        therapeuticDiagnose.put("Strep throat", "Strep throat is treated using antibiotics");
        therapeuticDiagnose.put("Runny Nose", "Rest. Drink plenty of fluids, especially water. Use a saline nasal spray \n"
                + " to help relieve symptoms. A cool-mist humidifier at your bedside can combat congestion worsened by"
                + " dry winter air.");
        return therapeuticDiagnose;
    }

    public static Map<String, String> generateTraumaReceipt() {
        Map<String, String> traumaDiagnose = new HashMap<String, String>();
        traumaDiagnose.put("Scoliosis", "Scoliosis is managed simply with exercise, medical observation, \n" +
                "scoliosis-specific physical therapy, and chiropractic treatment from a chiropractic scoliosis \n" +
                "specialist. Yoga or pilates is also recommended to decrease their pain level and increase flexibility.");
        traumaDiagnose.put("Fracture", "The initial management of fractures consists of realignment of the broken limb \n"
                + "segment (if grossly deformed) and then immobilizing the fractured extremity in a splint. The distal \n"
                + "neurologic and vascular status must be clinically assessed and documented before and after realignment"
                + " and splinting.");
        return traumaDiagnose;
    }

    public static void visitResult(Map<String, String> map) {
        LOGGER.info("Thank you for contacting our hospital! Choose your diagnosis from your doctor to get treatment \n" +
                "instructions \n");
        Scanner sc = new Scanner(System.in);
        int k = 1;
        int t = 1;
        for (String key : map.keySet()) {
            LOGGER.info("Enter " + k + " if " + key + "\n");
            k++;
        }
        int num = sc.nextInt();
        for (String key : map.keySet()) {
            if (num == t) {
                LOGGER.info(map.get(key));
            }
            t++;
        }
    }
}

