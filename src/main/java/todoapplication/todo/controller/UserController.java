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
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return (List<User>) userService.findAll();
    }

    @PostMapping("user")
    public User Create(@RequestBody User user){
        return userService.Create(user);
    }

    @DeleteMapping("delete/{id}")
    public void Delete(@PathVariable("id") int id){
        log.info("Delete user started.");
        userService.Delete(id);
        log.info("Delete user finished.");
    }
    @PutMapping("/user")
    public User Update(@RequestBody User user) {
        return userService.Update(user);
    }

}
