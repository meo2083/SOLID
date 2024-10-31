package com.mycompany.entities;

import com.mycompany.ifc.ProjectIfc;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un proyecto que tiene varias tareas
 * @author edwin_rivas
 * @version 1.0
 */
public class Project implements ProjectIfc {

    private String name;
    private List<Task> tasks;

    public Project(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public String getName()
    {
        return this.name;
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public void removeTask(Task task) {
        tasks.remove(task);
    }

    @Override
    public void showTasks() {
        System.out.println("TAREAS EN PROYECTO '" + name + "':");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
