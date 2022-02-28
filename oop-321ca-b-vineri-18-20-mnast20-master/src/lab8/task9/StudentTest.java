package lab8.task9;

import lab8.task1.Student;
import org.junit.jupiter.api.*;

public class StudentTest {
    private Student student;

    @BeforeEach
    public void setUp() {
        this.student = new Student("Mihai", "Radu", 1221, 8.7);
    }

    @AfterEach
    public void clean() {
        this.student = null;
    }

    @Test
    @DisplayName("Equals test")
    public void testEquals() {
        // Assertions.assertEquals(student, );
        Student otherStudent1 = new Student("Mihai", "Radu", 1221, 8.7);
        Student otherStudent2 = new Student("Mihai", "Ioan", 1270, 8.7);
        Assertions.assertTrue(student.equals(student));
        Assertions.assertTrue(student.equals(otherStudent1));
        Assertions.assertFalse(student.equals(otherStudent2));
    }

    @Test
    @DisplayName("CompareTo test")
    public void testCompareTo() {
        Student otherStudent1 = new Student("Mihai", "Radu", 1221, 8.7);
        Student otherStudent2 = new Student("Mihai", "Ioan", 1270, 8.7);
        Student otherStudent3 = new Student("Berlinschi", "Stefan", 1234, 9.5);

        Assertions.assertEquals(0, student.compareTo(otherStudent1));
        Assertions.assertEquals(9, student.compareTo(otherStudent2));
        Assertions.assertEquals(-1, student.compareTo(otherStudent3));
    }

    @Test
    @DisplayName("toString test")
    public void testToString() {
        Assertions.assertNotNull(student.toString());
    }
}
