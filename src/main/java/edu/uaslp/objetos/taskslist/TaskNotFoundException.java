package edu.uaslp.objetos.taskslist;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(String message){
        super(message);
    }

    public TaskNotFoundException(){

    }
}
