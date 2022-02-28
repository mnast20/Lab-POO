package lab4;

import lab4.database.Database;
import lab4.database.Helpers;

import static lab4.database.Subjects.*;

public class  Test {
    public static void main(String[] args) {
        // adding people to data base
        Helpers.addTeachers();
        Helpers.addStudents();

        // tests
        var testStudent = Database.getDatabase().findAllStudents().get(0);
        // Answer should be: Florin Mihalache
        var testTeacher = Database.getDatabase().findAllTeachers().get(0);
        // Answer should be: Alex Olteanu

        System.out.println("Testing teacher functionalities");
        System.out.println(testTeacher.getAllTeachers());

        System.out.println(testTeacher.getTeachersBySubject(PROGRAMMING_PARADIGMS));
        // Answer should be: Mihnea Muraru, Matei Popovici

        System.out.println(testTeacher.getTeachersBySubject(DATA_STRUCTURES));
        // Answer should be: Alex Olteanu, Irina Mocanu

        System.out.println(testTeacher.getAllStudents());
        // testing mutability for teachers

        testTeacher.getAllStudents().get(0).setFirstName("Malone");
        // changes Florin Mihalache in Malone Mihalache ?

        System.out.println(testTeacher.getAllStudents());

        System.out.println(testTeacher.getStudentsBySubject(PROGRAMMING_PARADIGMS));
        // Answer should be: Malone Mihalache, Andrei Mihu, George Mocanu

        System.out.println(testTeacher.getStudentsByAverageGrade());
        // Answer should be: Sebastian Oprea, Andrei Mihu, Constantin Raducanu, Malone Mihalache, George Mocanu

        System.out.println(testTeacher.getStudentsByGradeForSubject(PROGRAMMING_PARADIGMS));
        // Answer should be: Andrei Mihu, Malone Mihalache, George Mocanu

        System.out.println(testTeacher.getStudentsByGradeForSubject(COMPUTERS_PROGRAMMING));
        // Students in computer programming: George Mocanu, Constantin Raducanu, Sebastian Oprea
        // Answer should be: Sebastian Oprea, George Mocanu, Constantin Raducanu

        System.out.println(testTeacher.getStudentsByGradeForSubject(ASSEMBLY_LANGUAGE_PROGRAMMING));
        // Students in Assembly Language Programming: George Mocanu, Constantin Raducanu, Sebastian Oprea
        // Answer should be: Constantin Raducanu, Sebastian Oprea, George Mocanu

        // for student
        System.out.println("Testing student functionalities");
        System.out.println(testStudent.getAllTeachers());

        System.out.println(testStudent.getTeachersBySubject(PROGRAMMING_PARADIGMS));
        // Answer should be: Mihnea Muraru, Matei Popovici

        System.out.println(testStudent.getTeachersBySubject(DATA_STRUCTURES));
        // Answer should be: Alex Olteanu, Irina Mocanu

        System.out.println(testStudent.getAllStudents());
        // testing immutability for students

        testStudent.getAllStudents().get(0).setFirstName("Ginel");
        // uncomment this, it should throw an error if getAllStudents() from Student is completely immutable
        // testStudent.getAllStudents().add(new Student(testStudent));
        // the data remains the same, without any updates from testStudent (no student named Ginel)
        System.out.println(testStudent.getAllStudents());

        System.out.println(testStudent.getStudentsBySubject(LOCAL_AREA_NETWORKS));
        //  Answer should be: Andrei Mihu, George Mocanu, Constantin Raducanu, Sebastian Oprea

        System.out.println(testStudent.getStudentsByAverageGrade());
        // Answer should be: Sebastian Oprea, Andrei Mihu, Constantin Raducanu, Malone Mihalache, George Mocanu

        System.out.println(testStudent.getStudentsByGradeForSubject(PROGRAMMING_PARADIGMS));
        // Students in Programming paradigms: Malone Mihalache, Andrei Mihu, George Mocanu
        // Answer should be: Andrei Mihu, Malone Mihalache, George Mocanu

        System.out.println(testStudent.getStudentsByGradeForSubject(OPERATING_SYSTEMS));
        // Students in Operating Systems: Andrei Mihu, George Mocanu, Constantin Raducanu, Sebastian Oprea
        // Answer should be: Andrei Mihu, Constantin Raducanu, Sebastian Oprea, George Mocanu

        System.out.println(testStudent.getStudentsByGradeForSubject(COMMUNICATION_PROTOCOLS));
        // Students in Communication Protocols: Andrei Mihu, George Mocanu
        // Answer should be: Andrei Mihu, George Mocanu

        // checking number of instances
        System.out.println(Database.getNumberOfInstances());

    }
}