package observability.canary.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import observability.canary.api.dto.Todo;
import observability.canary.api.repository.TodoMapper;


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
