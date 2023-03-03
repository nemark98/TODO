//package todoapplication.todo.IntegrationTest;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class RestIntegrationTest {
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate testRestTemplate;
//
//    @Test
//    public void getUserTest() {
//        String url = "http://localhost:" + port + "getUser/{id}";
//        Map<String, String> pathVariable=new HashMap<>();
//        pathVariable.put("id", "2");
//
//        HttpEntity<String> entity = new HttpEntity<>(null, null);
//        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
//
//        ResponseEntity<String> response = testRestTemplate.exchange(builder.buildAndExpand(pathVariable).toUri(), HttpMethod.GET, entity, String.class);
//        System.out.println(response);
//        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
//}
