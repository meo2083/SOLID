package com.mycompany.ifc;

import com.mycompany.entities.Task;
import com.mycompany.entities.User;

public interface TaskManagerIfc {
    void createTask(String description);
    void assignTaskToUser(Task task, User user);
    void completeTask(Task task);
    void listTasks();
}
