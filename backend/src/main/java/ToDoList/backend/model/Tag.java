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

// Model class for tag table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    @JsonProperty("tag_id")
    private Long tagId;
    @JsonProperty("item_id")
    private Long itemId;
    @JsonProperty("tag_name")
    private String tagName;

    public Tag(Long itemId, String tagName) {
        this.itemId = itemId;
        this.tagName = tagName;
    }
}
