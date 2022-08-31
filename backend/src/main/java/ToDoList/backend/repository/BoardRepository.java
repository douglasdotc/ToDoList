package TodoList.backend.repository;

import TodoList.backend.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This class is an interface that access the database (a repository)
// The functions we need are in JpaRepository, so we inherit from it
@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

}
