package tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TrackerMenu {

    private Scanner scanner = new Scanner(System.in);
    private int counter = 0;

    TrackerMenu() {
        mainMenu();
    }

    private void mainMenu() {
        TrackerUI.printTITLE();
        boolean exit = false;
        while (!exit) {
            try {
                var input = scanner.nextLine();

                var modifiedInput = checkIfStringIsBlank(input);

                switch (modifiedInput) {
                    case "back":
                        TrackerUI.printEXIT_HINT();
                        break;
                    case "add students":
                        addStudentMenu();
                        break;
                    case "":
                        TrackerUI.printNO_INPUT();
                        break;
                    case "exit":
                        exit = true;
                        TrackerUI.printEXIT();
                        break;
                    case "list":
                        if (Student.studentMap.size() > 0) {
                            TrackerUI.printSTUDENT_HEADER();
                            for (var stud : Student.studentMap.values()) {
                                System.out.println(stud.getID());
                            }
                        } else {
                            TrackerUI.printERROR_NO_STUDENTS();
                        }
                        break;
                    default:
                        TrackerUI.printERROR_UNKNOWN_COMMAND();
                        break;
                }
            } catch (Exception ex) {
                //ignore for now.
            }
        }
    }

    private void addStudentMenu() {
        TrackerUI.printADD_STUDENT_MESSAGE();
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
                    if (Student.validateStudentData(input)) {
                        Student.studentMap.put(Student.parseInputToStudent(input).getEmail(), Student.parseInputToStudent(input));
                        TrackerUI.printSTUDENT_ADDED();
                        counter++;
                    }
                    break;
            }
        }
    }

    public static String checkIfStringIsBlank(String input) {
        if (input.isBlank()) {
            return "";
        }
        return input;
    }


}
