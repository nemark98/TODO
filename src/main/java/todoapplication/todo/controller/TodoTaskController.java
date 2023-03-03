package todoapplication.todo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todoapplication.todo.entity.TodoTask;
import todoapplication.todo.service.TodoTaskService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/todoTask")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class TodoTaskController {

    @Autowired
    TodoTaskService todoTaskService;

    @GetMapping("/findByUser/{id}")
    public List<TodoTask> findByUser(@PathVariable("id") int id) {
        log.info("findByUser started.");
        return todoTaskService.findByUser(id);
    }

    @PostMapping("todoTask")
    public TodoTask Create(@RequestBody TodoTask todoTask){
            return todoTaskService.Create(todoTask);
    }

    @DeleteMapping("delete/{id}")
    public boolean Delete(@PathVariable("id") int id){
        log.info("Delete todoTask started.");
        boolean ret = todoTaskService.Delete(id);
        log.info("Delete todoTask finished.");
        return ret;
    }

    @PutMapping("/todoTask")
    public TodoTask Update(@RequestBody TodoTask todoTask) {
        return todoTaskService.Update(todoTask);
    }
}
