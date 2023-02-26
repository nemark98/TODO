package todoapplication.todo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String first_name;
    private String last_name;
    private String username;
    private String password;
    @Lob
    private byte[] photo;

    @OneToMany
    private Set<TodoTask> TaskSet;
}
