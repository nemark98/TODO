package todoapplication.todo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import todoapplication.todo.entity.TodoTask;
import todoapplication.todo.entity.User;

import java.util.List;

@Repository
public interface TodoTaskRepository extends CrudRepository<TodoTask, Integer> {

    List<TodoTask> findByUser(User user);
}
