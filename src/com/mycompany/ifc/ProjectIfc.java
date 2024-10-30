package com.mycompany.ifc;
import com.mycompany.entities.Task;

public interface ProjectIfc {
    void addTask(Task task);
    void removeTask(Task task);
    void showTasks();
}
