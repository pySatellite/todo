package com.example.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo.dto.TodoEntity;
import com.example.todo.repository.TodoMapper;


@Service
public class TodoService {
    
    final TodoMapper todoMapper;

    public TodoService(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    public List<TodoEntity> getTodos() {
        return todoMapper.findAll();
    }

    public void createTable() {
        todoMapper.createTable();
    }

    public TodoEntity findById(Integer id) {
        return todoMapper.findById(id);
    }

    public void insert(TodoEntity todo) {
        todoMapper.insert(todo);
    }
}
