package TodoList.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.Duration;
import java.time.LocalDateTime;

// This class describes:
// - The entities of the table Board
// - The getters and setters
// - The methods to construct a row in the table Board
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode // For equals checks
public class Board {

//    This will create a sequence table named lst_sequence that keep track of the next id value to be inserted.
//    I do not see any benefit using this at the moment.
//    @Id
//    @SequenceGenerator(
//            name = "lst_sequence",
//            sequenceName = "lst_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "lst_sequence"
//    )

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id") // Specifies the mapped column for a persistent property or field
    @JsonProperty("board_id")  // SQL field name
    private Long boardId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("information")
    private String information;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("last_edited_at")
    private LocalDateTime lastEditedAt;
    @Transient
    @JsonProperty("live_time_day")
    private Long liveTimeDay;

    public Board(String title, String information, LocalDateTime created_time, LocalDateTime last_edited_time) {
        this.title = title;
        this.information = information;
        this.createdAt = created_time;
        this.lastEditedAt = last_edited_time;
    }

    public Long getLiveTimeDay() {
        return Duration.between(this.createdAt, LocalDateTime.now()).toDays();
    }

    public void setLiveTimeDay(Long liveTimeDay) {
        this.liveTimeDay = liveTimeDay;
    }
}
