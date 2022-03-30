package tracker;

import java.util.*;

public class Student {
    public static Map<String, Student> studentMap = new HashMap<>();
    public static Map<UUID, String> uuidToEmailMap = new HashMap<>();
    private UUID ID;
    private String email;
    private String firstName;
    private String lastName;
    private static final String EMAIL_REGEX = "[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?";
    private static final String NAME_REGEX = "^([a-zA-Z]+[-']?[a-zA-Z]+)";
    private static final String LAST_NAME_REGEX = "^[A-Za-z]+((\\\\s)?(['-]?([A-Za-z])+))+?$";

    public Student(String email, String firstName, String lastName, UUID ID) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
    }

    public static UUID generateUniqueID() {
        var temp = UUID.randomUUID();
        while (uuidToEmailMap.containsKey(temp)) {
            temp = UUID.randomUUID();
        }
        return temp;
    }

    public static String processStudentSurname(String input) {
        var splitString = input.split("\\s+");
        StringBuilder lastName = new StringBuilder();

        if (splitString.length > 3) {
            for (int i = 1; i < splitString.length - 2; i++) {
                if (validLastName(splitString[i])) {
                    // Add a space between names, except don't add a space to last one.
                    if (i == splitString.length - 2) {
                        lastName.append(splitString[i]);
                    } else {
                        lastName.append(splitString[i] + " ");
                    }
                } else {
                    return "";
                }
            }
        } else if (splitString.length == 3) {
            if (!validLastName(splitString[1])) {
                return "";
            }
            lastName.append(splitString[1]);
        } else {
            return "";
        }
        return lastName.toString();
    }

    public static boolean validateStudentData(String input) {
        var splitString = input.split("\\s+");
        if (splitString.length > 3) {
            for (int i = 1; i < splitString.length - 1; i++) {
                if (!validLastName(splitString[i])) {
                    TrackerUI.printERROR_LAST_NAME();
                    return false;
                }
            }
        } else if (splitString.length == 3) {
            if (!validLastName(splitString[1])) {
                TrackerUI.printERROR_LAST_NAME();
                return false;
            }
        } else {
            TrackerUI.printERROR_INVALID_CREDENTIALS();
            return false;
        }

        var email = splitString[splitString.length - 1];
        var firstName = splitString[0];

        if (!validName(firstName)) {
            TrackerUI.printERROR_FIRST_NAME();
            return false;
        }

        if (!validEmail(email)) {
            TrackerUI.printERROR_EMAIL();
            return false;
        }

        if (!emailAvailable(email)) {
            TrackerUI.printERROR_EMAIL_TAKEN();
            return false;
        }
        return true;
    }

    public static Student parseInputToStudent(String input) {
        var splitString = input.split("\\s+");
        var email = splitString[splitString.length - 1];
        var firstName = splitString[0];
        var surname = processStudentSurname(input);

        var student = new Student(email, firstName, surname, generateUniqueID());
        Student.studentMap.put(email, student);
        Student.uuidToEmailMap.put(student.getID(), student.getEmail());

        return student;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public UUID getID() {
        return ID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static boolean validName(String name) {
        return name.matches(NAME_REGEX) ? true : false;
    }

    public static boolean validLastName(String name) {
        return name.matches(LAST_NAME_REGEX) ? true : false;
    }

    public static boolean validEmail(String email) {
        return email.matches(EMAIL_REGEX) ? true : false;
    }

    public static boolean emailAvailable(String email) {
        return !studentMap.containsKey(email) ? true : false;
    }
}
