package todoapplication.todo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todoapplication.todo.entity.User;
import todoapplication.todo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class UserService {

    //tesztelhetőség miatt Autowired off
    //@Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Creates the user in repo
     * @param user
     * @return user
     */
    public User Create(User user) {
        try {
            user = userRepository.save(user);
        } catch (Exception exp) {
            log.error("Unsuccesful repository save!");
        }
        return user;
    }

    /**
     * Updates user's properties
     * @param user
     * @return user
     */
    public User Update(User user) {
        try {
            user = userRepository.save(user);
        } catch (Exception exp) {
            log.error("Unsuccesful repository update!");
        }
        return user;
    }

    /**
     * Deletes the user from repo by id
     * @param id
     * @return ret
     */
    public boolean Delete(int id) {
        boolean ret = true;
        try {
            userRepository.deleteById(id);
        } catch (Exception exp) {
            ret = false;
            log.error("Unsuccesful repository delete!");
        }
        return ret;
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
