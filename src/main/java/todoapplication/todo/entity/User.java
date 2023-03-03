package todoapplication.todo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private String email;
    @Lob
    private byte[] photo;

//    @OneToMany
//    private Set<TodoTask> TaskSet;
}
