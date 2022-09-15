package TodoList.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

    @ManyToOne
    @ToString.Exclude // To terminate printing infinite loop board --> items --> board...
    private Board board;

    public Item(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
