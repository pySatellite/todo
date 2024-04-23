package canary.rest_db.controller;

import java.util.List;

import canary.rest_db.service.TodoService;
import canary.rest_db.dto.Todo;
import org.springframework.web.bind.annotation.*;


@RestController
public class TodoController {
  public final TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping("/todos")
  public List<Todo> all() {
    return todoService.getTodos();
  }
  
  @GetMapping("/todos/{id}")
  public Todo find(@PathVariable Integer id) {
    return todoService.findById(id);
  }

  @PostMapping("/todos")
  public void newTodo(@RequestBody Todo todo) {
    todoService.insert(todo);
  }

  @GetMapping("/create_table")
  public void createTable() {
    todoService.createTable();
  }
}

