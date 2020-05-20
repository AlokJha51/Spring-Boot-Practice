package com.example.HelloWorld.Services;

import com.example.HelloWorld.Model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "alok", "Learn Spring MVC", new Date(),
                false));
        todos.add(new Todo(2, "alok", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "alok", "Learn Hibernate", new Date(),
                false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public Todo retrieveTodo(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public void addTodo(String name, String desc, Date targetDate,
                        boolean isDone) {
        todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    }

    public static void updateTodo(Todo todo) {
        int i = 0;
        int index = -1;
        for (Todo todoTask : todos) {
            if (todoTask.getId() == todo.getId()) {
                index = i;
                break;
            }
            ++i;
        }
        if(index != -1){
            todos.remove(index);
            todos.add(index,todo);
        }

    }

    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }
}
