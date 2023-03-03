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

    public TodoTask Create(TodoTask todoTask) {
        try {
            todoTask.setUser(userService.getById(todoTask.getUser().getId()));
            todoTask = todoTaskRepository.save(todoTask);
        } catch (Exception exp) {
            log.error("Unsuccesful repository save!");
        }
        return todoTask;
    }

    public TodoTask Update(TodoTask todoTask) {
        try {
            todoTask = todoTaskRepository.save(todoTask);
            log.info("Sucessfully ");
        } catch (Exception exp) {
            log.error("Unsuccesful repository update!");
        }
        return todoTask;
    }

    public boolean Delete(Integer id) {
        boolean ret = true;
        try {
            todoTaskRepository.deleteById(id);
            log.info("Repository deleted!");
        } catch (Exception exp) {
            ret = false;
            log.error("Unsuccesful repository delete!");
        }
        return ret;
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
