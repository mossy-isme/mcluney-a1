package src;

import java.util.ArrayList;

public class AssignmentOne {
    static ArrayList<Appointment> appointmentList = new ArrayList<>();

    public static class HealthProfessional {
        // HealthProfessional instance variables
        private int ID;
        private String name;
        private Boolean available;

        // Default constructor
        public HealthProfessional() {
        }

        /**
         * Parametised constructor for objects of class HealthProfessional
         */
        public HealthProfessional(int ID, String name, Boolean available) {
            this.ID = ID;
            this.name = name;
            this.available = available;
        }

        // Setter for availability of HealthProfessional objects
        public void setAvailability(Boolean available) {
            this.available = available;
        }

        /**
         * Method to print all instance variables
         */
        public void printInfo() {
            System.out.println("ID: " + ID);
            System.out.println("Name: " + name);
            System.out.println("Available?: " + available);
        }

    }

    public static class GeneralPractitioner extends HealthProfessional {
        private int numberOfPatients;

        // Default constructor
        public GeneralPractitioner() {
        }

        /**
         * Parametised constructor for objects of child class GeneralPractitoner
         */
        public GeneralPractitioner(int ID, String name, Boolean available, int numberOfPatients) {
            super(ID, name, available);
            this.numberOfPatients = numberOfPatients;
        }

        // Method to print details, including the health professional type
        public void printInfo() {
            System.out.println("The health professional details are (General Practitoner):");
            super.printInfo();
            System.out.println("Number of Patients: " + numberOfPatients);
        }
    }

    public static class AlliedHealthProfessional extends HealthProfessional {
        private String speciality;

        // Default constructor
        public AlliedHealthProfessional() {
        }

        /**
         * Parametised constructor for objects of child class AlliedHealthProfessional
         */
        public AlliedHealthProfessional(int ID, String name, Boolean available, String speciality) {
            super(ID, name, available);
            this.speciality = speciality;
        }

        // Method to print details, including the health professional type
        public void printInfo() {
            System.out.println("The health professional details are (Allied Health Professional):");
            super.printInfo();
            System.out.println("Speciality: " + speciality);
        }
    };

    public static class Patient {
        private String name;
        private String phoneNumber;

        // Default constructor
        public Patient() {
        }

        // Parametised constructor for class Patient
        public Patient(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        // Method to display info relating to the Patient
        public void printInfo() {
            System.out.println("The patients details are:");
            System.out.println(name);
            System.out.println(phoneNumber);
        }

        // phoneNumber getter.
        public String getPhoneNumber() {
            return phoneNumber;
        }

        // name getter.
        public String getName() {
            return name;
        }
    }

    public static class Appointment {
        private Object patient;
        private String preferredTimeSlot;
        private HealthProfessional selectedDoctor;

        // Default constructor
        public Appointment() {
        }

        // Parametised constructor for class Patient
        public Appointment(Patient patient, String preferredTimeSlot, HealthProfessional selectedDoctor) {
            this.patient = patient;
            this.preferredTimeSlot = preferredTimeSlot;
            this.selectedDoctor = selectedDoctor;
        }

        // Print appointment info
        public void printInfo() {
            System.out.println("The appointment details are:");
            System.out.println(((Patient) patient).getName());
            System.out.println(preferredTimeSlot);
            System.out.println(selectedDoctor.name);
        }

        public Object getPatient() {
            return patient;
        }

        public String getPreferredTimeSlot() {
            return preferredTimeSlot;
        }

        public HealthProfessional getSelectedDoctor() {
            return selectedDoctor;
        }
    }

    // Create appointment
    public static void createAppointment(Patient patient, String preferredTimeSlot, HealthProfessional selectedDoctor) {
        boolean found = false;
        if (patient == null || preferredTimeSlot == null || selectedDoctor == null) {
            System.out.println("Error: All required information must be provided to book an appointment.");
        }

        for (Appointment appointment : appointmentList) {
            if (appointment.getSelectedDoctor() == selectedDoctor
                    && appointment.getPreferredTimeSlot() == preferredTimeSlot) {
                System.out.println("Doctor is already booked during this time. Please try again.");
                found = true;
                break;
            }
        }
        if (!found) {
            Appointment newAppointment = new Appointment(patient, preferredTimeSlot, selectedDoctor);
            appointmentList.add(newAppointment);
            System.out.println("Appointment created successfully for: " + patient.name);
        }
    }

    // Print existing appointments in ArrayList

    public static void printExistingAppointments() {
        if (appointmentList == null) {
            System.out.println("Appointment list empty.");
        } else {
            for (Appointment i : appointmentList) {
                i.printInfo();
                System.out.println("\n");
            }
        }
    }

    // Cancel existing booking

    public static void cancelBooking(String phoneNumber) {
        boolean found = false;
        for (Appointment appointment : appointmentList) {
            Object patient = appointment.getPatient();

            if (((Patient) patient).getPhoneNumber() == phoneNumber) {
                appointmentList.remove(appointment);
                System.out.println("Appointment for phone number " + phoneNumber + " has been cancelled.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Error: Appointment with phone number " + phoneNumber + " not found.");
        }
    }

    public static void main(String[] args) {

        // Part 3 - Using classes and objects

        GeneralPractitioner gp1 = new GeneralPractitioner(1, "Dr Grant Rogers", false, 20);
        GeneralPractitioner gp2 = new GeneralPractitioner(1, "Dr Jenni Soden", true, 10);
        GeneralPractitioner gp3 = new GeneralPractitioner(1, "Dr Brent Williams", true, 14);

        AlliedHealthProfessional ahp1 = new AlliedHealthProfessional(1, "Dr Renae Paul", false, "Psychology");
        AlliedHealthProfessional ahp2 = new AlliedHealthProfessional(1, "Dr Liz Forsyth", true, "Dietitian");

        Object[] doctors = { gp1, gp2, gp3, ahp1, ahp2 };

        for (Object i : doctors) {
            ((HealthProfessional) i).printInfo();
            System.out.println("\n");
        }

        System.out.println("------------------------------");

        // Part 5 - Collection of Appointments

        Patient MC = new Patient("Mossy Cluney", "0400038834");
        Patient WG = new Patient("William George", "0493283485");
        Patient LB = new Patient("Liam Bordon", "0423381234");
        Patient BJ = new Patient("Briah Jefferies", "0402393823");

        createAppointment(MC, "08:00", gp1);
        createAppointment(WG, "12:00", gp3);
        createAppointment(LB, "09:00", ahp1);
        createAppointment(BJ, "03:00", ahp2);

        printExistingAppointments();

        cancelBooking(MC.phoneNumber);

        printExistingAppointments();

        System.out.println("------------------------------");

    };

}