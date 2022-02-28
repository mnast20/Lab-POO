package lab4.sort;

import lab4.people.Student;

import java.util.Comparator;

public class SortByAvg implements Comparator<Student>
{
    public int compare(Student a, Student b)
    {
        if (a.averageGrade() - b.averageGrade() < 0) {
            return -1;
        } else if (a.averageGrade() - b.averageGrade() > 0) {
            return 1;
        }
        return 0;
    }
}