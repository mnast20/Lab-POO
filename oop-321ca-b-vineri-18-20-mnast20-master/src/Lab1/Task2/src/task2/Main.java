package task2;

public class Main {
    public static void main(String[] args) {
        Course course = new Course();
        course.students = new Student[4];
        course.title = "POO";
        course.description = "Programare orientata pe obiecte in Java";

        course.students[0] = new Student();
        course.students[0].name = "Farcas Andrei";
        course.students[0].year = 1;

        course.students[1] = new Student();
        course.students[1].name = "Visan Ruxandra";
        course.students[1].year = 2;

        course.students[2] = new Student();
        course.students[2].name = "Dumitru Matei";
        course.students[2].year = 3;

        course.students[3] = new Student();
        course.students[3].name = "Petrache Ioana";
        course.students[3].year = 2;

        System.out.println(course.filterYear(2));
    }
}
