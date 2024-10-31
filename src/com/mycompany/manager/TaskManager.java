package com.mycompany.manager;

import com.mycompany.entities.Task;
import com.mycompany.entities.User;
import com.mycompany.ifc.TaskManagerIfc;

import java.util.ArrayList;
import java.util.List;

/**
 * Maneja la lógica de gestión de tareas
 * @author edwin_rivas
 * @version 1.0
 */
public class TaskManager implements TaskManagerIfc {

    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public List<Task> getTask()
    {
        return this.tasks;
    }

    @Override
    public void createTask(String description) {
        Task newTask = new Task(description);
        tasks.add(newTask);
        System.out.println("TAREA CREADA: " + newTask);
    }

    @Override
    public void assignTaskToUser(Task task, User user) {
        task.assignUser(user);
        System.out.println("TAREA ASIGNADA A: " + user.getName());
    }

    @Override
    public void completeTask(Task task) {
        task.complete();
        System.out.println("TAREA COMPLETADA: " + task);
    }

    @Override
    public void listTasks() {
        System.out.println("TODAS LAS TAREAS:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
