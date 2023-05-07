package edu.uaslp.objetos.taskslist;


import java.util.ArrayList;
import edu.uaslp.objetos.taskslist.Task;
import java.time.LocalDateTime;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class TaskList {

    private ArrayList<Task> tasklist;

    public TaskList(){
        tasklist = new ArrayList<Task>();
    }

    public void add(Task task){
        tasklist.add(task);
    }

    public void remove(Task task){
        tasklist.remove(task);
    }

    public Task find(String title) throws TaskNotFoundException{
        Iterator iterator = tasklist.iterator();

        while(iterator.hasNext()) {
            Task currentTask = (Task) iterator.next();
            if(currentTask.getTitle() == title) {
                return currentTask;
            }
        }
        throw new TaskNotFoundException("Task with title '"+title+"' not found");
    }



    public void markAsDone(String title){
        Task task = find(title);

        task.setDone(true);
    }


    public void markAsNotDone(String title){
        Task task = find(title);

        task.setDone(false);
    }

    public int getSize() {
        return tasklist.size();
    }


    public Task getNextTask(){
        Task nextTask;

        Iterator<Task> it = tasklist.iterator();
        nextTask = it.next();

        while (it.hasNext()){
            Task actualTask = it.next();
            if(actualTask.getDueDate().isBefore(nextTask.getDueDate()) && !actualTask.isDone()){
                nextTask = actualTask;
            }
        }

        return nextTask;
    }

    public List getNextTasks(){
        LinkedList<Task> taskFound = new LinkedList<>();

        for (Task actualTask : tasklist) {
            if (actualTask.getDueDate().isAfter(LocalDateTime.now()) && !actualTask.isDone()) {
                Task task = new Task(actualTask.getTitle(), actualTask.getDescription(), actualTask.getDueDate(), actualTask.isDone());
                taskFound.add(task);
            }
        }
        taskFound.sort((Task a, Task b) -> a.getDueDate().compareTo(b.getDueDate()));

        return taskFound;
    }
}
