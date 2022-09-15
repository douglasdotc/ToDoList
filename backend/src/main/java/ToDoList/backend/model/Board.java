package TodoList.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

// This class describes:
// - The entities of the table Board
// - The getters and setters
// - The methods to construct a row in the table Board
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data // Includes @Getter @Setter @ToString @RequiredArgsConstructor @EqualsAndHashCode
public class Board {
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "board")
    private Set<Item> items = new HashSet<>();

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
