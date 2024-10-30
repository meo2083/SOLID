package com.mycompany.gui;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mycompany.entities.Project;
import com.mycompany.entities.Task;
import com.mycompany.entities.User;
import com.mycompany.manager.TaskManager;

public class ConsoleInterface {


    public static void start()
    {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        List<User> userList = new ArrayList<>();
        List<Task> taskList = new ArrayList<>();
        List<Project> projectList = new ArrayList<>();
        int opcion;
        while(true)
        {
            System.out.println("-------------MENU DE OPCIONES------------");
            System.out.println("1.  Agregar usuario");
            System.out.println("2.  Crear tarea");
            System.out.println("3.  Asignar tarea a usuario");
            System.out.println("4.  Completar tarea");
            System.out.println("5.  Ver tareas");
            System.out.println("6.  Crear proyecto");
            System.out.println("7.  Asignar tarea a proyecto");
            System.out.println("8.  Ver tareas de proyectos");
            System.out.println("0.  Salir");

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
                    Task task = new Task(taskName);
                    taskList.add(task);
                    break;
                case 3:
                    System.out.println("Nombre de tarea: ");
                    String taskNameForUser = scanner.next();
                    scanner.nextLine();
                    Task taskToAssign = findTask(taskNameForUser,taskList);
                    System.out.println("Nombre de usuario: ");
                    String userForTask = scanner.next();
                    scanner.nextLine();
                    User userToAssign = findUser(userForTask,userList);
                    if(taskToAssign != null && userToAssign != null)
                    {
                        taskManager.assignTaskToUser(taskToAssign, userToAssign);
                    }else {
                        if(taskToAssign == null) {
                            System.out.println("Tarea "+taskNameForUser+" no existe");
                        }
                        if(userToAssign == null)
                        {
                            System.out.println("Usuario "+userForTask+" no existe");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Nombre de tarea: ");
                    String taskNameToComplete = scanner.next();
                    scanner.nextLine();
                    Task taskToComplete = findTask(taskNameToComplete, taskList);
                    if(taskToComplete != null)
                    {
                        taskManager.completeTask(taskToComplete);
                    }else {
                        System.out.println("No existe tarea: "+taskNameToComplete);
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
                    Task taskForProject = findTask(taskToAssignToProject, taskList);
                    if(projectFound != null && taskToAssignToProject != null)
                    {
                        projectFound.addTask(taskForProject);
                    }else {
                        if(projectFound == null)
                        {
                            System.out.println("No existe proyecto "+projectFound);
                        }
                        if(taskForProject == null)
                        {
                            System.out.println("No existe tarea "+taskForProject);
                        }
                    }
                    break;
                case 8:
                    System.out.println("Ingrese nombre de proyecto: ");
                    String projectToShow = scanner.next();
                    scanner.nextLine();
                    Project projecti = findProject(projectToShow, projectList);
                    if(projecti != null) {
                        projecti.showTasks();
                    }else {
                        System.out.println("No existe proyecto: "+projectToShow);
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción no válida");
                    break;

            }
           //scanner.close();
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
