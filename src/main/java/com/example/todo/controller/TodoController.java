package com.example.todo.controller;

import java.util.List;

import com.example.todo.dto.TodoEntity;
import com.example.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;


@RestController
public class TodoController {
  public final TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping("/todos")
  public List<TodoEntity> all() {
    return todoService.getTodos();
  }
  
  @GetMapping("/todos/{id}")
  public TodoEntity find(@PathVariable Integer id) {
    return todoService.findById(id);
  }

  @PostMapping("/todos")
  public void newTodo(@RequestBody TodoEntity todo) {
    todoService.insert(todo);
  }

  @GetMapping("/create_table")
  public void createTable() {
    todoService.createTable();
  }
}

