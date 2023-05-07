package edu.uaslp.objetos.taskslist;

import java.time.LocalDateTime;
import java.util.Date;

public class Task {
    private String title;
    private String description;
    private Boolean done;
    private LocalDateTime dueDate;

    Task(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    Task(){

    }

    public Task(String title, String description, LocalDateTime dueDate, boolean done) throws TaskListException {

        validateDate(dueDate);

        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.done = done;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }


    public void setDueDate(LocalDateTime dueDate) throws TaskListException{
        LocalDateTime now = LocalDateTime.now();
        if(dueDate.isBefore(now)){
            throw new TaskListException("Due date is set in the past");
        }
        this.dueDate = dueDate;
    }


    private void validateDate(LocalDateTime date) throws TaskListException {
        if(date.isBefore(LocalDateTime.now())) {
            throw new InvalidDueDateException();
        }
    }
}
