package com.mycompany.entities;

import com.mycompany.ifc.TaskIfc;

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
        return completed ? "Completed" : "In Progress";
    }

    @Override
    public String toString() {
        return "Task: " + description + ", Assigned to: " + (assignedUser != null ? assignedUser.getName() : "None") + ", Status: " + getStatus();
    }

}
