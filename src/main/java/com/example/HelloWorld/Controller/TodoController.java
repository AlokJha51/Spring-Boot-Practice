package com.example.HelloWorld.Controller;

import com.example.HelloWorld.Model.Todo;
import com.example.HelloWorld.Services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    TodoService service;


    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String displayTodoList(ModelMap model) {
        String obj = (String) model.get("name");
        model.addAttribute("todos", service.retrieveTodos(obj));
        return "list-todo";
    }

    @RequestMapping(value = "/add-todos", method = RequestMethod.GET)
    public String showAddTodo(ModelMap model) {
        model.addAttribute("todo",new Todo(0, (String) model.get("name"),
                "", new Date(), false));
        return "add-todo";
    }

    @RequestMapping(value = "/add-todos", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid  Todo todo, BindingResult result) {
        if(result.hasErrors()){
            return "add-todo";
        }
        service.addTodo((String) model.get("name"), todo.getDesc(), new Date(), false);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/update-todos", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap model) {
        Todo todo = service.retrieveTodo(id);
        model.put("todo", todo);
        return "update-todo";
    }

    @RequestMapping(value = "/update-todos", method = RequestMethod.POST)
    public String UpdateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()){
            return "update-todo";
        }
        todo.setUser((String) model.get("name"));
        service.updateTodo(todo);

        return "redirect:/list-todos";

    }

    @RequestMapping(value = "/delete-todos", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        service.deleteTodo(id);
        return "redirect:/list-todos";
    }
}
