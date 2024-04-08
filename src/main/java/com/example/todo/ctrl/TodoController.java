package com.example.todo.ctrl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.entity.TodoEntity;
import com.example.todo.service.TodoService;


@RestController
public class TodoController {

    public final TodoService todoService ;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/list")
    public List<TodoEntity> list() {
        return todoService.getTodos();
    }

    @GetMapping("/find")
    public TodoEntity find() {
        return todoService.findById(1);
    }

    @GetMapping("/create_table")
    public void createTable() {
        todoService.createTable();
    }
}
