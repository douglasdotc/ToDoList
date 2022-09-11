package TodoList.backend.repository;

import TodoList.backend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// This class is an interface that access the item database (a repository)
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("SELECT i FROM Item i WHERE i.title = :title")
    Optional<Item> findItemByTitle(String title);
}
