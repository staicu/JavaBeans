/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo.ejb;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import static javax.ejb.LockType.READ;
import static javax.ejb.LockType.WRITE;
import javax.ejb.Singleton;
import todo.entities.TodoItem;

/**
 *
 * @author larry
 */
@Singleton
public class TodoDataEJB implements TodoDataEJBRemote {

    private ArrayList<TodoItem> todoList;

    @PostConstruct
    public void initialize() {
        todoList = new ArrayList<>();

    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    @Lock(READ)
    public TodoItem[] getAllTodoItems() {
        System.out.println("getAllTodoItems");
        TodoItem[] toDoArr = new TodoItem[todoList.size()];
        toDoArr = todoList.toArray(toDoArr);
        return toDoArr;
    }

    @Override
    @Lock(WRITE)
    public void addTodoItem(TodoItem item) {
        
        todoList.add(item);
        System.out.println("TodoItem");
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
