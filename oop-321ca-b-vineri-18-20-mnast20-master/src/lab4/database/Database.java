package lab4.database;

import lab4.people.Student;
import lab4.people.Teacher;
import lab4.sort.*;

import javax.security.auth.Subject;
import java.util.*;

public class Database {
    private final List<Student> students = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();
    static int noOfInstances = 0;

    private final static Database instance = new Database();

    private Database() {}

    public static Database getDatabase() {
        noOfInstances++;
        return instance;
    }

    public static int getNumberOfInstances() {
        return noOfInstances;
    }

    public void addTeachers(List<Teacher> teachers) {
        this.teachers.addAll(teachers);
    }

    public void addStudents(List<Student> students) {
        this.students.addAll(students);
    }

    public List<Teacher> findTeachersBySubject(String subject) {
        List<Teacher> teachersBySubject = new ArrayList<>();
        for (Teacher teacher : teachers) {
            List<String> s = teacher.getSubjects();
            for (String value : s) {
                if (subject.equals(value)) {
                    teachersBySubject.add(new Teacher(teacher));
                }
            }
        }
        return teachersBySubject;
    }

    public List<Student> findAllStudents() {
        return students;
    }

    public List<Teacher> findAllTeachers() {
        return teachers;
    }

    public List<Student> getStudentsBySubject(String subject) {
        List<Student> studentsBySubject = new ArrayList<>();
        for (Student student : students) {
            for (Map.Entry<String, Integer> entry : student.getSubjects().entrySet()) {
                if (subject.equals(entry.getKey())) {
                    studentsBySubject.add(new Student(student));
                }
            }
        }
        return studentsBySubject;
    }

    public List<Student> getStudentsByAverageGrade() {
        List<Student> studentsByAvg = new ArrayList<>();
        var students = this.students;
        for (var student: students) {
            studentsByAvg.add(new Student(student));
        }
        Collections.sort(studentsByAvg, new SortByAvg());
        return studentsByAvg;
    }

    public List<Student> getStudentsByGradeForSubject(String subject) {
        List<Student> studentsByGradeOSubject = new ArrayList<>();
        List<Student> studentsBySubject = this.getStudentsBySubject(subject);
        for (Student student : studentsBySubject) {
            for (Map.Entry<String, Integer> entry : student.getSubjects().entrySet()) {
                if (subject.equals(entry.getKey())) {
                    studentsByGradeOSubject.add(new Student(student));
                }
            }
        }
        studentsByGradeOSubject.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getGradeForSubject(subject) - o2.getGradeForSubject(subject);
            }
        });
        return studentsByGradeOSubject;
    }
}
