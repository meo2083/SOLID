package com.mycompany.entities;

import com.mycompany.ifc.UserIfc;

import java.util.List;

/**
 * Representa un usuario que puede trabajar en tareas
 * @author edwin_rivas
 * @version 1.0
 */
public class User implements UserIfc {

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
