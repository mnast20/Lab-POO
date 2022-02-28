package lab5.task2;

import java.util.ArrayList;
import lab5.task1.*;

public class Queue implements Container {
    ArrayList<Task> tasks = new ArrayList<>();

    public Queue() {}

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public Task pop() {
        if (isEmpty()) {
            return null;
        }
        Task removedTask = tasks.get(0);
        tasks.remove(0);
        return removedTask;
    }

    public void push(Task task) {
        tasks.add(task);
    }

    public int size() {
        return tasks.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void transferFrom(Container container) {
        while (!container.isEmpty()) {
            Task task = container.pop();
            push(task);
        }
    }
}
