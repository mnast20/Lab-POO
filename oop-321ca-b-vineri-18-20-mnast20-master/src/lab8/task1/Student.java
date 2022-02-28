package lab8.task1;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private final String name;
    private final String surname;
    private final long id;
    private final double averageGrade;

    public Student(String name, String surname, long id, double averageGrade) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.averageGrade = averageGrade;
    }

    public long getId() {
        return id;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public int compareTo(Student otherStudent) {
        int result;
        result = Double.compare(this.averageGrade,otherStudent.averageGrade);
        if (result != 0) {
            return result;
        }
        result = this.name.compareTo(otherStudent.name);
        if (result != 0) {
            return result;
        }
        return this.surname.compareTo(otherStudent.surname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return id == student.id && Double.compare(student.averageGrade, averageGrade) == 0 && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, id, averageGrade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", averageGrade=" + averageGrade +
                '}';
    }
}
