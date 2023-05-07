package edu.uaslp.objetos.taskslist;

public class TaskListException extends RuntimeException{
    public TaskListException(){
    }
    public TaskListException(String message){
        super(message);
    }
}
