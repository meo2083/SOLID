package com.mycompany.ifc;
import com.mycompany.entities.User;

/**
 * Interfaz para las operaciones de las tareas
 * @author edwin_rivas
 * @version 1.0
 */
public interface TaskIfc {
    void assignUser(User user);
    void complete();
    String getStatus();
}
