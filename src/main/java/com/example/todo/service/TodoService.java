package com.example.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.entity.TodoEntity;
import com.example.todo.mapper.TodoMapper;


@Service
public class TodoService {
    
     @Autowired
     TodoMapper todoMapper;

    public List<TodoEntity> getTodos() {
        System.out.println(">>> service findAll :)");
        List<TodoEntity> list = todoMapper.findAll();
        System.out.println("debug >>> list" + list.size());
        return list ;
    }
}
