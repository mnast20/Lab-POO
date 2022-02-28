package lab4.people;

import lab4.database.Database;

import java.util.*;
import java.util.stream.Collectors;

public class Student {
    private String firstName;
    private String lastName;
    private Map<String, Integer> subjects;

    public Student(String firstName, String lastName, Map<String, Integer> subjects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjects = subjects;
    }

    public Student(Student student) {
        this.firstName = new String(student.firstName);
        this.lastName = new String(student.lastName);
        this.subjects = new HashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : student.subjects.entrySet()) {
            this.subjects.put(entry.getKey(), entry.getValue());
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<String, Integer> getSubjects() {
        return subjects;
    }

    public void setSubjects(HashMap<String, Integer> subjects) {
        this.subjects = subjects;
    }

    public double averageGrade() {
        double average = 0;
        for (Map.Entry<String, Integer> entry: subjects.entrySet()) {
            average += entry.getValue();
        }
        average /= subjects.size();
        return average;
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> allTeachers = new ArrayList<>();
        var teachers = Database.getDatabase().findAllTeachers();
        for (var teacher: teachers) {
            allTeachers.add(new Teacher(teacher));
        }
        List<Teacher> immutableAllTeachers = Collections.unmodifiableList(allTeachers);
        return immutableAllTeachers;
    }

    public int getGradeForSubject(String subject) {
        return this.subjects.get(subject);
    }

    @Override
    public String toString() {
        return "Student: " + firstName + " " + lastName + "\n"
                + "Subjects: " + subjects + "\n";
    }
    public List<Teacher> getTeachersBySubject(String subject) {
        List<Teacher> subjectTeachers = new ArrayList<>();
        var teachers = Database.getDatabase().findTeachersBySubject(subject);
        for (var teacher: teachers) {
            subjectTeachers.add(new Teacher(teacher));
        }
        List<Teacher> immutableSubjectTeachers = Collections.unmodifiableList(subjectTeachers);
        return immutableSubjectTeachers;
    }

    public List<Student> getAllStudents() {
        List<Student> allStudents = new ArrayList<>();
        var students = Database.getDatabase().findAllStudents();
        for (var student: students) {
            allStudents.add(new Student(student));
        }
        List<Student> immutableAllStudents = Collections.unmodifiableList(allStudents);
        return immutableAllStudents;

    }

    public List<Student> getStudentsBySubject(String subject) {
        List<Student> subjectStudents = new ArrayList<>();
        var students = Database.getDatabase().getStudentsBySubject(subject);
        for (var student: students) {
            subjectStudents.add(new Student(student));
        }
        List<Student> immutableSubjectStudents = Collections.unmodifiableList(subjectStudents);
        return immutableSubjectStudents;
    }

    public List<Student> getStudentsByAverageGrade() {
        List<Student> studentsByAvgGrd = new ArrayList<>();
        var students = Database.getDatabase().getStudentsByAverageGrade();
        for (var student: students) {
            studentsByAvgGrd.add(new Student(student));
        }
        List<Student> immutableStudentsByAvgGrd = Collections.unmodifiableList(studentsByAvgGrd);
        return immutableStudentsByAvgGrd;
    }

    public List<Student> getStudentsByGradeForSubject(String subject) {
        List<Student> studentsByGrd = new ArrayList<>();
        var students = Database.getDatabase().getStudentsByGradeForSubject(subject);
        for (var student: students) {
            studentsByGrd.add(new Student(student));
        }
        List<Student> immutableStudentsByGrd = Collections.unmodifiableList(studentsByGrd);
        return immutableStudentsByGrd;
    }
}