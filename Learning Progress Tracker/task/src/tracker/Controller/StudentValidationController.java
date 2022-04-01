package tracker.Controller;

import tracker.View.TrackerUI;

public class StudentValidationController {
    private static final String EMAIL_REGEX = "[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?";
    private static final String NAME_REGEX = "^([a-zA-Z]+[-']?[a-zA-Z]+)";
    private static final String LAST_NAME_REGEX = "^[A-Za-z]+((\\\\s)?(['-]?([A-Za-z])+))+?$";


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
        return !StudentController.studentMap.containsKey(email) ? true : false;
    }

    public static boolean validateStudentData(String input) {
        var splitString = input.split("\\s+");
        if (splitString.length > 3) {
            for (int i = 1; i < splitString.length - 1; i++) {
                if (!StudentValidationController.validLastName(splitString[i])) {
                    TrackerUI.printERROR_LAST_NAME();
                    return false;
                }
            }
        } else if (splitString.length == 3) {
            if (!StudentValidationController.validLastName(splitString[1])) {
                TrackerUI.printERROR_LAST_NAME();
                return false;
            }
        } else {
            TrackerUI.printERROR_INVALID_CREDENTIALS();
            return false;
        }

        var email = splitString[splitString.length - 1];
        var firstName = splitString[0];

        if (!StudentValidationController.validName(firstName)) {
            TrackerUI.printERROR_FIRST_NAME();
            return false;
        }

        if (!StudentValidationController.validEmail(email)) {
            TrackerUI.printERROR_EMAIL();
            return false;
        }

        if (!StudentValidationController.emailAvailable(email)) {
            TrackerUI.printERROR_EMAIL_TAKEN();
            return false;
        }
        return true;
    }
}
