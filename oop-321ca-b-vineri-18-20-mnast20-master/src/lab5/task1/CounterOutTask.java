package lab5.task1;

public class CounterOutTask implements Task {
    public static int count;
    public void execute() {
        count++;
        System.out.println("Global counter is " + count);
    }
}
