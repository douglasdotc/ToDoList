package TodoList.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Item's model class
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    @JsonProperty("item_id")
    private Long itemId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("content")
    private String content;

    public Item(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
