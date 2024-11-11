package src;

public class AssignmentOne {
    public static void main(String[] args){

		System.out.println("Hello, World!");
	
    }

    class HealthProfessional {
        // HealthProfessional instance variables
        private int ID;
        private String name;
        private String availability;

        // Default constructor
        public HealthProfessional() {
        }

        /**
         * Parametised constructor for objects of class HealthProfessional
         */
        public HealthProfessional(int ID, String name, String availability) {
            this.ID = ID;
            this.name = name;
            this.availability = availability;
        }

        /**
         * Method to print all instance variables
         */
        public void printInfo() {
            System.out.println("ID: " + ID);
            System.out.println("Name: " + name);
            System.out.println("Availability: " + availability);
        }

    }

    class GeneralPractitioner extends HealthProfessional {
        private int numberOfPatients;

        // Default constructor
        public GeneralPractitioner() {
        }

        /**
         * Parametised constructor for objects of child class GeneralPractitoner
         */
        public GeneralPractitioner(int ID, String name, String availability, int numberOfPatients) {
            super(ID, name, availability);
            this.numberOfPatients = numberOfPatients;
        }

        //Method to print details, including the health professional type
        public void printInfo() {
            System.out.println("The health professional details are (General Practitoner):");
            super.printInfo();
            System.out.println("Number of Patients: " + numberOfPatients);
        }
    }

};

