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

    /**
     * Creates a TodoTask in repository
     * @param todoTask
     * @return todoTask
     */
    public TodoTask Create(TodoTask todoTask) {
        try {
            todoTask.setUser(userService.getById(todoTask.getUser().getId()));
            todoTask = todoTaskRepository.save(todoTask);
            log.info("Successful todoTask creation in repo: {}", todoTask);
        } catch (Exception exp) {
            log.error("Unsuccesful todoTask creation in repo: {}",todoTask);
        }
        return todoTask;
    }

    /**
     * Updates todoTask's properties in repository
     * @param todoTask
     * @return updated todoTask
     */
    public TodoTask Update(TodoTask todoTask) {
        try {
            todoTask = todoTaskRepository.save(todoTask);
            log.info("Sucessful todoTask update in repo: {}", todoTask);
        } catch (Exception exp) {
            log.error("Unsuccesful todoTask update in repo: {}", todoTask);
        }
        return todoTask;
    }

    /**
     * Deletes todoTask from repository by ID
     * @param id
     * @return ret
     */
    public boolean Delete(Integer id) {
        boolean ret = true;
        try {
            todoTaskRepository.deleteById(id);
            log.info("Successful todoTask delete from repo: {}", id);
        } catch (Exception exp) {
            ret = false;
            log.error("Unsuccesful todoTask delete from repo: {}", id);
        }
        return ret;
    }

    /**
     * Finds todoTask by user
     * @param id
     * @return todoTask associated with the user
     */
    public List<TodoTask> findByUser(Integer id) {
        List<TodoTask> todoTasks = new ArrayList<>();
        try {
            User user = userService.getById(id);
            todoTasks = todoTaskRepository.findByUser(user);
            log.info("Finded all todoTask by user: {}", id);
        } catch (Exception exp) {
            log.error("Didn't find all todoTask: {}", id);
        }
        return todoTasks;
    }
}
