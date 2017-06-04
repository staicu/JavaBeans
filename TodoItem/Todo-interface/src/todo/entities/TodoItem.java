/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo.entities;

import java.util.Date;

/**
 *
 * @author larry
 */
public class TodoItem {

    private  int id;
    private  static int counter;
    private String task;
    private Date dueDate;
    private boolean isDone;

    public TodoItem(String task, Date dueDate, boolean isDone) {
        counter ++;
        this.id = counter;
        this.task = task;
        this.dueDate = dueDate;
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
            if(task == null || task.isEmpty()){
        try {
            throw new IllegalArgumentException("Task description must not be emtpy.");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
        this.task = task;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }
    
}
