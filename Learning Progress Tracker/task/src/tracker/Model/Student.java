package tracker.Model;

import tracker.Controller.StudentValidationController;
import tracker.View.TrackerUI;

import java.util.*;

public class Student {
    private HashMap<Course, Integer> courses = new HashMap<>();
    private int[] points = new int[4]; //0->Java, 1->DSA, 2->Databases, 3->Spring.
    private UUID ID;
    private String email;
    private String firstName;
    private String lastName;

    public Student(String email, String firstName, String lastName, UUID ID) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
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

    public int[] getPoints() {
        return points;
    }

    public void setPoints(int[] points) {
        this.points = points;
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
}
