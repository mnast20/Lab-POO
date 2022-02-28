package task3;

public class Main {
    public static void main(String[] args) {
        Equal evaluation = new Equal();
        evaluation.s1 = new Student();
        evaluation.s1.name = "Ana Dumitru";
        evaluation.s1.year = 2;

        evaluation.s2 = new Student();
        evaluation.s2.name = "Ana Dumitru";
        evaluation.s2.year = 2;

        evaluation.CheckEqual();
    }
}
