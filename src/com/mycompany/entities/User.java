package com.mycompany.entities;

import com.mycompany.ifc.UserIfc;

import java.util.List;

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
