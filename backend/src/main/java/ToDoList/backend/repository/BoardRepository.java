package TodoList.backend.repository;

import TodoList.backend.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// This class is an interface that access the board database (a repository)
// We need functions in JpaRepository, so we inherit from it
@Repository // DAO: Data Access Object
public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("SELECT b FROM Board b WHERE b.title = :title") // use bind parameters (:var) to prevent code injection
    Optional<Board> findBoardByTitle(String title);
}
