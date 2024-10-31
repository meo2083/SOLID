package com.mycompany.ifc;
import com.mycompany.entities.Task;

/**
 * Interfaz para las operaciones de los proyectos
 * @author edwin_rivas
 * @version 1.0
 */
public interface ProjectIfc {
    void addTask(Task task);
    void removeTask(Task task);
    void showTasks();
}
