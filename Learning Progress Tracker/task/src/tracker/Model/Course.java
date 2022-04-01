package tracker.Model;

import tracker.Model.Student;

import java.util.HashMap;
import java.util.UUID;

public class Course {
    private String courseName;
    private int passMark;
    private HashMap<UUID, Integer> topStudents;
    private HashMap<UUID, Student> enrolledStudents;

}
