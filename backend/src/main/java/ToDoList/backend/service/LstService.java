package TodoList.backend.service;

import TodoList.backend.model.Lst;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LstService {
    public List<Lst> getLists() {
        return List.of(
                new Lst(
                        1L,
                        "title",
                        "description",
                        LocalDateTime.of(2022, 8, 28, 21, 36,0),
                        LocalDateTime.of(2022, 8, 28, 21, 38,10)
                )
        );
    }
}
