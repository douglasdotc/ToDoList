package TodoList.backend.model;

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
    @Column(name = "board_id")
    private Long board_id;
    private String title;
    private String information;
    private LocalDateTime created_at;
    private LocalDateTime last_edited_at;
    @Transient
    private Long live_time_day;

    public Board(String title, String information, LocalDateTime created_time, LocalDateTime last_edited_time) {
        this.title = title;
        this.information = information;
        this.created_at = created_time;
        this.last_edited_at = last_edited_time;
    }

    public Board(Long board_id, String title, String information, LocalDateTime created_time, LocalDateTime last_edited_time) {
        this.board_id = board_id;
        this.title = title;
        this.information = information;
        this.created_at = created_time;
        this.last_edited_at = last_edited_time;
    }

    public Board() {
    }

    public Long getBoard_id() {
        return board_id;
    }

    public void setBoard_id(Long board_id) {
        this.board_id = board_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getLast_edited_at() {
        return last_edited_at;
    }

    public void setLast_edited_at(LocalDateTime last_edited_at) {
        this.last_edited_at = last_edited_at;
    }

    public Long getLive_time_day() {
        return Duration.between(this.created_at, LocalDateTime.now()).toDays();
    }

    public void setLive_time_day(Long live_time_day) {
        this.live_time_day = live_time_day;
    }

    @Override
    public String toString() {
        return "Lst{" +
            "board_id=" + board_id +
            ", title='" + title + '\'' +
            ", information='" + information + '\'' +
            ", created_time=" + created_at +
            ", last_edited_time=" + last_edited_at +
            ", live_time_day=" + live_time_day +
            '}';
    }
}
