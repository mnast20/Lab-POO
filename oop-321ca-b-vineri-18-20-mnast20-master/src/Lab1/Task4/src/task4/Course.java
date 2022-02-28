package task4;

import java.util.ArrayList;

public class Course {
    private String title;
    private String description;
    private Student [] students;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Student[] getStudents() {
        return students;
    }

    public ArrayList<Student> filterYear(int year) {
        ArrayList<Student> list_students = new ArrayList<>();
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].getYear() == year) {
                list_students.add(students[i]);
            }
        }
        return list_students;
    }
}