package TodoList.backend.model;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

// This class describes:
// - The entities of the table Lst
// - The getters and setters
// - The methods to construct a row in the table Lst
@Entity
public class Lst {

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
    @Column(name = "list_id")
    private Long list_id;
    private String title;
    private String descript;
    private LocalDateTime created_time;
    private LocalDateTime last_edited_time;

    @Transient
    private Long live_time_day;

    public Lst(String title, String descript, LocalDateTime created_time, LocalDateTime last_edited_time) {
        this.title = title;
        this.descript = descript;
        this.created_time = created_time;
        this.last_edited_time = last_edited_time;
    }

    public Lst(Long list_id, String title, String descript, LocalDateTime created_time, LocalDateTime last_edited_time) {
        this.list_id = list_id;
        this.title = title;
        this.descript = descript;
        this.created_time = created_time;
        this.last_edited_time = last_edited_time;
    }

    public Lst() {
    }

    public Long getList_id() {
        return list_id;
    }

    public void setList_id(Long list_id) {
        this.list_id = list_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public LocalDateTime getCreated_time() {
        return created_time;
    }

    public void setCreated_time(LocalDateTime created_time) {
        this.created_time = created_time;
    }

    public LocalDateTime getLast_edited_time() {
        return last_edited_time;
    }

    public void setLast_edited_time(LocalDateTime last_edited_time) {
        this.last_edited_time = last_edited_time;
    }

    public Long getLive_time_day() {
        return Duration.between(this.created_time, LocalDateTime.now()).toDays();
    }

    public void setLive_time_day(Long live_time_day) {
        this.live_time_day = live_time_day;
    }

    @Override
    public String toString() {
        return "Lst{" +
                "list_id=" + list_id +
                ", title='" + title + '\'' +
                ", descript='" + descript + '\'' +
                ", created_time=" + created_time +
                ", last_edited_time=" + last_edited_time +
                ", live_time_day=" + live_time_day +
                '}';
    }
}
