package com.mycompany.gui;
import java.util.*;

import com.mycompany.entities.Project;
import com.mycompany.entities.Task;
import com.mycompany.entities.User;
import com.mycompany.manager.TaskManager;

/**
 * Interfaz de consola para gestionar tareas y proyectos
 * @author edwin_rivas
 * @version 1.0
 */
public class ConsoleInterface {


    public static void start()
    {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        List<User> userList = new ArrayList<>();
        List<Project> projectList = new ArrayList<>();
        int opcion;
        while(true)
        {
            System.out.println("-------------MENU DE OPCIONES------------");
            System.out.println("1.  AGREGAR USUARIO");
            System.out.println("2.  CREAR TAREA");
            System.out.println("3.  ASIGNAR TAREA A USUARIO");
            System.out.println("4.  COMPLETAR TAREA");
            System.out.println("5.  VER TAREAS");
            System.out.println("6.  CREAR PROYECTO");
            System.out.println("7.  ASIGNAR TAREA A PROYECTO");
            System.out.println("8.  VER TAREAS DE PROYECTO");
            System.out.println("0.  Salir");
            try {
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Nombre de usuario: ");
                        String userName = scanner.next();
                        scanner.nextLine();
                        User user = new User(userName);
                        userList.add(user);
                        break;
                    case 2:
                        System.out.println("Nombre de tarea: ");
                        String taskName = scanner.next();
                        scanner.nextLine();
                        taskManager.createTask(taskName);
                        break;
                    case 3:
                        System.out.println("Nombre de tarea: ");
                        String taskNameForUser = scanner.next();
                        scanner.nextLine();
                        Task taskToAssign = findTask(taskNameForUser, taskManager.getTask());
                        System.out.println("Nombre de usuario: ");
                        String userForTask = scanner.next();
                        scanner.nextLine();
                        User userToAssign = findUser(userForTask, userList);
                        if (taskToAssign != null && userToAssign != null) {
                            taskManager.assignTaskToUser(taskToAssign, userToAssign);
                        } else {
                            if (taskToAssign == null) {
                                System.out.println("TAREA " + taskNameForUser + " NO EXISTE");
                            }
                            if (userToAssign == null) {
                                System.out.println("USUARIO " + userForTask + " NO EXISTE");
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Nombre de tarea: ");
                        String taskNameToComplete = scanner.next();
                        scanner.nextLine();
                        Task taskToComplete = findTask(taskNameToComplete, taskManager.getTask());
                        if (taskToComplete != null) {
                            taskManager.completeTask(taskToComplete);
                        } else {
                            System.out.println("NO EXISTE TAREA: " + taskNameToComplete);
                        }
                        break;
                    case 5:
                        taskManager.listTasks();
                        break;
                    case 6:
                        System.out.println("Ingrese nombre de proyecto: ");
                        String projectName = scanner.next();
                        scanner.nextLine();
                        Project project = new Project(projectName);
                        projectList.add(project);
                        break;
                    case 7:
                        System.out.println("Ingrese nombre del proyecto: ");
                        String projectToAssign = scanner.next();
                        scanner.nextLine();
                        System.out.println("Ingrese nombre de tarea: ");
                        String taskToAssignToProject = scanner.next();
                        scanner.nextLine();
                        Project projectFound = findProject(projectToAssign, projectList);
                        Task taskForProject = findTask(taskToAssignToProject, taskManager.getTask());
                        if (projectFound != null && taskToAssignToProject != null) {
                            projectFound.addTask(taskForProject);
                        } else {
                            if (projectFound == null) {
                                System.out.println("NO EXISTE PROYECTO " + projectFound);
                            }
                            if (taskForProject == null) {
                                System.out.println("NO EXISTE TAREA " + taskForProject);
                            }
                        }
                        break;
                    case 8:
                        System.out.println("Ingrese nombre de proyecto: ");
                        String projectToShow = scanner.next();
                        scanner.nextLine();
                        Project projecti = findProject(projectToShow, projectList);
                        if (projecti != null) {
                            projecti.showTasks();
                        } else {
                            System.out.println("NO EXISTE PROYECTO: " + projectToShow);
                        }
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Opción no válida");
                        break;

                }
            }catch(InputMismatchException e)
            {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.nextLine(); // Limpiar el buffer
                continue; // Volver al inicio del bucle
            }catch (NoSuchElementException e) {
                System.out.println("No hay más entradas disponibles.");
                break; // Salir del bucle si no hay más entradas
            } catch (IllegalStateException e) {
                System.out.println("El escáner ha sido cerrado.");
                break; // Salir del bucle si el escáner se cierra
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
                e.printStackTrace(); // Para depuración
            }
        }
    }

    private static User findUser(String name,List<User> userList)
    {
        for(User useri:userList)
        {
            if(name.equalsIgnoreCase(useri.getName()))
            {
                return useri;
            }
        }
        return null;
    }

    private static Task findTask(String name,List<Task> taskList)
    {
        for(Task taski:taskList)
        {
            if(name.equalsIgnoreCase(taski.getDescription()))
            {
                return taski;
            }
        }
        return null;
    }

    private static Project findProject(String name, List<Project> projectList)
    {
        for(Project projecti:projectList)
        {
            if(name.equalsIgnoreCase(projecti.getName()))
            {
                return projecti;
            }
        }
        return null;
    }
}
