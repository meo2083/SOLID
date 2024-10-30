package com.mycompany.manager;

import com.mycompany.entities.Task;
import com.mycompany.entities.User;
import com.mycompany.ifc.TaskManagerIfc;

import java.util.ArrayList;
import java.util.List;

public class TaskManager implements TaskManagerIfc {

    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    @Override
    public void createTask(String description) {
        Task newTask = new Task(description);
        tasks.add(newTask);
        System.out.println("Task created: " + newTask);
    }

    @Override
    public void assignTaskToUser(Task task, User user) {
        task.assignUser(user);
        System.out.println("Task assigned to: " + user.getName());
    }

    @Override
    public void completeTask(Task task) {
        task.complete();
        System.out.println("Task completed: " + task);
    }

    @Override
    public void listTasks() {
        System.out.println("All tasks:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
