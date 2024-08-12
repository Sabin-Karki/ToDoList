package com.example.secondStarter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ToDo {
    private final List<ToDoClass> toDoList = new ArrayList<>();

    public ToDo() {

    }

    @GetMapping("/{identifier}/newTodo")
    public String showList(@PathVariable("identifier") String identifier, Model model) {
//        model.addAttribute("List", toDoList);
        List<ToDoClass> li = toDoList.stream().filter(t->t.getIdentifier().equals(identifier)).toList();

        model.addAttribute("List", li);
        model.addAttribute("userid", identifier);
        return "ToDoList"; // Return the Thymeleaf template
    }

    @PostMapping("/{identifier}/newTodo/add")
    public String add(@PathVariable("identifier") String identifier, String desc,String title,  Model model) {
        ToDoClass newTodo = new ToDoClass(title, desc,identifier);
        toDoList.add(newTodo);
        model.addAttribute("List", toDoList);
        model.addAttribute("userid", identifier);
        return "ToDoList"; // Return the updated list
    }

    @GetMapping("/{identifier}/newTodo/delete/{id}")
    public String delete(@PathVariable("identifier") String identifier ,@PathVariable("id") int id, Model model) {
        toDoList.removeIf(todo -> todo.getId() == id && todo.getIdentifier().equals(identifier)); // Remove the task if it exists
        model.addAttribute("List", toDoList);
        model.addAttribute("userid",identifier);
        return "ToDoList"; // Return the updated list
    }
}
