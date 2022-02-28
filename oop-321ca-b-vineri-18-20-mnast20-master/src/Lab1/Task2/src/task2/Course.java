package task2;

import java.util.ArrayList;

public class Course {
    String title;
    String description;
    Student [] students;
    public ArrayList<Student> filterYear(int year) {
        ArrayList<Student> list_students = new ArrayList<>();
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].year == year) {
                list_students.add(students[i]);
            }
        }
        return list_students;
    }
}
