package com.example.todo.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@MybatisTest
class TodoMapperTest {

    @Autowired
    private TodoMapper todoMapper;
    @Test
    void simpleTest() {
        Assertions.assertEquals(1, 1);
    }


    @Test
    void findAllTest() {

    }

}