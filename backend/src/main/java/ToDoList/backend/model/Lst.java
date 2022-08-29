package TodoList.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Entity
public class Lst {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long list_id;
    private String title;
    private String descript;
    private LocalDateTime created_time;
    private LocalDateTime last_edited_time;

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

    @Override
    public String toString() {
        return "Lst{" +
                "list_id=" + list_id +
                ", title='" + title + '\'' +
                ", descript='" + descript + '\'' +
                ", created_time=" + created_time +
                ", last_edited_time=" + last_edited_time +
                '}';
    }
}
