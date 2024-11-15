/**
 * This class represents a system for managing appointments between patients and health professionals.
 * It includes classes for HealthProfessional, GeneralPractitioner, AlliedHealthProfessional, Patient, and Appointment.
 * The main functionality includes creating appointments, printing existing appointments, and canceling bookings.
 */
package src;

import java.util.ArrayList;

public class AssignmentOne {
    /**
     * A static ArrayList that holds instances of Appointment objects.
     */
    static ArrayList<Appointment> appointmentList = new ArrayList<>();

    public static class HealthProfessional {
        
        /**
         * Represents an entity HealthProfessional with an ID, name, and availability status.
         */
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
        @Override
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
        @Override
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

        /**
         * Prints the appointment details including patient name, preferred time slot, and selected doctor's name.
         */
        public void printInfo() {
            System.out.println("The appointment details are:");
            System.out.println(((Patient) patient).getName());
            System.out.println(preferredTimeSlot);
            System.out.println(selectedDoctor.name);
        }

        /**
         * Retrieves the patient object.
         *
         * @return The patient object.
         */
        public Object getPatient() {
            return patient;
        }

        /**
         * Retrieves the preferred time slot for a specific task.
         *
         * @return The preferred time slot for the task.
         */
        public String getPreferredTimeSlot() {
            return preferredTimeSlot;
        }

        /**
         * Retrieves the currently selected health professional (doctor).
         *
         * @return The selected health professional (doctor).
         */
        public HealthProfessional getSelectedDoctor() {
            return selectedDoctor;
        }
    }

    // Create appointment
    public static void createAppointment(Patient patient, String preferredTimeSlot, HealthProfessional selectedDoctor) {
        boolean found = false;
        /**
         * Checks if all required information is provided to book an appointment.
         * If any of the patient, preferred time slot, or selected doctor is null,
         * an error message is printed indicating that all required information must be provided.
         *
         * @param patient The patient for whom the appointment is being booked
         * @param preferredTimeSlot The preferred time slot for the appointment
         * @param selectedDoctor The doctor selected for the appointment
         */
        if (patient == null || preferredTimeSlot == null || selectedDoctor == null) {
            System.out.println("Error: All required information must be provided to book an appointment.");
        }

        /**
         * Checks if a doctor is available during a preferred time slot and creates an appointment if available.
         *
         * @param appointmentList The list of existing appointments
         * @param patient The patient for whom the appointment is being scheduled
         * @param selectedDoctor The doctor selected for the appointment
         * @param preferredTimeSlot The preferred time slot for the appointment
         */
        for (Appointment appointment : appointmentList) {
            if (appointment.getSelectedDoctor() == selectedDoctor
                    && appointment.getPreferredTimeSlot().equals(preferredTimeSlot)) {
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
        /**
         * Prints the information of each appointment in the appointment list.
         *
         * If the appointment list is empty, it prints a message indicating that.
         * Otherwise, it iterates through each appointment in the list and prints its information.
         *
         * @param appointmentList The list of appointments to print
         */
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
        /**
         * Cancels an appointment based on the provided phone number.
         *
         * This method iterates through the list of appointments, checks if the appointment's patient's phone number matches
         * the provided phone number, and cancels the appointment if found. If the appointment is canceled, a confirmation message
         * is printed. If no appointment is found with the provided phone number, an error message is printed.
         *
         * @param appointmentList The list of appointments to search through
         * @param phoneNumber The phone number of the patient for whom the appointment should be canceled
         */
        for (Appointment appointment : appointmentList) {
            Object patient = appointment.getPatient();

            if (((Patient) patient).getPhoneNumber().equals(phoneNumber)) {
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
        GeneralPractitioner gp2 = new GeneralPractitioner(2, "Dr Jenni Soden", true, 10);
        GeneralPractitioner gp3 = new GeneralPractitioner(3, "Dr Brent Williams", true, 14);

        AlliedHealthProfessional ahp1 = new AlliedHealthProfessional(4, "Dr Renae Paul", false, "Psychology");
        AlliedHealthProfessional ahp2 = new AlliedHealthProfessional(5, "Dr Liz Forsyth", true, "Dietitian");

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