package com.example.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.entity.TodoEntity;
import com.example.todo.mapper.TodoMapper;


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
}
