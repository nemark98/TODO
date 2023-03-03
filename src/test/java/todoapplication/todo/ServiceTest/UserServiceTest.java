package todoapplication.todo.ServiceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import todoapplication.todo.entity.User;
import todoapplication.todo.repository.UserRepository;
import todoapplication.todo.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith({MockitoExtension.class})
@SpringBootTest
public class UserServiceTest {


    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void initTest() {
        userRepository = mock(UserRepository.class);
    }

    @Test
    public void createUser_Test() {

        // Arrange
        UserService sut = new UserService(userRepository);
        User user = new User();
        user.setId(14);
        user.setFirst_name("John");
        user.setLast_name("Doe");
        user.setUsername("johndoe");
        user.setPassword("asd");
        user.setEmail("johndoe@gmail.com");

        when(userRepository.save(user)).thenReturn(user);

        // Act
        User ret = sut.Create(user);

        // Assert
        assertEquals(user.getId(), ret.getId());
        assertEquals(user.getFirst_name(), ret.getFirst_name());
        assertEquals(user.getLast_name(), ret.getLast_name());
        assertEquals(user.getUsername(), ret.getUsername());
        assertEquals(user.getPassword(), ret.getPassword());
        assertEquals(user.getEmail(), ret.getEmail());
    }

//    @Test
//    public void updateUser_Test() {
//        UserService sut = new UserService(userRepository);
//        User user = new User();
//        user.setId(20);
//        user.setFirst_name("John");
//        user.setLast_name("Doe");
//    }

}
