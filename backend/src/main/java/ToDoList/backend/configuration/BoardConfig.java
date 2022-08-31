package TodoList.backend.configuration;

import TodoList.backend.model.Board;
import TodoList.backend.repository.BoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

// This class set the configuration for the table Board
// This will auto-run when Spring Boot is initializing
// Seems like this should be in testing
@Configuration
public class BoardConfig {

    @Bean // CommandLineRunner: auto-run function when it is contained in Spring Boot container
    CommandLineRunner commandLineRunner(BoardRepository boardRepository) {
        return args -> {
            Board board1 = new Board(
                "title1",
                "description1",
                LocalDateTime.of(2022, 8, 28, 21, 36,0),
                LocalDateTime.of(2022, 8, 28, 21, 38,10)
            );

            Board board2 = new Board(
                "title2",
                "description2",
                LocalDateTime.of(2022, 8, 29, 22, 36,0),
                LocalDateTime.of(2022, 8, 29, 22, 38,10)
            );

            // This following line is executed when Hibernate invoke the function saveAll()
            boardRepository.saveAll(
                List.of(board1, board2)
            );
        };
    }
}
