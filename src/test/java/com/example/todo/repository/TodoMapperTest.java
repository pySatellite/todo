package com.example.todo.repository;

import com.example.todo.dto.TodoEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ExtendWith(SpringExtension.class)
@MybatisTest
class TodoMapperTest {

    @Autowired
    private TodoMapper todoMapper;

    private TodoEntity todoEntity;
    @Test
    void simpleTest() {
        Assertions.assertEquals(1, 1);
        Assertions.assertTrue(true);
        Assertions.assertFalse(false);
    }

    @Test
    void findAllTest() {
        // GIVEN
        // todoMapper.createTable();
        TodoEntity todo = new TodoEntity();
        todo.setSubject("subject");
        todo.setBody("body");
        todo.setCompleted(true);
        todoMapper.insert(todo);

        // WHEN
        List<TodoEntity> todos = todoMapper.findAll();

        // THEN
        Assertions.assertEquals(11, todos.get(0).id);
        Assertions.assertEquals("subject", todos.get(0).subject);
        Assertions.assertEquals("body", todos.get(0).body);
        Assertions.assertEquals(true, todos.get(0).completed);
    }

    @Test
    void findIdTest() {
        // GIVEN

        // WHEN
        TodoEntity todo= todoMapper.findById(1);

        // THEN
        Assertions.assertEquals(1, todo.getId());
        Assertions.assertEquals("Morning workout", todo.getSubject());
        Assertions.assertEquals("30 minutes of exercise at home", todo.getBody());
        Assertions.assertEquals(false, todo.getCompleted());
    }
}
