package lab5.task2;

import lab5.task1.Task;

import java.util.ArrayList;

public class Stack implements Container{
    ArrayList<Task> tasks = new ArrayList<>();
    
    public Stack() {}

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public Task pop() {
        if (isEmpty()) {
            return null;
        }
        int size = tasks.size();
        Task removedTask = tasks.get(size - 1);
        tasks.remove(size - 1);
        return removedTask;
    }

    public void push(Task task) {
        tasks.add(task);
    }

    public int size() {
        return tasks.size();
    }

    public boolean isEmpty() {
        if (tasks.size() != 0) {
            return false;
        }
        return true;
    }

    public void transferFrom(Container container) {
        while (!container.isEmpty()) {
            Task task = container.pop();
            push(task);
        }
    }
}
