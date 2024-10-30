package com.mycompany.ifc;
import com.mycompany.entities.User;

public interface TaskIfc {
    void assignUser(User user);
    void complete();
    String getStatus();
}
