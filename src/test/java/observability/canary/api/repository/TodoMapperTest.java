package observability.canary.api.repository;

import observability.canary.api.dto.Todo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@MybatisTest
class TodoMapperTest {

    @Autowired
    private TodoMapper todoMapper;

    private Todo todoEntity;
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
        Todo todo = new Todo();
        todo.setSubject("subject");
        todo.setBody("body");
        todo.setCompleted(true);
        todoMapper.insert(todo);

        // WHEN
        List<Todo> todos = todoMapper.findAll();

        // THEN
        Assertions.assertEquals(11, todos.get(0).getId());
        Assertions.assertEquals("subject", todos.get(0).getSubject());
        Assertions.assertEquals("body", todos.get(0).getBody());
        Assertions.assertEquals(true, todos.get(0).getCompleted());
    }

    @Test
    void findIdTest() {
        // GIVEN

        // WHEN
        Todo todo= todoMapper.findById(1);

        // THEN
        Assertions.assertEquals(1, todo.getId());
        Assertions.assertEquals("Morning workout", todo.getSubject());
        Assertions.assertEquals("30 minutes of exercise at home", todo.getBody());
        Assertions.assertEquals(false, todo.getCompleted());
    }
}
