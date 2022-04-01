package tracker.Controller;

import tracker.Model.Student;
import tracker.View.TrackerUI;

import java.util.*;

public class MainMenuController {

    private Scanner scanner = new Scanner(System.in);

    MainMenuController() {
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
                        AddStudentController.run();
                        break;
                    case "":
                        TrackerUI.printNO_INPUT();
                        break;
                    case "exit":
                        exit = true;
                        TrackerUI.printEXIT();
                        break;
                    case "list":
                        if (StudentController.studentMap.size() > 0) {
                            TrackerUI.printSTUDENT_HEADER();
                            for (var stud : StudentController.studentMap.values()) {
                                System.out.println(stud.getID());
                            }
                        } else {
                            TrackerUI.printERROR_NO_STUDENTS();
                        }
                        break;
                    case "add points":
                        TrackerUI.printADD_POINTS_HEADER();
                        boolean addPointsExit = false;
                        while (!addPointsExit) {
                            var progressInput = scanner.nextLine();
                            if (progressInput.equals("back")) {
                                addPointsExit = true;
                                continue;
                            }
                            if (CourseController.processStudentProgress(progressInput)) {
                                TrackerUI.printPOINTS_UPDATED();
                            }
                        }
                        break;
                    case "find":
                        TrackerUI.printFIND_STUDENT_HEADER();
                        boolean findStudentExit = false;
                        while (!findStudentExit) {
                            var findInput = scanner.nextLine();

                            if (findInput.equals("back")){
                                findStudentExit = true;
                                continue;
                            }

                            if (StudentController.findStudent(findInput)) {
                                StudentController.printStudent(findInput);
                            } else {
                                TrackerUI.printERROR_NO_STUDENT_FOR_ID(findInput);
                            }
                        }
                        break;
                    case "statistics":
                        StatisticsController.run();
                        break;
                    default:
                        TrackerUI.printERROR_UNKNOWN_COMMAND();
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
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
