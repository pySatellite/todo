package observability.canary.api.controller;

import observability.canary.api.dto.Todo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
//@MybatisTest
@AutoConfigureMybatis
class TodoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void all() throws Exception {
        MvcResult mvcResult = mvc.perform(get("/todos"))
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$.length()").value(10))
                .andDo(print())
                .andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Todo> todos = objectMapper.readValue(json, new TypeReference<>() {});

        // assertEquals(10, todos.size());

        for (Todo todo : todos) {
            assertNotNull(todo.getId());
            assertNotNull(todo.getSubject());
            assertNotNull(todo.getBody());
            assertNotNull(todo.getCompleted());
        }
    }
}