package observability.canary.api.dto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "todo", path = "todo")
public interface TodoRepository extends PagingAndSortingRepository<Todo, Integer>, CrudRepository<Todo,Integer> {
  List<Todo> findBySubject(@Param("subject") String subject);

}
