package com.mycompany.ifc;

import com.mycompany.entities.Task;
import com.mycompany.entities.User;

/**
 * Interfaz para las operaciones del gestor de tareas
 * @author edwin_rivas
 * @version 1.0
 */
public interface TaskManagerIfc {
    void createTask(String description);
    void assignTaskToUser(Task task, User user);
    void completeTask(Task task);
    void listTasks();
}
