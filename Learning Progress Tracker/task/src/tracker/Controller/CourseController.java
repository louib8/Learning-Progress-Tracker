package tracker.Controller;

import tracker.Model.Student;
import tracker.View.TrackerUI;

import java.util.UUID;

public class CourseController {


    public static boolean processStudentProgress(String progressInput) {
        String[] splitInput = progressInput.split(" ");

        if (splitInput.length != 5) {
            TrackerUI.printERROR_INCORRECT_POINTS_FORMAT();
            return false;
        }

        for (int i = 0; i < splitInput.length; i++) {
            try {
                if (i == 0) {
                    try {
                        if (!StudentController.uuidToEmailMap.containsKey(UUID.fromString(splitInput[0]))) {
                            TrackerUI.printERROR_NO_STUDENT_FOR_ID(splitInput[0]);
                            return false;
                        }
                    } catch (Exception ex) {
                        TrackerUI.printERROR_NO_STUDENT_FOR_ID(splitInput[0]);
                        return false;
                    }
                } else if (Integer.parseInt(splitInput[i]) < 0) {
                    TrackerUI.printERROR_INCORRECT_POINTS_FORMAT();
                    return false;
                }
            } catch (Exception ex) {
                TrackerUI.printERROR_INCORRECT_POINTS_FORMAT();
                return false;
            }
        }

        String email = StudentController.uuidToEmailMap.get(UUID.fromString(splitInput[0]));
        Student student = StudentController.studentMap.get(email);

        var currPoints = student.getPoints();

        for (int i = 1; i < splitInput.length; i++) {
            try {
                currPoints[i - 1] += Integer.parseInt(splitInput[i]);
            } catch (Exception ex) {
                TrackerUI.printERROR_INCORRECT_POINTS_FORMAT();
                return false;
            }
        }

        student.setPoints(currPoints);
        return true;
    }
}
