package tracker;

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
}
