package todoapplication.todo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import todoapplication.todo.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {



}
