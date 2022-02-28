package lab8;

import lab8.task1.Student;
import lab8.task6.SubjectList;
import lab8.task7.ParityHashSet;
import lab8.task7.ParityLinkedHashSet;
import lab8.task7.ParityTreeSet;

import java.util.*;

public class Main {
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void main(String[] args) {
        // Task 2
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Berlinschi", "Stefan", 1234, 9.5));
        studentList.add(new Student("Farcasanu", "Andrei", 1201, 9));
        studentList.add(new Student("Cucu", "Stefan", 1256, 9.5));
        studentList.add(new Student("Mihai", "Radu", 1221, 8.7));
        studentList.add(new Student("Mihai", "Ioan", 1270, 8.7));

        System.out.println("List before sorting:");
        System.out.println(studentList);
        System.out.println();

        System.out.println("List after sorting students based on average grade, name and surname in ascending order:");
        Collections.sort(studentList);
        System.out.println(studentList);
        System.out.println();

        // Task 3
        System.out.println("List after sorting students based on average grade in descending order:");
        studentList.sort((s1, s2) -> (-1) * Double.compare(s1.getAverageGrade(), s2.getAverageGrade()));
        System.out.println(studentList);
        System.out.println();

        // Task 4
        System.out.println("Priority queue sorting students based on id in ascending order:");
        PriorityQueue<Student> studentQueue = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Long.compare(s1.getId(), s2.getId());
            }
        });
        studentQueue.addAll(studentList);
        System.out.print("[");
        for (int i = 0; i < 5; i++) {
            if (i != 4) {
                System.out.print(studentQueue.poll() + " ,");
            } else {
                System.out.print(studentQueue.poll());
            }
        }
        System.out.println("]");
        System.out.println();

        // Task 6
        System.out.println("Map with students and subjects they study:");
        Map<Student, LinkedList<String>> studentMap = new HashMap<>();
        new SubjectList().addListsToMap(studentMap, studentList);

        for (Map.Entry<Student, LinkedList<String>> studentEntry: studentMap.entrySet()) {
            System.out.println("Student: " + studentEntry.getKey() + " Subjects: " + studentEntry.getValue());
        }
        System.out.println();

        // Task 7
        ParityLinkedHashSet parityLinkedHashSet = new ParityLinkedHashSet();
        ParityHashSet parityHashSet = new ParityHashSet();
        ParityTreeSet parityTreeSet = new ParityTreeSet();

        for (int i = 1; i <= 20; i++) {
            int nr = getRandomNumber(0, 20);
            parityLinkedHashSet.add(nr);
            parityHashSet.add(nr);
            parityTreeSet.add(nr);
        }

        Iterator<Integer> iterator1 = parityLinkedHashSet.iterator();
        Iterator<Integer> iterator2 = parityHashSet.iterator();
        Iterator<Integer> iterator3 = parityTreeSet.iterator();

        /**
         *  The Integers inside the Linked Hash Set aren't duplicates and aren't sorted, they keep
         *  the order in which they were added to the list.
         */
        System.out.println("Linked Hash Set result:");
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }
        System.out.println("\n");

        /**
         *  The Integers inside the Hash Set aren't duplicates and aren't always fully sorted in
         *  ascending order
         */
        System.out.println("Hash Set result:");
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + " ");
        }
        System.out.println("\n");

        /**
         *  The Integers inside the Tree Set aren't duplicates and are always sorted in ascending
         *  order
         */
        System.out.println("Tree Set result:");
        while (iterator3.hasNext()) {
            System.out.print(iterator3.next() + " ");
        }
        System.out.println("\n");
    }
}
