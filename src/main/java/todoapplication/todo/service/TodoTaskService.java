package todoapplication.todo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todoapplication.todo.entity.TodoTask;
import todoapplication.todo.entity.User;
import todoapplication.todo.repository.TodoTaskRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TodoTaskService {

    @Autowired
    TodoTaskRepository todoTaskRepository;
    @Autowired
    UserService userService;

    public void Create(TodoTask todoTask) {
        try {
            todoTaskRepository.save(todoTask);
        } catch (Exception exp) {
            log.error("Unsuccesful repository save!");
        }
    }

    public void Update(TodoTask todoTask) {
        try {
            todoTaskRepository.save(todoTask);
        } catch (Exception exp) {
            log.error("Unsuccesful repository update!");
        }
    }

    public void Delete(TodoTask todoTask) {
        try {
            todoTaskRepository.delete(todoTask);
        } catch (Exception exp) {
            log.error("Unsuccesful repository delete!");
        }
    }

    public List<TodoTask> findByUser(Integer id) {
        List<TodoTask> todoTasks = new ArrayList<>();
        try {
            User user = userService.getById(id);
            todoTasks = todoTaskRepository.findByUser(user);
            log.info("Finded all task!");
        } catch (Exception exp) {
            log.error("Unsuccesful repository save!");
        }
        return todoTasks;
    }
}
