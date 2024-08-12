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
        toDoList.add(new ToDoClass("Sabin", "Initial task"));
        toDoList.add(new ToDoClass("Karki", "Another task"));
        toDoList.add(new ToDoClass("Okay", "Yet another task"));
    }

    @GetMapping("/newTodo")
    public String showList(Model model) {
//        model.addAttribute("List", toDoList);
        return "ToDoList"; // Return the Thymeleaf template
    }

    @PostMapping("/newTodo/add")
    public String add(String title, String desc, Model model) {
        ToDoClass newTodo = new ToDoClass(title, desc);
        toDoList.add(newTodo);
        model.addAttribute("List", toDoList);
        return "ToDoList"; // Return the updated list
    }

    @GetMapping("/newTodo/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        toDoList.removeIf(todo -> todo.getId() == id); // Remove the task if it exists
        model.addAttribute("List", toDoList);
        return "ToDoList"; // Return the updated list
    }
}