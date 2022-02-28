package lab5.task1;

import java.util.concurrent.ThreadLocalRandom;

public class RandomOutTask implements Task {
    int random;
    public RandomOutTask() {
        random = ThreadLocalRandom.current().nextInt();
    }
    public void execute() {
        System.out.println("Random number is " + random);
    }
}
