package canary.rest_db.repository;

import java.util.List;

import canary.rest_db.dto.Todo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TodoMapper {
    List<Todo> findAll();

    @Select("SELECT * FROM todo WHERE id = #{id}")
    Todo findById(@Param("id") Integer id);

    void createTable();

    void insert(Todo todo);
}
