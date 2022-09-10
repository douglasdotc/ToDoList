package TodoList.backend.repository;

import TodoList.backend.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// This is an interface that access the Tag database
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    @Query("SELECT t from Tag t WHERE t.itemId = :itemId")
    public List<Tag> findTagsByItemId(Long itemId);
}
