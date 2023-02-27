package todoapplication.todo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todoapplication.todo.entity.TodoTask;
import todoapplication.todo.entity.User;
import todoapplication.todo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User Create(User user) {
        try {
            user = userRepository.save(user);
        } catch (Exception exp) {
            log.error("Unsuccesful repository save!");
        }
        return user;
    }

    public User Update(User user) {
        try {
            user = userRepository.save(user);
        } catch (Exception exp) {
            log.error("Unsuccesful repository update!");
        }
        return user;
    }

    public void Delete(Integer id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception exp) {
            log.error("Unsuccesful repository delete!");
        }
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            users = StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
            log.info("Finded all users!");
        } catch (Exception exp) {
            log.error("Unsuccesful repository save!");
        }
        return users;
    }

    public User getById(int id) {
        User user = null;
        try {
            user = userRepository.findById(id).get();
        } catch (Exception exp) {
            log.error("Can't find the user!");
        }
     return user;
    }
}
