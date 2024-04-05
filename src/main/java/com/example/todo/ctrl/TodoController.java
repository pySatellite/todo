package com.example.todo.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.entity.TodoEntity;
import com.example.todo.service.TodoService;


/*
API 
(읽기)
GET  : http://localhost:3000/todos/${todoId}
GET  : http://localhost:3000/todos/read/${todoId}
(수정)
PUT  : http://localhost:3000/todos/${todoId}
PUT  : http://localhost:3000/todos/update/${todoId}
(삭제)
PUT  : http://localhost:3000/todos/${todoId}
PUT  : http://localhost:3000/todos/delete/${todoId}

(저장)
POST : http://localhost:3000/todos
POST : http://localhost:3000/todos/save
(전체)
GET  : http://localhost:3000/todos?_sort=id&_order=desc&subject_like=${searchText.value}&_page=${page}&_limit=${limit}
GET  : http://localhost:3000/todos/all
*/
@RestController
public class TodoController {

    @Autowired
    public TodoService todoService ; 
    @GetMapping("/list")
    public String list() {
        System.out.println(">>> ctrl list ");
        // List<TodoEntity> result = todoService.findAll();
        // System.out.println("debug >>> result , "+result); 
        return "Hello World Complete!~~~";
    
    }
}
