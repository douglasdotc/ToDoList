package TodoList.backend.service;

import TodoList.backend.model.Item;
import TodoList.backend.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

// This class holds all the business logic for Item
// TODO: CRUD an item in a board require updating the last edited entry in Board
@Service
@RequiredArgsConstructor // Constructor with Dependency injection
@Transactional // This annotation frees the function from calling queries (E.g. SELECT b from Board b WHERE ...)
@Slf4j // Logs
public class ItemService {
    private final ItemRepository itemRepository; // Interface that use to access the item database

    public List<Item> getItems() {
        log.info("Fetching all items");
        return itemRepository.findAll();
    }

    public Item createItem(Item item) {
        // Different board can have item with the same title and content
        log.info("saving new item ID: {}", item.getItemId());
        return itemRepository.save(item);
    }

    public Boolean updateItem(Long itemId, String title, String content) {
        log.info("Updating item with ID: {}", itemId);
        Item item = itemRepository.findById(itemId).orElseThrow(
            () -> new IllegalStateException("[PUT] Item with id: " + itemId + " does not exist")
        );

        if (title != null && title.length() > 0 && !Objects.equals(item.getTitle(), title)) {
            item.setTitle(title);
        }

        if (content != null && content.length() > 0 && !Objects.equals(item.getContent(), content)) {
            item.setContent(content);
        }
        return true;
    }

    public Boolean deleteItem(Long itemId) {
        log.info("Deleting item with ID: {}", itemId);
        boolean isExist = itemRepository.existsById(itemId);
        if (!isExist) {
            throw new IllegalStateException("[DELETE] Item with id: " + itemId + " does not exist.");
        }
        itemRepository.deleteById(itemId);
        return true;
    }
}
