package ToDoList.backend;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class tag_values {
    private @Id @GeneratedValue Long tag_value_id;
    private Long tag_id;
    private String val;

    tag_values() {

    }

    tag_values(Long tag_id, String val) {
        this.tag_id = tag_id;
        this.val = val;
    }

}
