package TodoList.backend.repository;

import TodoList.backend.model.Lst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This class is an interface that access the database (a repository)
// The functions we need are in JpaRepository, so we inherit from it
@Repository
public interface LstRepository extends JpaRepository<Lst, Long> {

}
