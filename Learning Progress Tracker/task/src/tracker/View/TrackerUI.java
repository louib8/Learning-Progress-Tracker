package tracker.View;

import tracker.Model.Student;

public class TrackerUI {
    private static final String EXIT = "Bye!";
    private static final String TITLE = "Learning Progress Tracker";
    private static final String NO_INPUT = "No input.";
    private static final String ERROR_UNKNOWN_COMMAND = "Error: unknown command!";
    private static final String ADD_STUDENT_MESSAGE = "Enter student credentials or 'back' to return";
    private static final String STUDENT_ADDED = "The student has been added.";
    private static final String ERROR_FIRST_NAME = "Incorrect first name.";
    private static final String ERROR_LAST_NAME = "Incorrect last name.";
    private static final String ERROR_EMAIL = "Incorrect email.";
    private static final String ERROR_INVALID_CREDENTIALS = "Incorrect credentials.";
    private static final String EXIT_HINT = "Enter 'exit' to exit the program";
    private static final String ERROR_EMAIL_TAKEN = "This email is already taken.";
    private static final String STUDENT_HEADER = "Students: ";
    private static final String ERROR_NO_STUDENTS = "No students found.";
    private static final String ADD_POINTS_HEADER = "Enter an id and points or 'back' to return";
    private static String ERROR_NO_STUDENT_FOR_ID = "No student is found for id=%s";
    private static final String ERROR_INCORRECT_POINTS_FORMAT = "Incorrect points format.";
    private static final String POINTS_UPDATED = "Points updated";
    private static final String FIND_STUDENT_HEADER = "Enter an id or 'back' to return";
    private static String STUDENT_INFORMATION = "%s points: Java=%d; DSA=%d; Databases=%d; Spring=%d";
    private static final String STATISTICS_HEADER = "Type the name of a course to see details or 'back' to quit";

    public static void printEXIT() {
        System.out.println(EXIT);
    }

    public static void printStudentsAdded(int numStudents) {
        System.out.println("Total " + numStudents + " students have been added.");
    }

    public static void printTITLE() {
        System.out.println(TITLE);
    }

    public static void printNO_INPUT() {
        System.out.println(NO_INPUT);
    }

    public static void printERROR_UNKNOWN_COMMAND() {
        System.out.println(ERROR_UNKNOWN_COMMAND);
    }

    public static void printADD_STUDENT_MESSAGE() {
        System.out.println(ADD_STUDENT_MESSAGE);
    }

    public static void printSTUDENT_ADDED() {
        System.out.println(STUDENT_ADDED);
    }

    public static void printERROR_FIRST_NAME() {
        System.out.println(ERROR_FIRST_NAME);
    }

    public static void printERROR_LAST_NAME() {
        System.out.println(ERROR_LAST_NAME);
    }

    public static void printERROR_EMAIL() {
        System.out.println(ERROR_EMAIL);
    }

    public static void printERROR_INVALID_CREDENTIALS() {
        System.out.println(ERROR_INVALID_CREDENTIALS);
    }

    public static void printEXIT_HINT() {
        System.out.println(EXIT_HINT);
    }

    public static void printERROR_EMAIL_TAKEN() { System.out.println(ERROR_EMAIL_TAKEN); }

    public static void printSTUDENT_HEADER() {
        System.out.println(STUDENT_HEADER);
    }

    public static void printERROR_NO_STUDENTS() {
        System.out.println(ERROR_NO_STUDENTS);
    }

    public static void printADD_POINTS_HEADER() {
        System.out.println(ADD_POINTS_HEADER);
    }

    public static void printERROR_NO_STUDENT_FOR_ID(String id) {
        System.out.println(String.format(ERROR_NO_STUDENT_FOR_ID, id));
    }

    public static void printERROR_INCORRECT_POINTS_FORMAT() {
        System.out.println(ERROR_INCORRECT_POINTS_FORMAT);
    }

    public static void printPOINTS_UPDATED() {
        System.out.println(POINTS_UPDATED);
    }

    public static void printFIND_STUDENT_HEADER() {
        System.out.println(FIND_STUDENT_HEADER);
    }

    public static void printSTUDENT_INFORMATION(Student student) {
        System.out.println(
                String.format(
                        STUDENT_INFORMATION,
                        student.getID(),
                        student.getPoints()[0],
                        student.getPoints()[1],
                        student.getPoints()[2],
                        student.getPoints()[3]));
    }

    public static void printSTATISTICS_HEADER() {
        System.out.println(STATISTICS_HEADER);
    }
}
