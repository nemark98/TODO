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
     * Creates the user in repository
     * @param user
     * @return user
     */
    public User Create(User user) {
        try {
            user = userRepository.save(user);
            log.info("Successful user creation in repo: {}", user);
        } catch (Exception exp) {
            log.error("Unsuccesful user creation in repo: {}", user);
        }
        return user;
    }

    /**
     * Updates user's properties in repository
     * @param user
     * @return updated user
     */
    public User Update(User user) {
        try {
            user = userRepository.save(user);
            log.info("Successful user repo update: {}", user);
        } catch (Exception exp) {
            log.error("Unsuccesful user repo update: {}", user);
        }
        return user;
    }

    /**
     * Deletes user from repository by ID
     * @param id
     * @return ret
     */
    public boolean Delete(int id) {
        boolean ret = true;
        try {
            userRepository.deleteById(id);
            log.info("Successful user delete from repo: {}", id);
        } catch (Exception exp) {
            ret = false;
            log.error("Unsuccesful user delete from repo: {}", id);
        }
        return ret;
    }

    /**
     * Find existing users
     * @return users list
     */
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            users = StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
            log.info("Finded all users!");
        } catch (Exception exp) {
            log.error("Didn't find all the users");
        }
        return users;
    }

    /**
     * Finds user by ID
     * @param id
     * @return user
     */
    public User getById(int id) {
        User user = null;
        try {
            user = userRepository.findById(id).get();
            log.info("Finded the user: {}", id);
        } catch (Exception exp) {
            log.error("Didn't find the user: {}", id);
        }
     return user;
    }
}
