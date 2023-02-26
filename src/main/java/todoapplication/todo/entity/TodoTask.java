package todoapplication.todo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
public class TodoTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String description;
    private Date due_date;
    private String status;

    @ManyToOne
    User user;
}
