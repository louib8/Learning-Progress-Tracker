package tracker.Controller;

import tracker.Model.Student;
import tracker.View.TrackerUI;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StudentController {
    public static Map<String, Student> studentMap = new HashMap<>();
    public static Map<UUID, String> uuidToEmailMap = new HashMap<>();

    public static void printStudent(String id) {
        var email = uuidToEmailMap.get(UUID.fromString(id));
        var student = studentMap.getOrDefault(email, null);

        if (student == null) {
            TrackerUI.printERROR_NO_STUDENT_FOR_ID(id);
            return;
        }
        TrackerUI.printSTUDENT_INFORMATION(student);
    }

    public static boolean findStudent(String id) {
        return uuidToEmailMap.containsKey(UUID.fromString(id));
    }

}
