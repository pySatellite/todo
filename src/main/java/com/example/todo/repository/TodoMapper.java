package com.example.todo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.todo.dto.TodoEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TodoMapper {
    List<TodoEntity> findAll();

    @Select("SELECT * FROM todos WHERE id = #{id}")
    TodoEntity findById(@Param("id") Integer id);

    void createTable();

    void insert(TodoEntity todo);
}
