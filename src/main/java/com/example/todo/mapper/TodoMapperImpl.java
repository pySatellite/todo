package com.example.todo.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.todo.entity.TodoEntity;

// @Repository
public class TodoMapperImpl {
    
    @Autowired
	public SqlSession session;

    private String ns = "com.example.todo.mapper.";
    
    public String selectSampleData() {
        System.out.println("debug >>> mapper ");
        // List<TodoEntity> list = session.selectList(ns + "findAll");
        // System.out.println("result , " + list ); 
        return "data" ; 
    }
    
}
