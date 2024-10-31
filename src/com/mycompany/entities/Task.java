package com.mycompany.entities;

import com.mycompany.ifc.TaskIfc;

/**
 * Representa una tarea
 * @author edwin_rivas
 * @version 1.0
 */
public class Task implements TaskIfc {

    private String description;
    private User assignedUser;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription()
    {
        return this.description;
    }

    @Override
    public void assignUser(User user) {
        this.assignedUser = user;
    }

    @Override
    public void complete() {
        this.completed = true;
    }

    @Override
    public String getStatus() {
        return completed ? "COMPLETADA" : "EN PROGRESO";
    }

    @Override
    public String toString() {
        return "TAREA: " + description + ", ASIGNADA A: " + (assignedUser != null ? assignedUser.getName() : "SIN USUARIO") + ", ESTADO: " + getStatus();
    }

}
