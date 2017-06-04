/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo.ejb;

import javax.ejb.Remote;
import todo.entities.TodoItem;

/**
 *
 * @author larry
 */
@Remote
public interface TodoDataEJBRemote {

    public TodoItem[] getAllTodoItems();

    public void addTodoItem(TodoItem item);
}
