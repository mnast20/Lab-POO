package task4;

public class Main {
    public static void main(String[] args) {
        Course course = new Course();
        Student [] students = new Student[4];
        course.setTitle("POO");
        course.setDescription("Programare orientata pe obiecte in Java");

        students[0] = new Student();
        students[0].setName("Farcas Andrei");
        students[0].setYear(1);

        students[1] = new Student();
        students[1].setName("Visan Ruxandra");
        students[1].setYear(2);

        students[2] = new Student();
        students[2].setName("Dumitru Matei");
        students[2].setYear(3);

        students[3] = new Student();
        students[3].setName("Petrache Ioana");
        students[3].setYear(2);

        course.setStudents(students);

        System.out.println(course.filterYear(2));

        Equal evaluation = new Equal();
        evaluation.s1 = new Student();
        evaluation.s1.setName("Ana Dumitru");
        evaluation.s1.setYear(2);

        evaluation.s2 = new Student();
        evaluation.s2.setName("Ana Dumitru");
        evaluation.s2.setYear(2);

        evaluation.CheckEqual();
    }
}
