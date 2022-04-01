package tracker.Controller;

import tracker.Model.Student;
import tracker.View.TrackerUI;

import java.util.Scanner;
import java.util.UUID;

public class AddStudentController {
    private static int counter;
    private static Scanner scanner = new Scanner(System.in);

    public static void run() {
        TrackerUI.printADD_STUDENT_MESSAGE();
        counter = 0;
        boolean exitAddStudent = false;

        while(!exitAddStudent) {
            var input = scanner.nextLine();

            switch (input) {
                case "back":
                    exitAddStudent = true;
                    TrackerUI.printStudentsAdded(counter);
                    counter = 0;
                    break;
                default:
                    if (StudentValidationController.validateStudentData(input)) {
                        AddStudentController.parseInputToStudent(input);
                        TrackerUI.printSTUDENT_ADDED();
                        counter++;
                    }
                    break;
            }
        }
    }

    public static UUID generateUniqueID() {
        var temp = UUID.randomUUID();
        while (StudentController.uuidToEmailMap.containsKey(temp)) {
            temp = UUID.randomUUID();
        }
        return temp;
    }

    public static String processStudentSurname(String input) {
        var splitString = input.split("\\s+");
        StringBuilder lastName = new StringBuilder();

        if (splitString.length > 3) {
            for (int i = 1; i < splitString.length - 2; i++) {
                if (StudentValidationController.validLastName(splitString[i])) {
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
            if (!StudentValidationController.validLastName(splitString[1])) {
                return "";
            }
            lastName.append(splitString[1]);
        } else {
            return "";
        }
        return lastName.toString();
    }

    public static Student parseInputToStudent(String input) {
        var splitString = input.split("\\s+");
        var email = splitString[splitString.length - 1];
        var firstName = splitString[0];
        var surname = processStudentSurname(input);

        var student = new Student(email, firstName, surname, generateUniqueID());
        StudentController.studentMap.put(email, student);
        StudentController.uuidToEmailMap.put(student.getID(), student.getEmail());

        return student;
    }
}
