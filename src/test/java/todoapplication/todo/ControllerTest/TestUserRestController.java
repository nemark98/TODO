//package todoapplication.todo.ControllerTest;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import todoapplication.todo.controller.UserController;
//import todoapplication.todo.entity.User;
//import todoapplication.todo.repository.UserRepository;
//import todoapplication.todo.service.UserService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@WebMvcTest(UserController.class)
//public class TestUserRestController {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private UserRepository userRepository;
//
//    @MockBean
//    private UserService userService;
//
////    @Test
////    public void getAllUsersApiTest() {
////
////        List<User> userList = new ArrayList<>();
////
////        userList.add(new User());
////
////        Mockito.when(userService.findAll()).thenReturn(userList);
////    }
//}
