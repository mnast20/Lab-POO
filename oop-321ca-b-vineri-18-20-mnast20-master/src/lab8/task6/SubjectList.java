package lab8.task6;

import lab8.task1.Student;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class SubjectList {
    private final LinkedList<String> subjectList1 = new LinkedList<>();
    private final LinkedList<String> subjectList2 = new LinkedList<>();
    private final LinkedList<String> subjectList3 = new LinkedList<>();
    private final LinkedList<String> subjectList4 = new LinkedList<>();
    private final LinkedList<String> subjectList5 = new LinkedList<>();

    public SubjectList() {

    }

    public void addSubjectsToLists() {
        subjectList1.add(Subject.PC.string);
        subjectList1.add(Subject.ALGEBRA.string);
        subjectList1.add(Subject.USO.string);

        subjectList2.add(Subject.POO.string);
        subjectList2.add(Subject.IOCLA.string);
        subjectList2.add(Subject.EEA.string);

        subjectList3.add(Subject.SO.string);
        subjectList3.add(Subject.AA.string);
        subjectList3.add(Subject.PHILOSOPHY.string);

        subjectList4.add(Subject.ELTH.string);
        subjectList4.add(Subject.SD.string);
        subjectList4.add(Subject.ANALYSIS.string);

        subjectList5.add(Subject.PHYSICS.string);
        subjectList5.add(Subject.TS.string);
        subjectList5.add(Subject.ENGLISH.string);
    }

    public void addListsToMap(Map<Student, LinkedList<String>> studentMap, ArrayList<Student> studentList) {
        addSubjectsToLists();
        studentMap.put(studentList.get(0), subjectList1);
        studentMap.put(studentList.get(1), subjectList2);
        studentMap.put(studentList.get(2), subjectList3);
        studentMap.put(studentList.get(3), subjectList4);
        studentMap.put(studentList.get(4), subjectList5);
    }
}
