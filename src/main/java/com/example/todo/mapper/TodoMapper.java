package com.example.todo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.todo.entity.TodoEntity;

@Mapper
public interface TodoMapper {
    List<TodoEntity> findAll();
}
