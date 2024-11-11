package src;

public class AssignmentOne {

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

        //Method to print details, including the health professional type
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

        //Method to print details, including the health professional type
        public void printInfo() {
            System.out.println("The health professional details are (Allied Health Professional):");
            super.printInfo();
            System.out.println("Speciality: " + speciality);
        }
    };

    public static class Patient {
        private String name;
        private int phoneNumber;

        // Default constructor
        public Patient() {
        }

        // Parametised constructor for class Patient
        public Patient(String name, int phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public void printInfo() {
            System.out.println("The patients details are:");
            System.out.println(name);
            System.out.println(phoneNumber);
        }
    }

    public static class Appointment {
        private String preferredTimeSlot;
        private HealthProfessional selectedDoctor;

        //Default constructor
        public Appointment() {
        }
        
        //Parametised constructor for class Patient
        public Appointment(String preferredTimeSlot, HealthProfessional selectedDoctor) {
            this.preferredTimeSlot = preferredTimeSlot;
            this.selectedDoctor = selectedDoctor;
        }
        
        public void printInfo() {
            System.out.println("The appointment details are:");
            System.out.println(preferredTimeSlot);
            System.out.println(selectedDoctor.name);
        }
    }


// Part 3 - Using classes and objects
    
        public static void main(String[] args){
    
            GeneralPractitioner gp1 = new GeneralPractitioner(1,"Dr Grant Rogers",false,20);
            GeneralPractitioner gp2 = new GeneralPractitioner(1,"Dr Jenni Soden",true,10);
            GeneralPractitioner gp3 = new GeneralPractitioner(1,"Dr Brent Williams",true,14);

            AlliedHealthProfessional ahp1 = new AlliedHealthProfessional(1,"Dr Renae Paul",false,"Psychology");
            AlliedHealthProfessional ahp2 = new AlliedHealthProfessional(1,"Dr Liz Forsyth",true,"Dietitian");

            Object[] doctors = {gp1,gp2,gp3,ahp1,ahp2};

            for (var i : doctors) {
                ((HealthProfessional) i).printInfo();
                System.out.println("\n");
            }

            System.out.println("------------------------------");

    };

}