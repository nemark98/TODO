package todoapplication.todo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todoapplication.todo.entity.TodoTask;
import todoapplication.todo.entity.User;
import todoapplication.todo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return (List<User>) userService.findAll();
    }

    @GetMapping("getUser/{id}")
    public User getUserById(@PathVariable("id") int id) {
        log.info("User finding started.");
        return userService.getById(id);
    }

    @PostMapping("user")
    public User Create(@RequestBody User user){
        return userService.Create(user);
    }

    @DeleteMapping("delete/{id}")
    public boolean Delete(@PathVariable("id") int id){
        log.info("Delete user started.");
        boolean ret = userService.Delete(id);
        log.info("Delete user finished.");
        return ret;
    }
    @PutMapping("/user")
    public User Update(@RequestBody User user) {
        return userService.Update(user);
    }

}
