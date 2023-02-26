package todoapplication.todo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import todoapplication.todo.entity.TodoTask;
import todoapplication.todo.repository.TodoTaskRepository;
import todoapplication.todo.service.TodoTaskService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todoTask")
@Slf4j
public class TodoTaskController {

    @Autowired
    TodoTaskService todoTaskService;

    @GetMapping("/findByUser/{id}")
    public List<TodoTask> findByUser(@PathVariable("id") int id) {
        return todoTaskService.findByUser(id);
    }
}
