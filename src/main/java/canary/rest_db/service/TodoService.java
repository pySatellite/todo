package canary.rest_db.service;

import java.util.List;

import org.springframework.stereotype.Service;

import canary.rest_db.dto.Todo;
import canary.rest_db.repository.TodoMapper;


@Service
public class TodoService {
  final TodoMapper todoMapper;

  public TodoService(TodoMapper todoMapper) {
    this.todoMapper = todoMapper;
  }

  public List<Todo> getTodos() {
    return todoMapper.findAll();
  }

  public void createTable() {
    todoMapper.createTable();
  }

  public Todo findById(Integer id) {
    return todoMapper.findById(id);
  }

  public void insert(Todo todo) {
    todoMapper.insert(todo);
  }
}
